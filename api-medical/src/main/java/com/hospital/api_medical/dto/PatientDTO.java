package com.hospital.api_medical.dto;

import java.util.Date;

public record PatientDTO(
        Long id,
        String name,
        Date birthDate) {}
