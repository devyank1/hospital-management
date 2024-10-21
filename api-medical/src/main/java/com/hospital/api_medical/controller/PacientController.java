package com.hospital.api_medical.controller;

import com.hospital.api_medical.entity.Pacient;
import com.hospital.api_medical.service.PacientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping // mehtod to list all patients presents in list.
    public List<Pacient> listAllPacients(){
        return pacientService.findAll();
    }

    @PostMapping // method to save patient.
    public Pacient savePacient(@RequestBody Pacient pacient){
        return pacientService.save(pacient);
    }

    @PutMapping("/{id}") // method to actualize a patient by their ID.
    public ResponseEntity<Pacient> actualizePacientStats(@PathVariable Long id, @RequestBody Pacient pacient){
        return ResponseEntity.ok(pacientService.actualize(id, pacient));
    }

    @DeleteMapping("/{id}") // method to delete a patient by their ID.
    public ResponseEntity<Void> deletePacient(@PathVariable Long id){
        pacientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
