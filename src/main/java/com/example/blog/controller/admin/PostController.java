package com.example.blog.controller.admin;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.*;
import com.example.blog.entity.Post;
import com.example.blog.entity.Post;
import com.example.blog.service.*;
import com.example.blog.util.ListUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

/**
 * (Post)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("adminPostController")
@RequestMapping("/admin/post")
public class PostController {
    /**
     * dependent object
     */
    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostCategoryRefService postCategoryRefService;

    @Autowired
    private PostTagRefService postTagRefService;


    /**
     * Paginated query page
     *
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping
    public String pageOfList(Model model,
                             @RequestParam(value = "status", defaultValue = "-1") Integer status,
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {

        LambdaQueryWrapper<Post> queryWrapper = Wrappers.lambdaQuery();
        Page<Post> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));
        if (status != -1) {
            queryWrapper.eq(Post::getPostStatus, status);
        }
        IPage<Post> resultPage = postService.findAll(pageParam, queryWrapper);
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", "/admin/post?status=" + status + "&");
        model.addAttribute("title", "post list");
        model.addAttribute("tab", "post");

        return "admin/post/list";
    }


    /**
     * Create page
     *
     * @return
     */
    @GetMapping("/create")
    public String pageOfCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("title", "create post");
        model.addAttribute("tab", "post");

        return "admin/post/create";

    }

    /**
     * edit page
     *
     * @return
     */
    @GetMapping("/edit/{id}")
    public String pageOfEdit(@PathVariable("id") Long id, Model model) {
        Post post = postService.get(id);
        model.addAttribute("post", post);
        model.addAttribute("title", "edit post");
        model.addAttribute("tab", "post");
        model.addAttribute("categories", categoryService.findAll());

        List<Tag> tagList = postTagRefService.findByPostId(id);
        List<String> tagNames = tagList.stream().map(p -> p.getTagName()).collect(Collectors.toList());
        model.addAttribute("tags", ListUtil.list2Str(tagNames));


        Category category = postCategoryRefService.findByPostId(id);
        if (category != null) {
            model.addAttribute("cateId", category.getId());
        }

        return "admin/post/edit";

    }


    /**
     * Paginated query list
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") Long id) {
        postService.delete(id);
        return JsonResult.success("Successfully deleted");
    }

    /**
     * Batch delete action
     *
     * @param ids
     * @return
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public JsonResult delete(@RequestParam("ids") List<Long> ids) {
        postService.batchDelete(ids);
        return JsonResult.success("Successfully batch deleted");
    }

    /**
     * Create action
     *
     * @param post
     * @return
     */
    @PostMapping("/create")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public JsonResult create(Post post, Long cateId, String tags) {

        int postSummaryLength = 100;
        String summaryText = HtmlUtil.cleanHtmlTag(post.getPostContent());
        if (summaryText.length() > postSummaryLength) {
            summaryText = summaryText.substring(0, postSummaryLength);
        }
        summaryText = summaryText.replace("\n", "");
        post.setPostSummary(summaryText);

        post.setPostViews(0L);
        postService.insert(post);

        // insert category
        if (cateId != null) {
            PostCategoryRef postCategoryRef = new PostCategoryRef();
            postCategoryRef.setPostId(post.getId());
            postCategoryRef.setCateId(cateId);
            postCategoryRefService.insert(postCategoryRef);
        }

        // insert tags
        if (StringUtils.isNotEmpty(tags)) {
            String[] tagArr = tags.split(",|，");
            for (String tagName : tagArr) {
                Tag tag = tagService.findByTagName(tagName);
                if (tag == null) {
                    tag = new Tag();
                    tag.setTagName(tagName);
                    tagService.insert(tag);
                }
                PostTagRef postTagRef = new PostTagRef();
                postTagRef.setPostId(post.getId());
                postTagRef.setTagId(tag.getId());
                postTagRefService.insert(postTagRef);
            }
        }

        return JsonResult.success("Successfully created");
    }

    /**
     * Update action
     *
     * @param post
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Post post, Long cateId, String tags) {
        int postSummaryLength = 100;
        String summaryText = HtmlUtil.cleanHtmlTag(post.getPostContent());
        if (summaryText.length() > postSummaryLength) {
            summaryText = summaryText.substring(0, postSummaryLength);
        }
        summaryText = summaryText.replace("\n", "");
        post.setPostSummary(summaryText);

        postService.update(post);

        // insert category
        if (cateId != null) {
            postCategoryRefService.deleteByPostId(post.getId());
            PostCategoryRef postCategoryRef = new PostCategoryRef();
            postCategoryRef.setPostId(post.getId());
            postCategoryRef.setCateId(cateId);
            postCategoryRefService.insert(postCategoryRef);
        }

        // insert tags
        if (StringUtils.isNotEmpty(tags)) {
            postTagRefService.deleteByPostId(post.getId());
            String[] tagArr = tags.split(",|，");
            for (String tagName : tagArr) {
                Tag tag = tagService.findByTagName(tagName);
                if (tag == null) {
                    tag = new Tag();
                    tag.setTagName(tagName);
                    tagService.insert(tag);
                }
                PostTagRef postTagRef = new PostTagRef();
                postTagRef.setPostId(post.getId());
                postTagRef.setTagId(tag.getId());
                postTagRefService.insert(postTagRef);
            }
        }
        return JsonResult.success("Successfully updated");
    }
}