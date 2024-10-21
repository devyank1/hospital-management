package com.hospital.api_medical.repository;

import com.hospital.api_medical.entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{}
