package com.example.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.Category;
import com.example.blog.entity.Tag;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * (Category)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
    /**
     * dependent object
     */
    @Autowired
    private CategoryService categoryService;

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
                             @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {

        LambdaQueryWrapper<Category> queryWrapper = Wrappers.lambdaQuery();
        Page<Category> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));

        IPage<Category> resultPage = categoryService.findAll(pageParam, queryWrapper);
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", "/admin/category?");
        model.addAttribute("title", "category list");
        model.addAttribute("tab", "category");
        return "admin/category/list";
    }


    /**
     * Create page
     *
     * @return
     */
    @GetMapping("/create")
    public String pageOfCreate(Model model) {
        model.addAttribute("title", "create category");
        model.addAttribute("tab", "category");
        return "admin/category/create";

    }

    /**
     * edit page
     *
     * @return
     */
    @GetMapping("/edit/{id}")
    public String pageOfEdit(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.get(id);
        model.addAttribute("category", category);
        model.addAttribute("title", "edit category");
        model.addAttribute("tab", "category");
        return "admin/category/edit";

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
        categoryService.delete(id);
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
        categoryService.batchDelete(ids);
        return JsonResult.success("Successfully batch deleted");
    }

    /**
     * Create action
     *
     * @param category
     * @return
     */
    @PostMapping("/create")
    @ResponseBody
    public JsonResult create(Category category) {
        Category checkName = categoryService.findByCateName(category.getCateName());
        if (checkName != null) {
            return JsonResult.error("Name already exists");
        }
        categoryService.insert(category);
        return JsonResult.success("Successfully created");
    }

    /**
     * Update action
     *
     * @param category
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Category category) {
        categoryService.update(category);
        return JsonResult.success("Successfully updated");
    }

}