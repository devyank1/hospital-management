package com.hospital.api_medical.service;

import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<Medic> listAll(){
        return medicRepository.findAll();
    }

    public Medic save(Medic medic){
        return medicRepository.save(medic);
    }

    public Medic actualize(Long id, Medic medicActualized){
        return medicRepository.findById(id).map(medic -> {
            medic.setName(medicActualized.getName());
            medic.setSpecialty(medicActualized.getSpecialty());
            medic.setCrm(medicActualized.getCrm());
            medic.setNumber(medicActualized.getNumber());
            medic.setEmail(medicActualized.getEmail());
            return medicRepository.save(medic);
        }).orElseThrow(() -> new RuntimeException("Medic not found or actualized!"));
    }

    public void delete(Long id){
        medicRepository.deleteById(id);
    }
}