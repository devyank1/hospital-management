package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.entity.MedicDisponibility;
import com.hospital.api_medical.exception.MedicDisponibilityNotFoundException;
import com.hospital.api_medical.mappers.MedicDisponibilityMapper;
import com.hospital.api_medical.repository.MedicDisponibilityRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicDisponibilityService {

    private final MedicDisponibilityRepository medicDisponibilityRepository;
    private final MedicDisponibilityMapper medicDisponibilityMapper;

    public MedicDisponibilityService(MedicDisponibilityRepository medicDisponibilityRepository, MedicDisponibilityMapper medicDisponibilityMapper) {
        this.medicDisponibilityRepository = medicDisponibilityRepository;
        this.medicDisponibilityMapper = medicDisponibilityMapper;
    }

    // Fetch all availabilities
    public Page<MedicDisponibilityDTO> findAllAvailabilities(Pageable pageable) {
        Page<MedicDisponibility> availabilities = medicDisponibilityRepository.findAll(pageable);
        return availabilities.map(medicDisponibilityMapper::toDTO);
    }

    // Fetch availability by ID
    public MedicDisponibilityDTO findAvailabilityById(Long id) {
        MedicDisponibility disponibility = medicDisponibilityRepository.findById(id)
                .orElseThrow(() -> new MedicDisponibilityNotFoundException("Availability not found with ID: " + id));

        return medicDisponibilityMapper.toDTO(disponibility);
    }

    // create a new availability
    @Transactional
    public MedicDisponibilityDTO createAvailability(MedicDisponibilityDTO disponibilityDTO) {
        MedicDisponibility availability = medicDisponibilityMapper.toEntity(disponibilityDTO);
        MedicDisponibility updatedAvailability = medicDisponibilityRepository.save(availability);
        return medicDisponibilityMapper.toDTO(updatedAvailability);
    }

    // Update availability
    @Transactional
    public MedicDisponibilityDTO updateAvailability(Long id, MedicDisponibilityDTO availabilityDTO) {
        MedicDisponibility availability = medicDisponibilityRepository.findById(id)
                .orElseThrow(() -> new MedicDisponibilityNotFoundException("Availability not found with ID: " + id));

        availability.setAvailableHours(availability.getAvailableHours());
        availability.setDate(availabilityDTO.date());
        MedicDisponibility updatedAvailability = medicDisponibilityRepository.save(availability);

        return medicDisponibilityMapper.toDTO(updatedAvailability);
    }

    // Delete availability
    @Transactional
    public void deleteAvailability(Long id) {
        if (!medicDisponibilityRepository.existsById(id)) {
            throw new MedicDisponibilityNotFoundException("Availability not found with ID: " + id);
        }
    }
}
