package com.onlineappointment.PatientsService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.MedicalHistory;
import com.onlineappointment.PatientsService.exception.ResourceNotFoundException;
import com.onlineappointment.PatientsService.exception.ServiceUnavailableException;
import com.onlineappointment.PatientsService.repository.MedicalHistoryRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MedicalHistoryService {
	 @Autowired
	    private MedicalHistoryRepository medicalHistoryRepository;

	 	@CircuitBreaker(name="addMedicalHistorydb", fallbackMethod = "addMedicalHistoryFallback")
	    public MedicalHistory addMedicalHistory(Long patientId, MedicalHistory medicalHistory) {
	        medicalHistory.setPatientId(patientId);
	        return medicalHistoryRepository.save(medicalHistory);
	    }
	 	public MedicalHistory addMedicalHistoryFallback(Long patientId, MedicalHistory medicalHistory,Throwable throwable) {
	 		System.out.println("Fallback method triggered for addMedicalHistory as :"+throwable.getMessage());
	      	 throw new ServiceUnavailableException("DB service");
		}
	 	
	    public List<MedicalHistory> getMedicalHistoryByPatientId(Long patientId) {
	        return medicalHistoryRepository.findByPatientId(patientId);
	    }

	    public MedicalHistory getMedicalHistory(Long id) {
	        return medicalHistoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("getMedicalHistory", "id", id));
	    }

	    public MedicalHistory updateMedicalHistory(Long id, MedicalHistory medicalHistory) {
	        medicalHistory.setId(id);
	        return medicalHistoryRepository.save(medicalHistory);
	    }

	    public void deleteMedicalHistory(Long id) {
	        medicalHistoryRepository.deleteById(id);
	    }
	    
	    public List<MedicalHistory> searchMedicalHistory(Long patientId, String diagnosis) {
	        List<MedicalHistory> medicalHistories = getMedicalHistoryByPatientId(patientId);
	        return diagnosis == null 
	            ? medicalHistories 
	            : medicalHistories.stream()
	                .filter(mh -> mh.getDiagnosis().toLowerCase().contains(diagnosis.toLowerCase()))
	                .toList();
	    }
}
