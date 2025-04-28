package com.hospital.api_medical.dto;


import java.time.LocalDate;
import java.util.List;

public record MedicDisponibilityDTO(
        Long medicId,
        LocalDate date,
        List<String> availableHours){}
