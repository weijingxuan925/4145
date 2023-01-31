package com.example.blog.controller.home;

import com.example.blog.dto.JsonResult;
import com.example.blog.entity.Comment;
import com.example.blog.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Comment)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("commentController")
public class CommentController {
    /**
     * dependent object
     */
    @Autowired
    private CommentService commentService;


    /**
     * comment submit
     * @param comment
     * @return
     */
    @PostMapping("/comment")
    @ResponseBody
    public JsonResult comment(Comment comment) {
        if (StringUtils.isEmpty(comment.getAuthorName()) ||
                StringUtils.isEmpty(comment.getAuthorEmail()) ||
                StringUtils.isEmpty(comment.getAuthorEmail()) ||
                comment.getCommentParent() == null ||
                comment.getPostId() == null) {
            return JsonResult.error("Please enter complete information");
        }
        comment.setCreateTime(new Date());
        comment.setAuthorAvatar("https://eu.ui-avatars.com/api/?background=random&length=1&rounded=true&bold=true&name=" + comment.getAuthorName());
        commentService.insert(comment);
        return JsonResult.success("Successfully commented");
    }
}