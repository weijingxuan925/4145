package com.example.blog.controller.admin;

import com.example.blog.dto.JsonResult;
import com.example.blog.util.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 言曌
 * @date 2022/1/8 5:49 下午
 */
@Controller
public class FileController {


    public final String IMG_SUFFIX = ".bmp.jpg.jpeg.png.gif";


    @PostMapping(value = "/file/upload/img")
    @ResponseBody
    public JsonResult uploadImg(@RequestParam("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));

        if (IMG_SUFFIX.indexOf(suffix.toLowerCase()) == -1) {
            return JsonResult.error("Please upload image file");
        }

        if (file.getSize() > 1000 * 1000 * 10) {
            return JsonResult.error("Please upload an image less than 10MB");
        }
        String result = FileUtil.upload(file);
        if (StringUtils.isEmpty(result)) {
            return JsonResult.error("Image upload failed");
        }
        return JsonResult.success("success", result);
    }

    /**
     * 上传文件
     *
     * @param file file
     * @return Map
     */
    @PostMapping(value = "/admin/file/upload", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, Object> map = new HashMap<>(1);
        String result = FileUtil.upload(file);
        map.put("location", result);
        return map;
    }


}
