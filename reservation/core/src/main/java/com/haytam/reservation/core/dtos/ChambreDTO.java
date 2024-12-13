package com.haytam.reservation.core.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ChambreDTO {
    private Long id;

    @NotNull
    private String typeChambre;

    @Positive
    private BigDecimal prix;

    private Boolean disponible;
    private String numeroChambre;
    private String description;
    private List<Long> reservationIds;

    public ChambreDTO(Long id, String typeChambre, BigDecimal prix, Boolean disponible, String numeroChambre, String description, List<Long> reservationIds) {
        this.id = id;
        this.typeChambre = typeChambre;
        this.prix = prix;
        this.disponible = disponible;
        this.numeroChambre = numeroChambre;
        this.description = description;
        this.reservationIds = reservationIds;
    }

    public ChambreDTO() {}
}
