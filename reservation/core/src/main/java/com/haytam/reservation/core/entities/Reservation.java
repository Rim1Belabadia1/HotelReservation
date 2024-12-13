package com.haytam.reservation.core.entities;

import com.haytam.reservation.core.entities.enums.StatusReservation;
import jakarta.persistence.*;
import lombok.*;
import jakarta.xml.bind.annotation.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "chambre_id", nullable = false)
    private Chambre chambre;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dateFin;

    @Enumerated(EnumType.STRING)
    private StatusReservation status;

    private Integer nombrePersonnes;
}
