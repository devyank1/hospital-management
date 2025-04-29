package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.SchedulingDTO;
import com.hospital.api_medical.service.SchedulingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
public class SchedulingController {

    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @GetMapping
    public ResponseEntity<Page<SchedulingDTO>> allSchedules(Pageable pageable) {
        Page<SchedulingDTO> schedules = schedulingService.getAllSchedules(pageable);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulingDTO> findScheduleById(@PathVariable Long id) {
        SchedulingDTO schedule = schedulingService.findScheduleById(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping
    public ResponseEntity<SchedulingDTO> createSchedule(@RequestBody SchedulingDTO schedulingDTO) {
        SchedulingDTO schedule = schedulingService.createSchedule(schedulingDTO);
        return ResponseEntity.ok(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchedulingDTO> updateSchedule(@PathVariable Long id, @RequestBody SchedulingDTO schedulingDTO) {
        SchedulingDTO schedule = schedulingService.actualizeScheduling(id, schedulingDTO);
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        schedulingService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
