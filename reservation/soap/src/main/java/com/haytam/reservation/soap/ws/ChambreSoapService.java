package com.haytam.reservation.soap.ws;

import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.core.entities.Chambre;
import com.haytam.reservation.core.entities.enums.TypeChambre;
import com.haytam.reservation.core.repositories.ChambreRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
@WebService(serviceName = "ChambreWS")
public class ChambreSoapService {

    @Autowired
    private ChambreRepository chambreRepository;

    @WebMethod
    public List<ChambreDTO> getChambres() {
        return chambreRepository.findAll().stream()
                .map(chambre -> new ChambreDTO(
                        chambre.getId(),
                        chambre.getTypeChambre().toString(),
                        chambre.getPrix(),
                        chambre.getDisponible(),
                        chambre.getNumeroChambre(),
                        chambre.getDescription(),
                        null))  // reservations is set to null as no data is provided for it here
                .collect(Collectors.toList());
    }

    @WebMethod
    public ChambreDTO getChambreById(@WebParam(name = "id") Long id) {
        Chambre chambre = chambreRepository.findById(id).orElse(null);
        if (chambre != null) {
            return new ChambreDTO(
                    chambre.getId(),
                    chambre.getTypeChambre().toString(),
                    chambre.getPrix(),
                    chambre.getDisponible(),
                    chambre.getNumeroChambre(),
                    chambre.getDescription(),
                    null);  // reservations is set to null here as well
        }
        return null;
    }

    @WebMethod
    public ChambreDTO createChambre(@WebParam(name = "type") TypeChambre type,
                                    @WebParam(name = "prix") BigDecimal prix,
                                    @WebParam(name = "disponible") boolean disponible,
                                    @WebParam(name = "numeroChambre") String numeroChambre,
                                    @WebParam(name = "description") String description) {
        Chambre chambre = new Chambre(null, type, prix, disponible, numeroChambre, description, null);
        Chambre savedChambre = chambreRepository.save(chambre);
        return new ChambreDTO(
                savedChambre.getId(),
                savedChambre.getTypeChambre().toString(),
                savedChambre.getPrix(),
                savedChambre.getDisponible(),
                savedChambre.getNumeroChambre(),
                savedChambre.getDescription(),
                null);  // reservations is set to null here as well
    }

    @WebMethod
    public boolean deleteChambre(@WebParam(name = "id") Long id) {
        if (chambreRepository.existsById(id)) {
            chambreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
