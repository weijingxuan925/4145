package com.example.blog.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : JingxuanWei
 * @since  : 2023/2/17
 */
@Data
@NoArgsConstructor
public class JsonResult {
    private Integer code;
    private String msg;
    private Object result;

    /**
     * @param code is the code
     * @param msg  is the msg need to return
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @param code is the code need to return
     * @param msg is the message need to return
     * @param result is the result need to return
     */
    public JsonResult(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * @param code is the code
     * @param result is the result
     * @deprecated 无使用场景
     */
    public JsonResult(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }
    public static JsonResult success(String message) {
        return new JsonResult(1, message);
    }
    public static JsonResult success(String message, Object result) {
        return new JsonResult(1, message, result);
    }
    public static JsonResult error(String message) {
        return new JsonResult(0, message);
    }
    public static JsonResult success() {
        return new JsonResult(1, "Successfully!");
    }
    public static JsonResult error(String message, Object data) {
        return new JsonResult(0, message, data);
    }
}
