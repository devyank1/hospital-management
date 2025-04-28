package com.hospital.api_medical.dto;

import java.time.LocalDateTime;

public record SchedulingDTO(
        Long patientId,
        Long medicId,
        String patientName,
        String medicName,
        LocalDateTime dateHour){}
