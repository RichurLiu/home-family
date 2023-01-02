package com.home.family.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Project : home-family
 * @Package : com.home.family.common.vo
 * @Author : richur
 * @Date : 2023/1/2 11:26 上午
 */
@Setter
@Getter
public class ResultResponse<T> {
    private String msg;
    private Integer code;
    private T data;

    public static <T> ResultResponse<T> success() {
        ResultResponse<T> response = new ResultResponse<>();
        response.setMsg("success");
        response.setCode(0);
        return response;
    }

    public static <T> ResultResponse<T> success(T data) {
        ResultResponse<T> response = new ResultResponse<>();
        response.setMsg("success");
        response.setCode(0);
        response.setData(data);
        return response;
    }

    public static <T> ResultResponse<T> fail(String msg, Integer code) {
        ResultResponse<T> response = new ResultResponse<>();
        response.setMsg(msg);
        response.setCode(code);
        return response;
    }


    public static <T> ResultResponse<T> fail() {
        ResultResponse<T> response = new ResultResponse<>();
        response.setMsg("fail");
        response.setCode(-1);
        return response;
    }
}
