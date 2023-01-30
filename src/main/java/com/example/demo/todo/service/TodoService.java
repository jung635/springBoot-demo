package com.example.demo.todo.service;

import java.util.List;

import com.example.demo.todo.domain.Todo;
import com.example.demo.todo.domain.TodoCommand;

public interface TodoService {
    List<Todo> selectTodoList();
    String insertItem(TodoCommand.AddTodoReq command);
}
