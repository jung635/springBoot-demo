package com.example.demo.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByOrderByIdDesc();
}
