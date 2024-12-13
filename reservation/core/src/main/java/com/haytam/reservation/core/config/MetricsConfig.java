package com.haytam.reservation.core.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

    @Bean
    public Counter reservationUpdatesCounter(MeterRegistry meterRegistry) {
        System.out.println("MeterRegistry Bean initialized: " + meterRegistry);
        return Counter.builder("graphql.reservation.updates")
                .tag("service", "reservation-graphql")
                .register(meterRegistry);
    }

}