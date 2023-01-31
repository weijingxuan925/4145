package com.example.blog.controller.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Category;
import com.example.blog.entity.Post;
import com.example.blog.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * (Category)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("categoryController")
public class CategoryController {
    /**
     * dependent object
     */
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @Autowired
    private PostCategoryRefService postCategoryRefService;

    @Autowired
    private UserService userService;

    @GetMapping("/category/{id}")
    public String pageOfList(Model model,
                             @PathVariable("id") Long id,
                             @RequestParam(value = "keywords", defaultValue = "") String keywords,
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        Category category = categoryService.get(id);
        if (category == null) {
            return "redirect:/404";
        }
        LambdaQueryWrapper<Post> queryWrapper = Wrappers.lambdaQuery();
        Page<Post> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));
        StringBuilder pagePrefix = new StringBuilder("/category/" + id + "?");
        // post list
        if (StringUtils.isNotEmpty(keywords)) {
            queryWrapper.like(Post::getPostTitle, keywords).or()
                    .like(Post::getPostContent, keywords);
            pagePrefix = pagePrefix.append("keywords=").append(keywords).append("&");
        }
        queryWrapper.eq(Post::getPostStatus, 1);
        IPage<Post> resultPage = postService.findByCategoryId(id, keywords, pageParam);
        for (Post post : resultPage.getRecords()) {
            post.setCategory(category);
        }
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", pagePrefix);
        model.addAttribute("keywords", keywords);

        // autho info
        model.addAttribute("user", userService.getDefaultUser());

        // category rank
        model.addAttribute("categoryList", categoryService.findAllWithCount());

        // tag rank
        model.addAttribute("tagList", tagService.findAllWithCount());

        model.addAttribute("title", "Post List Of Category " + category.getCateName());
        return "front/post_list";
    }

}