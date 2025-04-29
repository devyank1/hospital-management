package com.hospital.api_medical.service;

import com.hospital.api_medical.dto.SchedulingDTO;
import com.hospital.api_medical.entity.Scheduling;
import com.hospital.api_medical.exception.ScheduleNotFoundException;
import com.hospital.api_medical.mappers.SchedulingMapper;
import com.hospital.api_medical.repository.SchedulingRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;
    private final SchedulingMapper schedulingMapper;

    public SchedulingService(SchedulingRepository schedulingRepository, SchedulingMapper schedulingMapper) {
        this.schedulingRepository = schedulingRepository;
        this.schedulingMapper = schedulingMapper;
    }

    // method to list all schedules
    public Page<SchedulingDTO> getAllSchedules(Pageable pageable) {
        Page<Scheduling> scheduling = schedulingRepository.findAll(pageable);
        return scheduling.map(schedulingMapper::toDTO);
    }

    // method to find a schedule for an id
    public SchedulingDTO findScheduleById(Long id) {
        Scheduling scheduling = schedulingRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found with ID: " + id));

        return schedulingMapper.toDTO(scheduling);
    }

    // method to create a new schedule
    @Transactional
    public SchedulingDTO createSchedule(SchedulingDTO schedulingDTO) {
        Scheduling scheduling = schedulingMapper.toEntity(schedulingDTO);
        Scheduling newScheduling = schedulingRepository.save(scheduling);
        return schedulingMapper.toDTO(newScheduling);
    }

    // method to actualize a schedule
    @Transactional
    public SchedulingDTO actualizeScheduling(Long id, SchedulingDTO schedulingDTO) {
        Scheduling newScheduling = schedulingRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found with ID: " + id));

        newScheduling.setStatus(schedulingDTO.status());
        newScheduling.setDate_hour(schedulingDTO.dateHour());

        Scheduling updatedSchedule = schedulingRepository.save(newScheduling);
        return schedulingMapper.toDTO(updatedSchedule);
    }

    //method to delete a schedule
    @Transactional
    public void deleteSchedule(Long id) {
        if (!schedulingRepository.existsById(id)) {
            throw new ScheduleNotFoundException("Schedule not found with ID: " + id);
        }
    }
}
