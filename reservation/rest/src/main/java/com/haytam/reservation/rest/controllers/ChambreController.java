package com.haytam.reservation.rest.controllers;

import com.haytam.reservation.core.dtos.ChambreDTO;
import com.haytam.reservation.rest.services.RestChambreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
@AllArgsConstructor
public class ChambreController {

	private final RestChambreService chambreService;

	@GetMapping
	public ResponseEntity<List<ChambreDTO>> getAllChambres() {
		List<ChambreDTO> chambres = chambreService.getAllChambres();
		return ResponseEntity.ok(chambres);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ChambreDTO> getChambreById(@PathVariable Long id) {
		ChambreDTO chambre = chambreService.getChambreById(id);
		return chambre != null ? ResponseEntity.ok(chambre) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ChambreDTO> createChambre(@RequestBody ChambreDTO chambreDTO) {
		ChambreDTO savedChambre = chambreService.createChambre(chambreDTO);
		return new ResponseEntity<>(savedChambre, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ChambreDTO> updateChambre(@PathVariable Long id, @RequestBody ChambreDTO chambreDetails) {
		ChambreDTO updatedChambre = chambreService.updateChambre(id, chambreDetails);
		return updatedChambre != null ? ResponseEntity.ok(updatedChambre) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
		chambreService.deleteChambre(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
