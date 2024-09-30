package com.onlineappointment.PatientsService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineappointment.PatientsService.entity.HealthMetric;
import com.onlineappointment.PatientsService.service.HealthMetricService;


@RestController
@RequestMapping("/patients/{patientId}/health-metrics")
public class HealthMetricController {
	@Autowired
    private HealthMetricService healthMetricService;

    @PostMapping
    public ResponseEntity<HealthMetric> addHealthMetric(@PathVariable Long patientId, @RequestBody HealthMetric healthMetric) {
        return ResponseEntity.ok(healthMetricService.addHealthMetric(patientId, healthMetric));
    }

    @GetMapping
    public ResponseEntity<List<HealthMetric>> getHealthMetrics(@PathVariable Long patientId) {
        return ResponseEntity.ok(healthMetricService.getHealthMetricsByPatientId(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthMetric> getHealthMetric(@PathVariable Long id) {
        return ResponseEntity.of(healthMetricService.getHealthMetric(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthMetric> updateHealthMetric(@PathVariable Long id, @RequestBody HealthMetric healthMetric) {
        return ResponseEntity.ok(healthMetricService.updateHealthMetric(id, healthMetric));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHealthMetric(@PathVariable Long id) {
        healthMetricService.deleteHealthMetric(id);
        return ResponseEntity.noContent().build();
    }
}
