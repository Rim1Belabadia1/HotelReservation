package com.haytam.reservation.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.haytam.reservation.core", "com.haytam.reservation.rest"})
public class ReservationRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationRestApplication.class, args);
    }
}
