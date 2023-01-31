package com.example.blog.controller.admin;

import com.example.blog.dto.JsonResult;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author 言曌
 * @date 2022/1/8 2:31 下午
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * Login page
     *
     * @return
     */
    @GetMapping("/admin/login")
    public String pageOfLogin() {
        return "admin/login";
    }

    @GetMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/admin/login";
    }


    /**
     * Login to submit
     *
     * @param userName
     * @param userPass
     * @return
     */
    @PostMapping("/admin/login")
    @ResponseBody
    public JsonResult loginSubmit(String userName,
                                  String userPass,
                                  HttpSession session) {
        User user = userService.findByUserName(userName);
        if (user == null) {
            return JsonResult.error("Username does not exist");
        }
        if (!Objects.equals(user.getUserPass(), userPass)) {
            return JsonResult.error("Wrong password");
        }
        session.setAttribute("user", user);
        return JsonResult.success("Login successfully");
    }
}
