package com.example.demo.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.todo.domain.Todo;
import com.example.demo.todo.domain.TodoCommand;
import com.example.demo.todo.repository.TodoRepository;
import com.example.demo.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> selectTodoList() {
        return todoRepository.findAllByOrderByIdDesc();
    }

    @Override
    @Transactional
    public String insertItem(TodoCommand.AddTodoReq command) {
        Todo resultTodo = todoRepository.save(command.toEntity());
        return resultTodo.getToken();
    }
    
}
