package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.SchedulingDTO;
import com.hospital.api_medical.entity.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SchedulingMapper {

    @Mappings({
            @Mapping(source = "patient.id", target = "patientId"),
            @Mapping(source = "medic.id", target = "medicId"),
            @Mapping(source = "patient.name", target = "patientName"),
            @Mapping(source = "medic.name", target = "medicName"),
            @Mapping(source = "medic.specialty", target = "medicSpecialty"),
            @Mapping(source = "date_hour", target = "dateHour"),
            @Mapping(source = "status", target = "status")})
    SchedulingDTO toDTO(Scheduling scheduling);

    @Mappings({
            @Mapping(target = "patient", expression = "java(new Patient(dto.patientId()))"),
            @Mapping(target = "medic", expression = "java(new Medic(dto.medicId()))"),
            @Mapping(source = "dateHour", target = "date_hour"),
            @Mapping(source = "status", target = "status"),
            @Mapping(target = "id", ignore = true)
    })
    Scheduling toEntity(SchedulingDTO dto);
}
