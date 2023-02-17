package com.example.blog.dto;
import lombok.Data;

/**
 *
 * @author : JingxuanWei
 * @date : 2023/2/17
 */
@Data
public class JsonResult {
    private Integer code;
    private String msg;
    private Object result;

    /**
     * @param code is the code
     * @param message  is the information to be returned
     */
    public JsonResult(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    public JsonResult(Integer code, String message, Object result) {
        this.code = code;
        this.msg = message;
        this.result = result;
    }
    /**
     * @param code is the code
     * @param result is the result
     */
    public JsonResult(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }
    public static JsonResult error(String msg) {
        return new JsonResult(0, msg);
    }
    public static JsonResult error(String msg, Object data) {
        return new JsonResult(0, msg, data);
    }
    public static JsonResult success() {
        return new JsonResult(1, "Success!!");
    }
    public static JsonResult success(String msg) {
        return new JsonResult(1, msg);
    }
    public static JsonResult success(String msg, Object result) {
        return new JsonResult(1, msg, result);
    }
}
