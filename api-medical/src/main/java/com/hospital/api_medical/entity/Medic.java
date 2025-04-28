package com.hospital.api_medical.entity;

import jakarta.persistence.*;

@Entity
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false, unique = true)
    private String specialty;
    @Column(nullable = false, unique = true)
    private String crm;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String email;

    public Medic(Long id, String name, String specialty, String crm, String numberCellphone, String email) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.crm = crm;
        this.number = numberCellphone;
        this.email = email;
    }

    public Medic() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String numberCellphone) {
        this.number = numberCellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
