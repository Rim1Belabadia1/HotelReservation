package com.haytam.reservation.soap.config;

import com.haytam.reservation.soap.ws.ChambreSoapService;
import com.haytam.reservation.soap.ws.ClientSoapService;
import com.haytam.reservation.soap.ws.ReservationSoapService;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {
    private final ClientSoapService clientSoapService;
    private final ChambreSoapService chambreSoapService;
    private final ReservationSoapService reservationSoapService;
    private final Bus bus;

    @Bean
    public EndpointImpl chambreEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, chambreSoapService);
        endpoint.publish("/chambrews");
        return endpoint;
    }

    @Bean
    public EndpointImpl clientEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientSoapService);
        endpoint.publish("/clientws");
        return endpoint;
    }

    @Bean
    public EndpointImpl reservationEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationSoapService);
        endpoint.publish("/reservationws");
        return endpoint;
    }
}
