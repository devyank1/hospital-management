package com.hospital.api_medical.controller;

import com.hospital.api_medical.dto.ScheduleDTO;
import com.hospital.api_medical.entity.Scheduling;
import com.hospital.api_medical.service.SchedulingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class SchedulingController {

    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @GetMapping("/{id}") // method to find a schedule for ID.
    public ResponseEntity<Scheduling> findScheduleForId(@PathVariable Long id){
        Scheduling scheduling = schedulingService.findSchedulingForId(id);
        return ResponseEntity.ok(scheduling);
    }

    @PostMapping // method to create a schedule.
    public ResponseEntity<Scheduling> createSchedule(@RequestBody ScheduleDTO scheduleDTO){
        Long pacientId = scheduleDTO.getPacientId();
        Long medicId = scheduleDTO.getMedicId();
        LocalDateTime dateHour = scheduleDTO.getDateHour();

        Scheduling newScheduling = schedulingService.createScheduling(pacientId, medicId, dateHour, "Pendent");
        return ResponseEntity.ok().build();
    }

    @GetMapping // method to list aal schedules.
    public ResponseEntity<List<Scheduling>> listAllSchedules(){
        List<Scheduling> schedulings = schedulingService.listAllSchedules();
        return ResponseEntity.ok(schedulings);
    }

    @PutMapping("/{id}") // method to actualize schedules for ID.
    public ResponseEntity<Scheduling> actualizeSchedules(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO){
        Scheduling newScheduling = schedulingService.actualizeScheduling(id, scheduleDTO.getDateHour(), "Confirmed!");
        return ResponseEntity.ok(newScheduling);
    }

    @DeleteMapping("/{id}") // method to delete a schedule for ID.
    public ResponseEntity<Void> deleteSchedules(@PathVariable Long id){
        schedulingService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
