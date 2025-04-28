package com.hospital.api_medical.service;

import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.entity.Pacient;
import com.hospital.api_medical.entity.Patient;
import com.hospital.api_medical.entity.Scheduling;
import com.hospital.api_medical.repository.MedicRepository;
import com.hospital.api_medical.repository.PacientRepository;
import com.hospital.api_medical.repository.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private PacientRepository pacientRepository;

    @Autowired
    private MedicRepository medicRepository;

    //method to create a new schedule
    public Scheduling createScheduling(Long pacientId, Long medicId, LocalDateTime dateTime, String status){

        Patient pacient = pacientRepository.findById(pacientId).orElseThrow(() -> new RuntimeException("Patient not found!"));


        Medic medic = medicRepository.findById(medicId).orElseThrow(() -> new RuntimeException("Medic not found!"));

        Scheduling scheduling = new Scheduling();
        scheduling.setPatient(pacient);
        scheduling.setMedic(medic);
        scheduling.setDate_hour(dateTime);
        scheduling.setStatus(status);

        return schedulingRepository.save(scheduling);
    }

    //method to find a schedule for an id
    public Scheduling findSchedulingForId(Long id){
        return schedulingRepository.findById(id).orElseThrow(() -> new RuntimeException("No scheduling found!"));
    }

    //method to list all schedules
    public List<Scheduling> listAllSchedules(){
        return schedulingRepository.findAll();
    }

    //method to actualize a schedule
    public Scheduling actualizeScheduling(Long id, LocalDateTime newDate, String newStatus){

        Scheduling scheduling = schedulingRepository.findById(id).orElseThrow(() -> new RuntimeException("Scheduling not founded to actualize!"));

        scheduling.setDate_hour(newDate);
        scheduling.setStatus(newStatus);

        return schedulingRepository.save(scheduling);
    }

    //method to delete a schedule
    public void deleteSchedule(Long id){

        Scheduling scheduling = schedulingRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule nonexistent to delete!"));
    }
}
