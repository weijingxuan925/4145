package com.example.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Category)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
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