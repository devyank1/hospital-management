package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toDto(Patient patient);

    Patient toEntity(PatientDTO patientDTO);
}
