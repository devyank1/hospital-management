package com.hospital.api_medical.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_medic", nullable = false)
    private Medic medic;
    private LocalDateTime date_hour;
    private String status;

    public Scheduling(){}

    public Scheduling(Long id, Patient patient, Medic medic, LocalDateTime date_hour, String status) {
        this.id = id;
        this.patient = patient;
        this.medic = medic;
        this.date_hour = date_hour;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public LocalDateTime getDate_hour() {
        return date_hour;
    }

    public void setDate_hour(LocalDateTime date_hour) {
        this.date_hour = date_hour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
