package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.entity.MedicDisponibility;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-29T12:05:51-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MedicDisponibilityMapperImpl implements MedicDisponibilityMapper {

    @Override
    public MedicDisponibilityDTO toDTO(MedicDisponibility medicDisponibility) {
        if ( medicDisponibility == null ) {
            return null;
        }

        Long medicId = null;
        String medicName = null;
        String medicSpecialty = null;
        LocalDate date = null;
        List<String> availableHours = null;

        medicId = medicDisponibilityMedicId( medicDisponibility );
        medicName = medicDisponibilityMedicName( medicDisponibility );
        medicSpecialty = medicDisponibilityMedicSpecialty( medicDisponibility );
        date = medicDisponibility.getDate();
        List<String> list = medicDisponibility.getAvailableHours();
        if ( list != null ) {
            availableHours = new ArrayList<String>( list );
        }

        MedicDisponibilityDTO medicDisponibilityDTO = new MedicDisponibilityDTO( medicId, medicName, medicSpecialty, date, availableHours );

        return medicDisponibilityDTO;
    }

    @Override
    public MedicDisponibility toEntity(MedicDisponibilityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MedicDisponibility medicDisponibility = new MedicDisponibility();

        medicDisponibility.setDate( dto.date() );
        List<String> list = dto.availableHours();
        if ( list != null ) {
            medicDisponibility.setAvailableHours( new ArrayList<String>( list ) );
        }

        medicDisponibility.setMedic( new Medic(dto.medicId()) );

        return medicDisponibility;
    }

    private Long medicDisponibilityMedicId(MedicDisponibility medicDisponibility) {
        if ( medicDisponibility == null ) {
            return null;
        }
        Medic medic = medicDisponibility.getMedic();
        if ( medic == null ) {
            return null;
        }
        Long id = medic.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String medicDisponibilityMedicName(MedicDisponibility medicDisponibility) {
        if ( medicDisponibility == null ) {
            return null;
        }
        Medic medic = medicDisponibility.getMedic();
        if ( medic == null ) {
            return null;
        }
        String name = medic.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String medicDisponibilityMedicSpecialty(MedicDisponibility medicDisponibility) {
        if ( medicDisponibility == null ) {
            return null;
        }
        Medic medic = medicDisponibility.getMedic();
        if ( medic == null ) {
            return null;
        }
        String specialty = medic.getSpecialty();
        if ( specialty == null ) {
            return null;
        }
        return specialty;
    }
}
