package com.hospital.api_medical.mappers;

import com.hospital.api_medical.dto.SchedulingDTO;
import com.hospital.api_medical.entity.Medic;
import com.hospital.api_medical.entity.Patient;
import com.hospital.api_medical.entity.Scheduling;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-22T16:35:10-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class SchedulingMapperImpl implements SchedulingMapper {

    @Override
    public SchedulingDTO toDTO(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }

        Long patientId = null;
        Long medicId = null;
        String patientName = null;
        String medicName = null;
        String medicSpecialty = null;
        LocalDateTime dateHour = null;
        String status = null;
        Long id = null;

        patientId = schedulingPatientId( scheduling );
        medicId = schedulingMedicId( scheduling );
        patientName = schedulingPatientName( scheduling );
        medicName = schedulingMedicName( scheduling );
        medicSpecialty = schedulingMedicSpecialty( scheduling );
        dateHour = scheduling.getDate_hour();
        status = scheduling.getStatus();
        id = scheduling.getId();

        SchedulingDTO schedulingDTO = new SchedulingDTO( id, patientId, patientName, medicId, medicName, medicSpecialty, dateHour, status );

        return schedulingDTO;
    }

    @Override
    public Scheduling toEntity(SchedulingDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Scheduling scheduling = new Scheduling();

        scheduling.setDate_hour( dto.dateHour() );
        scheduling.setStatus( dto.status() );

        scheduling.setPatient( new Patient(dto.patientId()) );
        scheduling.setMedic( new Medic(dto.medicId()) );

        return scheduling;
    }

    private Long schedulingPatientId(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }
        Patient patient = scheduling.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long schedulingMedicId(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }
        Medic medic = scheduling.getMedic();
        if ( medic == null ) {
            return null;
        }
        Long id = medic.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String schedulingPatientName(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }
        Patient patient = scheduling.getPatient();
        if ( patient == null ) {
            return null;
        }
        String name = patient.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String schedulingMedicName(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }
        Medic medic = scheduling.getMedic();
        if ( medic == null ) {
            return null;
        }
        String name = medic.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String schedulingMedicSpecialty(Scheduling scheduling) {
        if ( scheduling == null ) {
            return null;
        }
        Medic medic = scheduling.getMedic();
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
