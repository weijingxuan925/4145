package com.example.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JingxuanWei
 * Template: esay code
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("tab", "index");
        return "admin/index";
    }
}