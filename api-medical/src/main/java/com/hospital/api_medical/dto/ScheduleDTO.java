package com.hospital.api_medical.dto;

import java.time.LocalDateTime;

public class ScheduleDTO {

    private Long pacientId;
    private Long medicId;
    private LocalDateTime dateHour;

    public ScheduleDTO(){}

    public ScheduleDTO(Long pacientId, Long medicId, LocalDateTime dateHour) {
        this.pacientId = pacientId;
        this.medicId = medicId;
        this.dateHour = dateHour;
    }

    public Long getPacientId() {
        return pacientId;
    }

    public void setPacientId(Long pacientId) {
        this.pacientId = pacientId;
    }

    public Long getMedicId() {
        return medicId;
    }

    public void setMedicId(Long medicId) {
        this.medicId = medicId;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDateHour(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }
}
