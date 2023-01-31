package com.example.blog.util;

import java.util.List;

/**
 * @author 言曌
 * @date 2022/1/8 7:23 下午
 */

public class ListUtil {

    public static String list2Str(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb = sb.append(str).append(",");
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }
}
