package com.example.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.Comment;
import com.example.blog.entity.User;
import com.example.blog.service.CommentService;
import com.example.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Admin comment controller
 * @author JingxuanWei
 * @since 2023/2/17
 */
@Controller("adminCommentController")
// the admin comment controller
@RequestMapping("/admin/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    /**
     * Paginated query page
     * @param model   is the model
     * @param pageNum is the page number
     * @param pageSize is the page size
     * @return the page
     */
    @GetMapping
    public String pageOfList(Model model,
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {

        LambdaQueryWrapper<Comment> queryWrapper = Wrappers.lambdaQuery();
        Page<Comment> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));

        IPage<Comment> resultPage = commentService.findAll(pageParam, queryWrapper);
        for (Comment item : resultPage.getRecords()) {
            item.setPost(postService.get(item.getPostId()));
        }
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", "/admin/comment?");
        model.addAttribute("title", "comment list");
        model.addAttribute("tab", "comment");
        return "admin/comment/list";
    }


    /**
     * Create page of comment
     * @return the page
     */
    @GetMapping("/reply/{id}")
    public String pageOfCreate(@PathVariable("id") Long id, Model model) {
        Comment comment = commentService.get(id);
        model.addAttribute("comment", comment);
        model.addAttribute("title", "create comment");
        model.addAttribute("tab", "comment");
        return "admin/comment/reply";
    }


    /**
     * edit page of comment
     * @return the page
     */
    @GetMapping("/edit/{id}")
    public String pageOfEdit(@PathVariable("id") Long id, Model model) {
        Comment comment = commentService.get(id);
        model.addAttribute("comment", comment);
        model.addAttribute("title", "edit comment");
        model.addAttribute("tab", "comment");
        return "admin/comment/edit";
    }


    /**
     * Paginated query list action
     * @param id    id
     * @return JsonResult
     */
    @PostMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestParam("id") Long id) {
        commentService.delete(id);
        return JsonResult.success("Successfully deleted !");
    }

    /**
     * Batch delete action (delete multiple)
     *
     * @param ids id list
     * @return JsonResult
     */
    @PostMapping("/batchDelete")
    @ResponseBody
    public JsonResult delete(@RequestParam("ids") List<Long> ids) {
        commentService.batchDelete(ids);
        return JsonResult.success("Successfully batch deleted !");
    }

    /**
     * Create action (reply)
     *
     * @param comment comment
     * @return JsonResult
     */
    @PostMapping("/reply")
    @ResponseBody
    public JsonResult create(Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        comment.setAuthorName(user.getUserDisplayName());
        comment.setAuthorEmail(user.getUserEmail());
        comment.setAuthorAvatar(user.getUserAvatar());
        commentService.insert(comment);
        return JsonResult.success("Successfully replied !");
    }


    /**
     * Update action (edit)
     *
     * @param comment comment
     * @return JsonResult
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Comment comment) {
        commentService.update(comment);
        return JsonResult.success("Successfully updated !");
    }
}