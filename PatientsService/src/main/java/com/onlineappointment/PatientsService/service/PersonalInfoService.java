package com.onlineappointment.PatientsService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.PersonalInfo;
import com.onlineappointment.PatientsService.repository.PersonalInfoRepository;

@Service
public class PersonalInfoService {
	 @Autowired
	    private PersonalInfoRepository personalInfoRepository;

	    public PersonalInfo addPersonalInfo(Long patientId, PersonalInfo personalInfo) {
	        personalInfo.setPatientId(patientId);
	        return personalInfoRepository.save(personalInfo);
	    }

	    public PersonalInfo getPersonalInfoByPatientId(Long patientId) {
	        return personalInfoRepository.findByPatientId(patientId);
	    }

	    public PersonalInfo updatePersonalInfo(Long patientId, PersonalInfo personalInfo) {
	        personalInfo.setPatientId(patientId);
	        return personalInfoRepository.save(personalInfo);
	    }

	    public void deletePersonalInfo(Long patientId) {
	        PersonalInfo personalInfo = personalInfoRepository.findByPatientId(patientId);
	        if (personalInfo != null) {
	            personalInfoRepository.delete(personalInfo);
	        }
	    }
}
