package com.haytam.reservation.graphql.services;

import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.Reservation;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import com.haytam.reservation.core.repositories.ReservationRepository;
import com.haytam.reservation.core.dtos.ChambreDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphqlChambreService {

    private final ChambreRepository chambreRepository;
    private final ReservationRepository reservationRepository;

    public GraphqlChambreService(ChambreRepository chambreRepository, ReservationRepository reservationRepository) {
        this.chambreRepository = chambreRepository;
        this.reservationRepository = reservationRepository;
    }

    public ChambreDTO saveChambre(ChambreDTO chambreDTO) {
        Chambre chambre = mapToEntity(chambreDTO);
        Chambre savedChambre = chambreRepository.save(chambre);
        return mapToDto(savedChambre);
    }

    public List<ChambreDTO> getAllChambres() {
        return chambreRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ChambreDTO getChambreById(Long id) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));
        return mapToDto(chambre);
    }

    public void deleteChambre(Long id) {
        if (!chambreRepository.existsById(id)) {
            throw new RuntimeException("Chambre not found for deletion");
        }
        chambreRepository.deleteById(id);
    }

    public ChambreDTO updateChambre(Long id, ChambreDTO chambreDTO) {
        Chambre chambre = chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found"));

        // Check if the new data is different before saving
        if (!chambre.getTypeChambre().toString().equals(chambreDTO.getTypeChambre()) ||
                !chambre.getPrix().equals(chambreDTO.getPrix()) ||
                !chambre.getDisponible().equals(chambreDTO.getDisponible()) ||
                !chambre.getNumeroChambre().equals(chambreDTO.getNumeroChambre()) ||
                !chambre.getDescription().equals(chambreDTO.getDescription())) {

            chambre.setTypeChambre(TypeChambre.valueOf(chambreDTO.getTypeChambre()));
            chambre.setPrix(chambreDTO.getPrix());
            chambre.setDisponible(chambreDTO.getDisponible());
            chambre.setNumeroChambre(chambreDTO.getNumeroChambre());
            chambre.setDescription(chambreDTO.getDescription());

            Chambre updatedChambre = chambreRepository.save(chambre);
            return mapToDto(updatedChambre);
        }

        return mapToDto(chambre);  // No change, return existing chambre
    }

    private ChambreDTO mapToDto(Chambre chambre) {
        List<Long> reservationIds = chambre.getReservations().stream()
                .map(Reservation::getId)
                .collect(Collectors.toList());

        return new ChambreDTO(
                chambre.getId(),
                chambre.getTypeChambre().toString(),
                chambre.getPrix(),
                chambre.getDisponible(),
                chambre.getNumeroChambre(),
                chambre.getDescription(),
                reservationIds
        );
    }

    private Chambre mapToEntity(ChambreDTO chambreDTO) {
        return Chambre.builder()
                .id(chambreDTO.getId())
                .typeChambre(TypeChambre.valueOf(chambreDTO.getTypeChambre()))
                .prix(chambreDTO.getPrix())
                .disponible(chambreDTO.getDisponible())
                .numeroChambre(chambreDTO.getNumeroChambre())
                .description(chambreDTO.getDescription())
                .build();
    }
}
