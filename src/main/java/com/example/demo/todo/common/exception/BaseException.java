package com.example.demo.todo.common.exception;

import com.example.demo.todo.common.response.ErrorCode;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ErrorCode errorCode;

    public BaseException() {
    }
    
}
