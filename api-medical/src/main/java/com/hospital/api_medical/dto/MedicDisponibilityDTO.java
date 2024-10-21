package com.hospital.api_medical.dto;


import java.time.LocalDate;
import java.util.List;

public class MedicDisponibilityDTO {
    private Long medicId;
    private LocalDate date;
    private List<String> avaliableHours;

    public MedicDisponibilityDTO(Long medicId, LocalDate date, List<String> avaliableHours) {
        this.medicId = medicId;
        this.date = date;
        this.avaliableHours = avaliableHours;
    }

    public MedicDisponibilityDTO(){}

    public Long getMedicId() {
        return medicId;
    }

    public void setMedicId(Long medicId) {
        this.medicId = medicId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<String> getAvaliableHours() {
        return avaliableHours;
    }

    public void setAvaliableHours(List<String> avaliableHours) {
        this.avaliableHours = avaliableHours;
    }
}
