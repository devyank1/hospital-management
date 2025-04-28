package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.MedicDisponibilityDTO;
import com.hospital.api_medical.entity.MedicDisponibility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MedicDisponibilityMapper {

    @Mappings({
            @Mapping(source = "medic.id", target = "medicId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "available_hours", target = "availableHours")
    })
    MedicDisponibilityDTO toDTO(MedicDisponibility medicDisponibility);

    @Mappings({
            @Mapping(target = "medic", expression = "java(new Medic(dto.medicId()))"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "availableHours", target = "available_hours"),
            @Mapping(target = "id", ignore = true)
    })
    MedicDisponibility toEntity(MedicDisponibilityDTO medicDisponibilityDTO);
}
