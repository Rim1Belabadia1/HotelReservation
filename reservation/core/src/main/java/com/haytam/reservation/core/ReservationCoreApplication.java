package com.haytam.reservation.core;

import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Client;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.StatusReservation;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import com.haytam.reservation.core.repositories.ClientRepository;
import com.haytam.reservation.core.repositories.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.haytam.reservation.core.repositories")
@EntityScan(basePackages = "com.haytam.reservation.core.entities")
public class ReservationCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationCoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataInitializer(
            ClientRepository clientRepository,
            ChambreRepository chambreRepository,
            ReservationRepository reservationRepository) {
        return args -> {
            Client client1 = Client.builder().nom("Smith").prenom("John").email("john.smith@example.com").numTelephone("123456789").build();
            Client client2 = Client.builder().nom("Doe").prenom("Jane").email("jane.doe@example.com").numTelephone("987654321").build();
            Client client3 = Client.builder().nom("Brown").prenom("Charlie").email("charlie.brown@example.com").numTelephone("456789123").build();
            Client client4 = Client.builder().nom("Taylor").prenom("Emma").email("emma.taylor@example.com").numTelephone("789123456").build();
            clientRepository.saveAll(List.of(client1, client2, client3, client4));

            Chambre chambre1 = Chambre.builder().typeChambre(TypeChambre.SINGLE).prix(BigDecimal.valueOf(50)).disponible(true).numeroChambre("101").description("Single room").build();
            Chambre chambre2 = Chambre.builder().typeChambre(TypeChambre.SINGLE).prix(BigDecimal.valueOf(55)).disponible(true).numeroChambre("102").description("Single room").build();
            Chambre chambre3 = Chambre.builder().typeChambre(TypeChambre.DOUBLE).prix(BigDecimal.valueOf(100)).disponible(true).numeroChambre("201").description("Double room").build();
            Chambre chambre4 = Chambre.builder().typeChambre(TypeChambre.DOUBLE).prix(BigDecimal.valueOf(110)).disponible(true).numeroChambre("202").description("Double room").build();
            Chambre chambre5 = Chambre.builder().typeChambre(TypeChambre.SUITE).prix(BigDecimal.valueOf(200)).disponible(true).numeroChambre("301").description("Suite").build();
            Chambre chambre6 = Chambre.builder().typeChambre(TypeChambre.SUITE).prix(BigDecimal.valueOf(250)).disponible(true).numeroChambre("302").description("Luxury Suite").build();
            chambreRepository.saveAll(List.of(chambre1, chambre2, chambre3, chambre4, chambre5, chambre6));

            Reservation reservation1 = Reservation.builder()
                    .client(client1).chambre(chambre1).dateDebut(new Date()).dateFin(new Date(System.currentTimeMillis() + 86400000))
                    .status(StatusReservation.CONFIRMED).nombrePersonnes(1).build();
            Reservation reservation2 = Reservation.builder()
                    .client(client2).chambre(chambre3).dateDebut(new Date()).dateFin(new Date(System.currentTimeMillis() + 86400000 * 2))
                    .status(StatusReservation.CONFIRMED).nombrePersonnes(2).build();
            Reservation reservation3 = Reservation.builder()
                    .client(client3).chambre(chambre5).dateDebut(new Date()).dateFin(new Date(System.currentTimeMillis() + 86400000 * 3))
                    .status(StatusReservation.CONFIRMED).nombrePersonnes(3).build();
            Reservation reservation4 = Reservation.builder()
                    .client(client4).chambre(chambre2).dateDebut(new Date()).dateFin(new Date(System.currentTimeMillis() + 86400000 * 4))
                    .status(StatusReservation.CONFIRMED).nombrePersonnes(1).build();
            reservationRepository.saveAll(List.of(reservation1, reservation2, reservation3, reservation4));
        };
    }
}
