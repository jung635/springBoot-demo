package com.example.demo.todo.controller;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

public class TodoDto {

    @ToString
    @Getter
    @Builder
    public static class AddTodoReq {
        private String title;
        private LocalDateTime expectedDate;
    }
}
