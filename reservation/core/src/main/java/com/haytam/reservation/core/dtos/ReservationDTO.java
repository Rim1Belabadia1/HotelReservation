package com.haytam.reservation.core.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private ClientDTO client;
    private ChambreDTO chambre;
    private Date dateDebut;
    private Date dateFin;
    private String status;
    private Integer nombrePersonnes;

    public ReservationDTO(Long id, ClientDTO client, ChambreDTO chambre, Date dateDebut, Date dateFin, String status, Integer nombrePersonnes) {
        this.id = id;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.status = status;
        this.nombrePersonnes = nombrePersonnes;
    }

    public ReservationDTO() {};
}
