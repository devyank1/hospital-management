package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.entity.MedicDisponibility;
import com.hospital.api_medical.repository.MedicDisponibilityRepository;
import com.hospital.api_medical.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class MedicDisponibilityService {

    private final MedicDisponibilityRepository medicDisponibilityRepository;

    private final MedicRepository medicRepository;

    public MedicDisponibilityService(MedicDisponibilityRepository medicDisponibilityRepository, MedicRepository medicRepository) {
        this.medicDisponibilityRepository = medicDisponibilityRepository;
        this.medicRepository = medicRepository;
    }


    // add a new disponibility
    public MedicDisponibility createDisponibility(Long medicId, LocalDate data, List<String> hoursAvaliable){
        MedicDisponibility medicDisponibility = new MedicDisponibility();
        medicDisponibility.setMedic(new Medic(medicId));
        medicDisponibility.setDate(data);
        medicDisponibility.setAvaliableHours(hoursAvaliable);

        return medicDisponibilityRepository.save(medicDisponibility);
    }

    // method to find disponibility of a medic in a specific date
    public List<MedicDisponibility> findDisponibility(Long id, LocalDate data){
        return medicDisponibilityRepository.findByIdAndData(id, data);
    }

    //mehtod to actualize a medic disponibility in a specific date
    public Optional<MedicDisponibility> actualizeDisponibility(Long id, MedicDisponibilityDTO medicDisponibilityDTO){
        Optional<MedicDisponibility> OptionalDisponibility = medicDisponibilityRepository.findById(id);

        if (OptionalDisponibility.isPresent()){
            MedicDisponibility disponibility = OptionalDisponibility.get();

            Medic medic = medicRepository.findById(medicDisponibilityDTO.getMedicId()).orElseThrow(() -> new RuntimeException("Medic not found"));
            disponibility.setMedic(medic);
            disponibility.setDate(medicDisponibilityDTO.getDate());
            disponibility.setAvaliableHours(medicDisponibilityDTO.getAvaliableHours());

            return Optional.of(medicDisponibilityRepository.save(disponibility));
        } else {
            return Optional.empty();
        }
    }

    //delete disponibility in a specific date
    public void deleteDisponibility(Long id){
        medicDisponibilityRepository.deleteById(id);
    }

    public MedicDisponibility createDisponibility(MedicDisponibilityDTO medicDisponibilityDTO) {
        Medic medic = medicRepository.findById(medicDisponibilityDTO.getMedicId()).orElseThrow(() -> new RuntimeException("Medic not found"));

        MedicDisponibility medicDisponibility = new MedicDisponibility();
        medicDisponibility.setMedic(medic);
        medicDisponibility.setDate(medicDisponibilityDTO.getDate());
        medicDisponibility.setAvaliableHours(medicDisponibilityDTO.getAvaliableHours());

        return medicDisponibilityRepository.save(medicDisponibility);
    }


}
