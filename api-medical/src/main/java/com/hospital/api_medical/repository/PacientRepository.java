package com.hospital.api_medical.repository;

import com.hospital.api_medical.entity.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long>{}