package com.haytam.reservation.rest.services.impl;

import com.haytam.reservation.rest.services.RestChambreService;
import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("restChambreServiceImpl")
public class RestChambreServiceImpl implements RestChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<ChambreDTO> getAllChambres() {
        return chambreRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChambreDTO getChambreById(Long id) {
        Optional<Chambre> chambre = chambreRepository.findById(id);
        return chambre.map(this::toDTO).orElse(null);
    }

    @Override
    public ChambreDTO createChambre(ChambreDTO chambreDTO) {
        Chambre chambre = toEntity(chambreDTO);
        Chambre savedChambre = chambreRepository.save(chambre);
        return toDTO(savedChambre);
    }

    @Override
    public ChambreDTO updateChambre(Long id, ChambreDTO chambreDTO) {
        Optional<Chambre> chambreOptional = chambreRepository.findById(id);
        if (chambreOptional.isEmpty()) {
            return null;
        }
        Chambre chambre = chambreOptional.get();
        chambre.setTypeChambre(TypeChambre.valueOf(chambreDTO.getTypeChambre()));
        chambre.setPrix(chambreDTO.getPrix());
        chambre.setDisponible(chambreDTO.getDisponible());
        chambre.setNumeroChambre(chambreDTO.getNumeroChambre());
        chambre.setDescription(chambreDTO.getDescription());
        Chambre updatedChambre = chambreRepository.save(chambre);
        return toDTO(updatedChambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    private ChambreDTO toDTO(Chambre chambre) {
        ChambreDTO dto = new ChambreDTO();
        dto.setId(chambre.getId());
        dto.setTypeChambre(chambre.getTypeChambre().name());
        dto.setPrix(chambre.getPrix());
        dto.setDisponible(chambre.getDisponible());
        dto.setNumeroChambre(chambre.getNumeroChambre());
        dto.setDescription(chambre.getDescription());
        return dto;
    }

    private Chambre toEntity(ChambreDTO dto) {
        Chambre chambre = new Chambre();
        chambre.setTypeChambre(TypeChambre.valueOf(dto.getTypeChambre()));
        chambre.setPrix(dto.getPrix());
        chambre.setDisponible(dto.getDisponible());
        chambre.setNumeroChambre(dto.getNumeroChambre());
        chambre.setDescription(dto.getDescription());
        return chambre;
    }
}
