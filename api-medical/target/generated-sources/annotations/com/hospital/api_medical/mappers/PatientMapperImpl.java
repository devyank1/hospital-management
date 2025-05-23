package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.PatientCreateDTO;
import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T16:35:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDTO toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        Date birthDate = null;

        id = patient.getId();
        name = patient.getName();
        birthDate = patient.getBirthDate();

        PatientDTO patientDTO = new PatientDTO( id, name, birthDate );

        return patientDTO;
    }

    @Override
    public Patient toEntity(PatientCreateDTO patientDTO, PasswordEncoder encoder) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setPassword( encoder.encode(patientDTO.password()) );

        return patient;
    }
}
