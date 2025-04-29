package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.service.MedicDisponibilityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/medic-disponibility")
public class MedicDisponibilityController {

    private final MedicDisponibilityService medicDisponibilityService;

    public MedicDisponibilityController(MedicDisponibilityService medicDisponibilityService) {
        this.medicDisponibilityService = medicDisponibilityService;
    }

    @GetMapping
    public ResponseEntity<Page<MedicDisponibilityDTO>> allAvailable(Pageable pageable) {
        Page<MedicDisponibilityDTO> availability = medicDisponibilityService.findAllAvailabilities(pageable);
        return ResponseEntity.ok(availability);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDisponibilityDTO> findAvailabilityById(@PathVariable Long id) {
        MedicDisponibilityDTO availability = medicDisponibilityService.findAvailabilityById(id);
        return ResponseEntity.ok(availability);
    }

    @PostMapping
    public ResponseEntity<MedicDisponibilityDTO> createAvailability(@RequestBody MedicDisponibilityDTO medicDisponibilityDTO) {
        MedicDisponibilityDTO availability = medicDisponibilityService.createAvailability(medicDisponibilityDTO);
        return ResponseEntity.ok(availability);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDisponibilityDTO> updateAvailability(@PathVariable Long id, @RequestBody MedicDisponibilityDTO medicDisponibilityDTO) {
        MedicDisponibilityDTO availability = medicDisponibilityService.updateAvailability(id, medicDisponibilityDTO);
        return ResponseEntity.ok(availability);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        medicDisponibilityService.deleteAvailability(id);
        return ResponseEntity.noContent().build();
    }
}
