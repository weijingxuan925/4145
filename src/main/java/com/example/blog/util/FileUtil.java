package com.example.blog.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * @author JingxuanWei
 * @since 2023/2/23
 */
public class FileUtil {

    /**
     * upload a file and return the path
     * @param file 文件
     * @return URL
     */
    public static String upload(MultipartFile file) {
        String path = "";
        try {
            final StrBuilder uploadPath = new StrBuilder(System.getProperties().getProperty("user.home"));
            uploadPath.append("/sens/upload/").append(String.valueOf(DateUtil.thisYear())).append("/").append(DateUtil.thisMonth() + 1).append("/");
            final File mediaPath = new File(uploadPath.toString());
            if (!mediaPath.exists()) {
                if (!mediaPath.mkdirs()) {
                    throw new Exception("operation failed");
                }
            }
            String nameWithOutSuffix = UUID.randomUUID().toString().replace("-", "");
            final String fileSuffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf('.') + 1);
            String fileName = nameWithOutSuffix + "." + fileSuffix;
            File descFile = new File(mediaPath.getAbsoluteFile(), fileName);
            file.transferTo(descFile);
            final StrBuilder filePath = new StrBuilder("/upload/");
            filePath.append(DateUtil.thisYear());
            filePath.append("/");
            filePath.append(DateUtil.thisMonth() + 1);
            filePath.append("/");
            filePath.append(nameWithOutSuffix).append(".").append(fileSuffix);
            path = filePath.toString().replace("\\", "/");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
