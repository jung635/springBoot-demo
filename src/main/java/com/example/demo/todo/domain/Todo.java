package com.example.demo.todo.domain;

import java.security.InvalidParameterException;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import com.example.demo.todo.common.utils.TokenGenerator;

import lombok.Builder;
import lombok.Getter;

@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "todo")
public class Todo extends AbstractEntity{
    private static final String TODO_PREFIX = "todo_";
    private static final int TOKEN_LENGTH = 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private String title;
    private LocalDateTime expectedDate;
    @Enumerated(EnumType.STRING)
    private STATUS status;
    private Long userId;

    @Builder
    public Todo(String title, LocalDateTime expectedDate, Long userId) {
        if(StringUtils.isBlank(title)) throw new InvalidParameterException("Todo.title");
        this.title = title;
        this.expectedDate = expectedDate;
        this.userId = userId;
        this.token = TokenGenerator.generateRandomCharWithPrefix(TODO_PREFIX, TOKEN_LENGTH);
        this.status = STATUS.OPEN;
    }


    @Getter
    public enum STATUS {
        OPEN, ClOSED, INPROGRESS, COMPLETE
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", title='" + title + '\'' +
                ", expectedDate=" + expectedDate +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
