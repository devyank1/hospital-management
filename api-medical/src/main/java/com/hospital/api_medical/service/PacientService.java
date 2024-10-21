package com.hospital.api_medical.service;

import com.hospital.api_medical.entity.Pacient;
import com.hospital.api_medical.repository.PacientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientService {

    public final PacientRepository pacientRepository;


    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> findAll(){
        return pacientRepository.findAll();
    }

    public Pacient save(Pacient pacient){
        return pacientRepository.save(pacient);
    }

    public Pacient actualize(Long id, Pacient pacientActualized){
        return pacientRepository.findById(id).map(pacient -> {
            pacient.setName(pacientActualized.getName());
            pacient.setEmail(pacientActualized.getEmail());
            pacient.setNumber(pacientActualized.getNumber());
            pacient.setBirthDate(pacientActualized.getBirthDate());
            pacient.setCpf(pacientActualized.getCpf());
            return pacientRepository.save(pacient);
        }).orElseThrow(() -> new RuntimeException("Pacient not found or actualized"));
    }

    public void delete(Long id){
        pacientRepository.deleteById(id);
    }
}
