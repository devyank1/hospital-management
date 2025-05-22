package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.PatientCreateDTO;
import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import com.hospital.api_medical.exception.PatientNotFoundException;
import com.hospital.api_medical.mappers.PatientMapper;
import com.hospital.api_medical.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PasswordEncoder encoder;

    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, PasswordEncoder encoder) {
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
        this.encoder = encoder;
    }

    // Fetch all patients
    public Page<PatientDTO> allPatients(Pageable pageable) {
        Page<Patient> patients = patientRepository.findAll(pageable);
        return patients.map(patientMapper::toDto);
    }

    // Fetch patient by ID
    public PatientDTO findPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));
        return patientMapper.toDto(patient);
    }

    // Create a new patient
    @Transactional
    public PatientDTO registerPatient(PatientCreateDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO, encoder);
        Patient updatedPatient = patientRepository.save(patient);
        return patientMapper.toDto(updatedPatient);
    }

    // Update a patient
    @Transactional
    public PatientDTO updatePatient(Long id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: " + id));

        patient.setName(patientDTO.name());
        patient.setBirthDate(patientDTO.birthDate());

        Patient existingPatient = patientRepository.save(patient);
        return patientMapper.toDto(existingPatient);
    }

    // Delete patient
    @Transactional
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found with ID: " + id);
        }
    }
}
