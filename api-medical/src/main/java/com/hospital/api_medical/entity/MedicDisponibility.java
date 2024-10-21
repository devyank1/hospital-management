package com.hospital.api_medical.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
public class MedicDisponibility extends MedicDisponibilityDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medic", nullable = false)
    private Medic medic;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    @ElementCollection
    private List<String> avaliableHours;

    public MedicDisponibility(){}

    public MedicDisponibility(Long id, Medic medic, LocalDate date, List<String> avaliableHours) {
        this.id = id;
        this.medic = medic;
        this.date = date;
        this.avaliableHours = avaliableHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
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
