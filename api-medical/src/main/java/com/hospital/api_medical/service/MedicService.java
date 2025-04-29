package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.MedicDTO;
import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.exception.MedicNotFoundException;
import com.hospital.api_medical.mappers.MedicMapper;
import com.hospital.api_medical.repository.MedicRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MedicService {

    private final MedicRepository medicRepository;
    private final MedicMapper medicMapper;

    public MedicService(MedicRepository medicRepository, MedicMapper medicMapper) {
        this.medicRepository = medicRepository;
        this.medicMapper = medicMapper;
    }

    // Find all medics method
    public Page<MedicDTO> findAllMedics(Pageable pageable) {
        Page<Medic> medics = medicRepository.findAll(pageable);
        return medics.map(medicMapper::toDTO);
    }

    // Find medic by ID
    public MedicDTO findMedicById(Long id) {
        Medic medic = medicRepository.findById(id)
                .orElseThrow(() -> new MedicNotFoundException("Medic not found with ID: " + id));

        return medicMapper.toDTO(medic);
    }

    // Save a new medic
    @Transactional
    public MedicDTO createMedic(MedicDTO medicDTO) {
        Medic medic = medicMapper.toEntity(medicDTO);
        Medic updatedMedic = medicRepository.save(medic);
        return medicMapper.toDTO(updatedMedic);
    }

    // Update a medic
    @Transactional
    public MedicDTO actualizeMedic(Long id, MedicDTO medicDTO) {
        Medic existingMedic = medicRepository.findById(id)
                .orElseThrow(() -> new MedicNotFoundException("Medic not found with ID: " + id));

        existingMedic.setName(medicDTO.name());
        existingMedic.setSpecialty(medicDTO.specialty());
        Medic updatedMedic = medicRepository.save(existingMedic);

        return medicMapper.toDTO(updatedMedic);
    }

    @Transactional
    public void deleteMedic(Long id) {
        if (!medicRepository.existsById(id)) {
            throw new MedicNotFoundException("Medic not found with ID: " + id);
        }
    }
}