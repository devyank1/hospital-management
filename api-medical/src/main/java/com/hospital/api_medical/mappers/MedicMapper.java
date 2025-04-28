package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.MedicDTO;
import com.hospital.api_medical.entity.Medic;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicMapper {

    MedicDTO toDTO(Medic medic);

    Medic toEntity(MedicDTO medicDTO);
}
