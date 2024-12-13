package com.haytam.reservation.core.entities;

import com.haytam.reservation.core.entities.enums.TypeChambre;
import jakarta.persistence.*;
import lombok.*;
import jakarta.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @XmlElement
    private TypeChambre typeChambre;

    private BigDecimal prix;

    private Boolean disponible;

    private String numeroChambre;

    private String description;

    @XmlTransient
    @ToString.Exclude
    @OneToMany(mappedBy = "chambre", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

}
