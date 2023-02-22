package com.example.demo.todo.service.impl.grpc;


import com.example.demo.todo.domain.Todo;
import com.example.demo.todo.service.TodoService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.grpc.lib.TodoAddReply;
import org.example.grpc.lib.TodoAddRequest;
import org.example.grpc.lib.TodoGrpc;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
@Slf4j
@RequiredArgsConstructor
public class TodoGrpcServiceImpl extends TodoGrpc.TodoImplBase {
    private final TodoService todoService;

    @Override
    public void addTodo(TodoAddRequest request, StreamObserver<TodoAddReply> responseObserver) {
        log.info("TodoGrpcServiceImpl HelloRequest ==> " + request.toString());
        Todo inputTodo = Todo.builder()
                .title(request.getTitle())
                .expectedDate(LocalDateTime.parse(request.getExpectedDate(), DateTimeFormatter.ISO_DATE_TIME))
                .userId(Long.parseLong(request.getUserId()))
                .build();

        String token = todoService.insertItem(inputTodo);

        TodoAddReply reply = TodoAddReply.newBuilder()
                .setMessage(token)
                .build();

        log.info("TodoGrpcServiceImpl HelloRequest ==> " + reply.toString());
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
