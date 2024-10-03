package com.onlineappointment.PatientsService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.HealthMetric;
import com.onlineappointment.PatientsService.exception.ResourceNotFoundException;
import com.onlineappointment.PatientsService.exception.ServiceUnavailableException;
import com.onlineappointment.PatientsService.repository.HealthMetricRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

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

    public HealthMetric getHealthMetric(Long id) {
        return healthMetricRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("getHealthMetric", "id", id));
    }
    
    @CircuitBreaker(name="updateHealthMetricdb",fallbackMethod = "updateHealthMetricFallback")
    public HealthMetric updateHealthMetric(Long id, HealthMetric healthMetric) {
        healthMetric.setId(id);
        return healthMetricRepository.save(healthMetric);
    }
    public HealthMetric updateHealthMetricFallback(Long id, HealthMetric healthMetric,Throwable throwable) {
    	System.out.println("Fallback method triggered for updateHealthMetric as :"+throwable.getMessage());
     	 throw new ServiceUnavailableException("DB service");
    }

    public void deleteHealthMetric(Long id) {
        healthMetricRepository.deleteById(id);
    }
}
