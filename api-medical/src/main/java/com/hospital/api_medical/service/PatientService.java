package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import com.hospital.api_medical.exception.PatientNotFoundException;
import com.hospital.api_medical.mappers.PatientMapper;
import com.hospital.api_medical.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    public final PatientRepository patientRepository;
    public final PatientMapper patientMapper;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    // Fetch all patients
    public Page<PatientDTO> allPatients(Pageable pageable) {
        Page<Patient> patients = patientRepository.findAll(pageable);
        return patients.map(patientMapper::toDTO);
    }

    // Fetch patient by ID
    public PatientDTO findPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
        return patientMapper.toDTO(patient);
    }

    // Create a new patient
    @Transactional
    public PatientDTO createPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDTO(updatedPatient);
    }

    // Update a patient
    @Transactional
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));

        patient.setName(patientDTO.name());
        patient.setBirthDate(patientDTO.birthDate());

        Patient existingPatient = patientRepository.save(patient);
        return patientMapper.toDTO(existingPatient);
    }

    // Delete patient
    @Transactional
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found with ID: " + id);
        }
    }
}
