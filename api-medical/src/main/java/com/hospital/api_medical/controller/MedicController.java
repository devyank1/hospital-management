package com.hospital.api_medical.controller;

import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.service.MedicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medic")
public class MedicController {

    public final MedicService medicService;

    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    @GetMapping
    public List<Medic> listAllMedics(){
        return medicService.listAll();
    }

    @PostMapping
    public Medic saveMedic(@RequestBody Medic medic){
        return medicService.save(medic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medic> actualizeStatsMedic(@PathVariable Long id, @RequestBody Medic medic){
        return ResponseEntity.ok(medicService.actualize(id, medic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedic(@PathVariable Long id){
        medicService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
