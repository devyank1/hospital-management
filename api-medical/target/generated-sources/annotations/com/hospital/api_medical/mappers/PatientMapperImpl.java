package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T11:52:53-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDTO toDTO(Patient patient) {
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
    public Patient toEntity(PatientDTO patientDTO) {
        if ( patientDTO == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDTO.id() );
        patient.setName( patientDTO.name() );
        patient.setBirthDate( patientDTO.birthDate() );

        return patient;
    }
}
