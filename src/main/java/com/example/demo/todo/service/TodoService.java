package com.example.demo.todo.service;

import java.util.List;

import com.example.demo.todo.domain.Todo;

public interface TodoService {
    List<Todo> selectTodoList();
    String insertItem(Todo todo);
}
