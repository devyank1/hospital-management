package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.PatientCreateDTO;
import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService, PasswordEncoder encoder) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<Page<PatientDTO>> allPatients(Pageable pageable) {
        Page<PatientDTO> patients = patientService.allPatients(pageable);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Long id) {
        PatientDTO patient = patientService.findPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/signup")
    public ResponseEntity<PatientDTO> createPatient(@RequestBody PatientCreateDTO newPatientDTO) {
        PatientDTO patientRegistered = patientService.registerPatient(newPatientDTO);
        return ResponseEntity.ok(patientRegistered);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        PatientDTO patient = patientService.updatePatient(id, patientDTO);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
