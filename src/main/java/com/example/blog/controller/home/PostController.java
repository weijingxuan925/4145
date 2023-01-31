package com.example.blog.controller.home;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.Category;
import com.example.blog.entity.Comment;
import com.example.blog.entity.Post;
import com.example.blog.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (Category)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("postController")
public class PostController {
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
    private PostTagRefService postTagRefService;


    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/post/{id}")
    public String pageOfList(Model model,
                             @PathVariable("id") Long id,
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        Post post = postService.get(id);
        if (post == null) {
            return "redirect:/404";
        }
        model.addAttribute("post", post);
        LambdaQueryWrapper<Comment> queryWrapper = Wrappers.lambdaQuery();
        Page<Comment> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));
        // comment list
        queryWrapper.eq(Comment::getPostId, id);
        queryWrapper.eq(Comment::getCommentParent, 0);
        IPage<Comment> resultPage = commentService.findAll(pageParam, queryWrapper);
        for (Comment comment : resultPage.getRecords()) {
            List<Comment> commentList = commentService.findByCommentParent(comment.getId());
            comment.setChildCommentList(commentList);
        }
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", "/post/" + id + "?");

        model.addAttribute("currentTagList", postTagRefService.findByPostId(id));
        model.addAttribute("currentCategory", postCategoryRefService.findByPostId(id));

        // autho info
        model.addAttribute("user", userService.getDefaultUser());

        // category rank
        model.addAttribute("categoryList", categoryService.findAllWithCount());

        // tag rank
        model.addAttribute("tagList", tagService.findAllWithCount());

        model.addAttribute("title", post.getPostTitle());
        return "front/post_detail";
    }

}