package com.example.demo.todo.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

public class TodoCommand {

    @Getter
    @Builder
    public static class AddTodoReq {
        private String title;
        private LocalDateTime expectedDate;

        public Todo toEntity() {
            return Todo.builder()
                .title(title)
                .expectedDate(expectedDate)
                .build();
        }
    }
}
