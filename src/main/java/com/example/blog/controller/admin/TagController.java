package com.example.blog.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.dto.JsonResult;
import com.example.blog.entity.Tag;
import com.example.blog.entity.Tag;
import com.example.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * (Tag)table controller
 *
 * @author makejava
 * @since 2022-01-08 13:30:00
 */
@Controller("adminTagController")
@RequestMapping("/admin/tag")
public class TagController {
    /**
     * dependent object
     */
    @Autowired
    private TagService tagService;


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

        LambdaQueryWrapper<Tag> queryWrapper = Wrappers.lambdaQuery();
        Page<Tag> pageParam = new Page<>(pageNum, pageSize);
        pageParam.addOrder(OrderItem.desc("id"));

        IPage<Tag> resultPage = tagService.findAll(pageParam, queryWrapper);
        model.addAttribute("pageInfo", resultPage);
        model.addAttribute("pagePrefix", "/admin/tag?");
        model.addAttribute("title", "tag list");
        model.addAttribute("tab", "tag");
        return "admin/tag/list";
    }


    /**
     * Create page
     *
     * @return
     */
    @GetMapping("/create")
    public String pageOfCreate(Model model) {
        model.addAttribute("title", "create tag");
        model.addAttribute("tab", "tag");

        return "admin/tag/create";

    }

    /**
     * edit page
     *
     * @return
     */
    @GetMapping("/edit/{id}")
    public String pageOfEdit(@PathVariable("id") Long id, Model model) {
        Tag tag = tagService.get(id);
        model.addAttribute("tag", tag);
        model.addAttribute("title", "edit tag");
        model.addAttribute("tab", "tag");
        return "admin/tag/edit";

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
        tagService.delete(id);
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
        tagService.batchDelete(ids);
        return JsonResult.success("Successfully batch deleted");
    }

    /**
     * Create action
     *
     * @param tag
     * @return
     */
    @PostMapping("/create")
    @ResponseBody
    public JsonResult create(Tag tag) {
        Tag checkName = tagService.findByTagName(tag.getTagName());
        if (checkName != null) {
            return JsonResult.error("Name already exists");
        }
        tagService.insert(tag);
        return JsonResult.success("Successfully created");
    }

    /**
     * Update action
     *
     * @param tag
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public JsonResult update(Tag tag) {
        tagService.update(tag);
        return JsonResult.success("Successfully updated");
    }

}