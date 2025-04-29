package com.hospital.api_medical.dto;

import com.hospital.api_medical.entity.Scheduling;

import java.time.LocalDateTime;

public record SchedulingDTO(
        Long id,
        Long patientId,
        String patientName,
        Long medicId,
        String medicName,
        String medicSpecialty,
        LocalDateTime dateHour,
        String status
){
    public SchedulingDTO(Scheduling s) {
       this(
        s.getId(),
        s.getPatient().getId(),
        s.getPatient().getName(),
        s.getMedic().getId(),
        s.getMedic().getName(),
        s.getMedic().getSpecialty(),
        s.getDate_hour(),
        s.getStatus()
       );
    }
}
