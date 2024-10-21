package com.hospital.api_medical.repository;

import com.hospital.api_medical.entity.MedicDisponibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MedicDisponibilityRepository extends JpaRepository<MedicDisponibility, Long>{
    List<MedicDisponibility> findByIdAndData(Long medicId, LocalDate data);
}
