package com.haytam.reservation.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.haytam.reservation.core", "com.haytam.reservation.soap"})
public class ReservationSoapApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationSoapApplication.class, args);
    }
}
