package com.hospital.api_medical.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
public class MedicDisponibility {

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
    private List<String> availableHours;

    public MedicDisponibility(){}

    public MedicDisponibility(Long id, Medic medic, LocalDate date, List<String> availableHours) {
        this.id = id;
        this.medic = medic;
        this.date = date;
        this.availableHours = availableHours;
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
        return availableHours;
    }

    public void setAvaliableHours(List<String> avaliableHours) {
        this.availableHours = avaliableHours;
    }
}
