package com.huimu.flowerplant.common.web;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {

    private Boolean success;

    private Integer code;

    private String msg;

    private T data;

    public static <T> Response<T> success(String msg, T data) {
        Response<T> response = success();
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = success();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> fail(Integer code, String msg, T data) {
        Response<T> response = fail();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    private static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setSuccess(true);
        response.setCode(0);
        return response;
    }

    private static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

}
