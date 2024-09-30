package com.onlineappointment.PatientsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineappointment.PatientsService.entity.PersonalInfo;

@Repository
public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
	PersonalInfo findByPatientId(Long patientId);
}
