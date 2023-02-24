package com.example.blog.util;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JingxuanWei
 * @since 2023/2/23
 */

public class ListUtil {

    public static String list2Str(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
