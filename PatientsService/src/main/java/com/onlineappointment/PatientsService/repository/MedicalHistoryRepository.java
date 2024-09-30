package com.onlineappointment.PatientsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.PatientsService.entity.MedicalHistory;
@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
	List<MedicalHistory> findByPatientId(Long patientId);
}
