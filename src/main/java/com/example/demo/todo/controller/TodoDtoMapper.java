package com.example.demo.todo.controller;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.demo.todo.domain.Todo;
import com.example.demo.todo.domain.TodoCommand;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface TodoDtoMapper {
    TodoCommand.AddTodoReq of(TodoDto.AddTodoReq req);
}
