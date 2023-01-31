package com.example.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.User;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * (User)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {
    /**
     * dependent object
     */
    @Autowired
    private UserService userService;

    /**
     * Paginated query page
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/profile")
    public String profile(Model model, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userService.get(sessionUser.getId());
        model.addAttribute("user", user);
        model.addAttribute("tab", "profile");
        model.addAttribute("title", "user profile");
        return "admin/user/profile";
    }

    /**
     * Update action
     *
     * @param user
     * @return
     */
    @PostMapping("/profile/update")
    @ResponseBody
    public JsonResult update(User user, HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        user.setId(sessionUser.getId());
        userService.update(user);

        session.setAttribute("user", user);
        return JsonResult.success("Successfully updated");
    }


    /**
     * 处理修改密码的请求
     *
     * @param beforePass 旧密码
     * @param newPass    新密码
     * @return JsonResult
     */
    @PostMapping(value = "/changePass")
    @ResponseBody
    public JsonResult changePass(
            @RequestParam("beforePass") String beforePass,
            @RequestParam("newPass") String newPass,
            HttpSession session) {
        User sessionUser = (User) session.getAttribute("user");
        User user = userService.get(sessionUser.getId());
        if(user != null && !Objects.equals(user.getUserPass(), beforePass)) {
            return JsonResult.error("Old password is wrong");
        }
        user.setUserPass(newPass);
        userService.update(user);
        return JsonResult.success("Successfully updated");
    }

}