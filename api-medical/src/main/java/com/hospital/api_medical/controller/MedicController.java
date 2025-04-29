package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.MedicDTO;
import com.hospital.api_medical.service.MedicService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medics")
public class MedicController {

    private final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @GetMapping
    public ResponseEntity<Page<MedicDTO>> allMedics(Pageable pageable) {
        Page<MedicDTO> medics = medicService.findAllMedics(pageable);
        return ResponseEntity.ok(medics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicDTO> findMedicById(@PathVariable Long id) {
        MedicDTO medic = medicService.findMedicById(id);
        return ResponseEntity.ok(medic);
    }

    @PostMapping
    public ResponseEntity<MedicDTO> createMedic(@RequestBody MedicDTO medicDTO) {
        MedicDTO medic = medicService.createMedic(medicDTO);
        return ResponseEntity.ok(medic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicDTO> updateMedic(@PathVariable Long id, @RequestBody MedicDTO medicDTO) {
        MedicDTO medic = medicService.actualizeMedic(id, medicDTO);
        return ResponseEntity.ok(medic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedic(@PathVariable Long id) {
        medicService.deleteMedic(id);
        return ResponseEntity.noContent().build();
    }
}
