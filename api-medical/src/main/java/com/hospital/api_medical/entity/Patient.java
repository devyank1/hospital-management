package com.hospital.api_medical.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Date birthDate;
    @Column(nullable = false)
    private String cpf;

    public Patient(){}

    public Patient(Long id) {}

    public Patient(Long id, String name, String email, String number, Date birthDate, String cpf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.birthDate = birthDate;
        this.cpf = cpf;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}