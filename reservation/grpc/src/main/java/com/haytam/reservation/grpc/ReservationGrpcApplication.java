package com.haytam.reservation.grpc;

import com.haytam.reservation.grpc.server.GrpcServer;
import com.haytam.reservation.grpc.services.GrpcChambreServiceImpl;
import com.haytam.reservation.grpc.services.GrpcClientServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.haytam.reservation.core", "com.haytam.reservation.grpc"})
public class ReservationGrpcApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReservationGrpcApplication.class, args);
        Thread.currentThread().join();

        GrpcServer server = new GrpcServer(
                new GrpcClientServiceImpl(),
                new GrpcChambreServiceImpl()
        );
        server.start();
        Thread.currentThread().join();
    }
}
