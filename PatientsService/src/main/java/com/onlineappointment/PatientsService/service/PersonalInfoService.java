package com.onlineappointment.PatientsService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.PersonalInfo;
import com.onlineappointment.PatientsService.exception.ServiceUnavailableException;
import com.onlineappointment.PatientsService.repository.PersonalInfoRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PersonalInfoService {
	 @Autowired
	    private PersonalInfoRepository personalInfoRepository;
	 
	 	@CircuitBreaker(name="addPersonalInfodb",fallbackMethod = "addPersonalInfoFallback")
	    public PersonalInfo addPersonalInfo(Long patientId, PersonalInfo personalInfo) {
	        personalInfo.setPatientId(patientId);
	        return personalInfoRepository.save(personalInfo);
	    }
	 	
	 	public PersonalInfo addPersonalInfoFallback(Long patientId, PersonalInfo personalInfo,Throwable throwable) {
	 		System.out.println("Fallback method triggered for addPersonalInfodb as :"+throwable.getMessage());
	      	 throw new ServiceUnavailableException("DB service");
	    }

	    public PersonalInfo getPersonalInfoByPatientId(Long patientId) {
	        return personalInfoRepository.findByPatientId(patientId);
	    }
	    
	    @CircuitBreaker(name="updatePersonalInfodb",fallbackMethod = "updatePersonalInfoFallback")
	    public PersonalInfo updatePersonalInfo(Long patientId, PersonalInfo personalInfo) {
	        personalInfo.setPatientId(patientId);
	        return personalInfoRepository.save(personalInfo);
	    }
	    
	    public PersonalInfo updatePersonalInfoFallback(Long patientId, PersonalInfo personalInfo, Throwable throwable) {
	    	System.out.println("Fallback method triggered for updatePersonalInfo as :"+throwable.getMessage());
	      	 throw new ServiceUnavailableException("DB service");
	    }

	    public void deletePersonalInfo(Long patientId) {
	        PersonalInfo personalInfo = personalInfoRepository.findByPatientId(patientId);
	        if (personalInfo != null) {
	            personalInfoRepository.delete(personalInfo);
	        }
	    }
}
