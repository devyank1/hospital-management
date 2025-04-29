package com.hospital.api_medical.dto;

import com.hospital.api_medical.entity.MedicDisponibility;

import java.time.LocalDate;
import java.util.List;

public record MedicDisponibilityDTO(
        Long medicId,
        String medicName,
        String medicSpecialty,
        LocalDate date,
        List<String> availableHours){

    public MedicDisponibilityDTO(MedicDisponibility medicDisponibility) {
        this(
                medicDisponibility.getId(),
                medicDisponibility.getMedic().getName(),
                medicDisponibility.getMedic().getSpecialty(),
                medicDisponibility.getDate(),
                medicDisponibility.getAvailableHours()
        );
    }
}
