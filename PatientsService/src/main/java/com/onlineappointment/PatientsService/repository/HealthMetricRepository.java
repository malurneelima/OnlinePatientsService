package com.onlineappointment.PatientsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.PatientsService.entity.HealthMetric;
@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetric, Long> {
	List<HealthMetric> findByPatientId(Long patientId);
}
