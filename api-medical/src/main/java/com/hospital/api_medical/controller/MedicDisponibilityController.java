package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.entity.MedicDisponibility;
import com.hospital.api_medical.service.MedicDisponibilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medic-disponibility")
public class MedicDisponibilityController {

    private final MedicDisponibilityService medicDisponibilityService;

    public MedicDisponibilityController(MedicDisponibilityService medicDisponibilityService){
        this.medicDisponibilityService = medicDisponibilityService;
    }

    @GetMapping
    public ResponseEntity<List<MedicDisponibility>> getAllMedicsDisponibilities(@PathVariable Long id, @RequestBody LocalDate date){
        List<MedicDisponibility> medicDisponibilities = medicDisponibilityService.findDisponibility(id, date);

        return ResponseEntity.ok(medicDisponibilities);
    }

    @PostMapping()
    public ResponseEntity<MedicDisponibility> createMedicDisponibility(@RequestBody MedicDisponibilityDTO medicDisponibilityDTO){
        MedicDisponibility newMedicDisponibility = medicDisponibilityService.createDisponibility(medicDisponibilityDTO);
        return ResponseEntity.ok(newMedicDisponibility);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDisponibility> actualizeMedicDisponibility(@PathVariable Long id, @RequestBody MedicDisponibilityDTO medicDisponibilityDTO){
        Optional<MedicDisponibility> actualizedMedicDisponibility = medicDisponibilityService.actualizeDisponibility(id, medicDisponibilityDTO);

        return actualizedMedicDisponibility
                .map(disponibility -> ResponseEntity.ok(disponibility))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicDisponibility(@PathVariable Long id){
        medicDisponibilityService.deleteDisponibility(id);
        return ResponseEntity.noContent().build();
    }
}
