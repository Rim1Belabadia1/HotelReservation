package com.haytam.reservation.core.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ClientDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String numTelephone;
    private List<Long> reservationIds = new ArrayList<>();

    public ClientDTO(Long id, String nom, String prenom, String email, String numTelephone, List<Long> reservationIds) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.numTelephone = numTelephone;
        this.reservationIds = reservationIds;
    }

    public ClientDTO() {
        this.reservationIds = new ArrayList<>();
    }
}
