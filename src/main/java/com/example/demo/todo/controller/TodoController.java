package com.example.demo.todo.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.todo.common.response.CommonResponse;
import com.example.demo.todo.domain.Todo;
import com.example.demo.todo.domain.TodoCommand;
import com.example.demo.todo.service.TodoService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;
    private final TodoDtoMapper TodoDtoMapper;
    
    @GetMapping("todo")
    public List<Todo> getList() {
        return todoService.selectTodoList();
    }

    @PostMapping(value="/todo")
    public CommonResponse<String> addItem(@RequestBody TodoDto.AddTodoReq todoReq) {
        log.debug("todoReq: " + todoReq.toString());
        TodoCommand.AddTodoReq req = TodoDtoMapper.of(todoReq);
        String token = todoService.insertItem(req);
        return CommonResponse.success(token);
    }
    
}
