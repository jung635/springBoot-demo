package com.example.demo.todo.common.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommonResponse<T> {
    private Result result;
    private String message;
    private String errorCode;
    private T data;
    
    @SuppressWarnings("unchecked")
    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
            .result(Result.SUCESS)
            .data(data)
            .message(message)
            .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> CommonResponse<T> success(T data) {
        return (CommonResponse<T>) CommonResponse.builder()
            .result(Result.SUCESS)
            .data(data)
            .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> CommonResponse<T> fail(ErrorCode errorCode){
        return (CommonResponse<T>) CommonResponse.builder()
            .result(Result.FAIL)
            .message(errorCode.getMessage())
            .errorCode(errorCode.name())
            .build();
    }

    @SuppressWarnings("unchecked")
    public static <T> CommonResponse<T> fail(T data, String errorCode) {
        return (CommonResponse<T>) CommonResponse.builder()
            .result(Result.FAIL)
            .data(data)
            .errorCode(errorCode)
            .build();
    }

    public enum Result{
        SUCESS, FAIL
    }
}
