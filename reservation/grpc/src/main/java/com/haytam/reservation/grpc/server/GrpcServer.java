package com.haytam.reservation.grpc.server;

import com.haytam.reservation.grpc.services.GrpcClientServiceImpl;
import com.haytam.reservation.grpc.services.GrpcChambreServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GrpcServer {

    private final int port = 9092;
    private Server server;

    private final GrpcClientServiceImpl clientService;
//    private final GrpcReservationServiceImpl reservationService;
    private final GrpcChambreServiceImpl chambreService;

    @Autowired
    public GrpcServer(GrpcClientServiceImpl clientService,
                      GrpcChambreServiceImpl chambreService) {
        this.clientService = clientService;
//        this.reservationService = reservationService;
        this.chambreService = chambreService;
    }

    @PostConstruct
    public void start() throws Exception {
        server = ServerBuilder.forPort(port)
                .addService(clientService)
//                .addService(reservationService)
                .addService(chambreService)
                .build()
                .start();
        System.out.println("gRPC server started on port " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server...");
            stop();
        }));
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.shutdown();
            System.out.println("gRPC server stopped.");
        }
    }
}
