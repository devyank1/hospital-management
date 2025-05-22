package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.PatientCreateDTO;
import com.hospital.api_medical.dto.PatientDTO;
import com.hospital.api_medical.entity.Patient;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toDto(Patient patient);

    @Mapping(target = "password", expression = "java(encoder.encode(patientDTO.password()))")
    Patient toEntity(PatientCreateDTO patientDTO, @Context PasswordEncoder encoder);
}
