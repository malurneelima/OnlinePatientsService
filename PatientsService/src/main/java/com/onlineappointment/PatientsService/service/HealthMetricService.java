package com.onlineappointment.PatientsService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.HealthMetric;
import com.onlineappointment.PatientsService.repository.HealthMetricRepository;

@Service
public class HealthMetricService {
    @Autowired
    private HealthMetricRepository healthMetricRepository;

    public HealthMetric addHealthMetric(Long patientId, HealthMetric healthMetric) {
        healthMetric.setPatientId(patientId);
        return healthMetricRepository.save(healthMetric);
    }

    public List<HealthMetric> getHealthMetricsByPatientId(Long patientId) {
        return healthMetricRepository.findByPatientId(patientId);
    }

    public Optional<HealthMetric> getHealthMetric(Long id) {
        return healthMetricRepository.findById(id);
    }

    public HealthMetric updateHealthMetric(Long id, HealthMetric healthMetric) {
        healthMetric.setId(id);
        return healthMetricRepository.save(healthMetric);
    }

    public void deleteHealthMetric(Long id) {
        healthMetricRepository.deleteById(id);
    }
}
