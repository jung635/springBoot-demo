package com.example.demo;

import io.grpc.Server;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component //ApplicationRunner를 component로 등록하면 실행된다.
public class ServerRunner implements ApplicationRunner, DisposableBean {

    // config의 grpc bean을 주입받습니다
    private final Server grpcServer;

    public ServerRunner(Server grpcServer) {
        this.grpcServer = grpcServer;
    }

    // grpc는 스프링과는 별도로 구동시켜야 하므로 runner 사용합니다
    @Override
    public void run(ApplicationArguments args) throws Exception {
        grpcServer.start();
        grpcServer.awaitTermination();
    }

    @Override
    public void destroy() throws Exception {
        if (!ObjectUtils.isEmpty(grpcServer)) {
            grpcServer.shutdown();
        }
    }

}
