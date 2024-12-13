package com.haytam.reservation.graphql.controllers;

import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.graphql.services.GraphqlChambreService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ChambreControllerGraphQL {

    private final GraphqlChambreService chambreService;

    @MutationMapping
    public ChambreDTO saveChambre(@Argument ChambreDTO chambreDTO) {
        return chambreService.saveChambre(chambreDTO);
    }

    @QueryMapping
    public List<ChambreDTO> allChambres() {
        return chambreService.getAllChambres();
    }

    @QueryMapping
    public ChambreDTO chambreById(@Argument Long id) {
        return chambreService.getChambreById(id);
    }

    @MutationMapping
    public String deleteChambre(@Argument Long id) {
        chambreService.deleteChambre(id);
        return "Chambre deleted successfully";
    }

    @MutationMapping
    public ChambreDTO updateChambre(@Argument Long id, @Argument ChambreDTO chambreDTO) {
        return chambreService.updateChambre(id, chambreDTO);
    }

}
