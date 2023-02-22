package com.example.demo.todo.config;

import com.example.demo.todo.service.impl.grpc.TodoGrpcServiceImpl;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcServerConfig {

    private static final Integer PORT = 9090;

    // service 구현체 bean을 주입받음
    private final TodoGrpcServiceImpl rpcService;

    public GrpcServerConfig(TodoGrpcServiceImpl rpcService) {
        this.rpcService = rpcService;
    }

    @Bean
    public Server grpcServer() {
        return Grpc.newServerBuilderForPort(PORT, InsecureServerCredentials.create())
                .addService(rpcService)
                .build();
    }
}
