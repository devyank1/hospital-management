package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.MedicDTO;
import com.hospital.api_medical.entity.Medic;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-28T21:30:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MedicMapperImpl implements MedicMapper {

    @Override
    public MedicDTO toDTO(Medic medic) {
        if ( medic == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String specialty = null;

        id = medic.getId();
        name = medic.getName();
        specialty = medic.getSpecialty();

        MedicDTO medicDTO = new MedicDTO( id, name, specialty );

        return medicDTO;
    }

    @Override
    public Medic toEntity(MedicDTO medicDTO) {
        if ( medicDTO == null ) {
            return null;
        }

        Medic medic = new Medic();

        medic.setId( medicDTO.id() );
        medic.setName( medicDTO.name() );
        medic.setSpecialty( medicDTO.specialty() );

        return medic;
    }
}
