package com.haytam.reservation.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.haytam.reservation.core", "com.haytam.reservation.graphql"})
public class ReservationGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationGraphqlApplication.class, args);
    }
}