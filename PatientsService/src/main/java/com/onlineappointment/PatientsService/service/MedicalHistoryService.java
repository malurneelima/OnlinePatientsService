package com.onlineappointment.PatientsService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.MedicalHistory;
import com.onlineappointment.PatientsService.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
	 @Autowired
	    private MedicalHistoryRepository medicalHistoryRepository;

	    public MedicalHistory addMedicalHistory(Long patientId, MedicalHistory medicalHistory) {
	        medicalHistory.setPatientId(patientId);
	        return medicalHistoryRepository.save(medicalHistory);
	    }

	    public List<MedicalHistory> getMedicalHistoryByPatientId(Long patientId) {
	        return medicalHistoryRepository.findByPatientId(patientId);
	    }

	    public Optional<MedicalHistory> getMedicalHistory(Long id) {
	        return medicalHistoryRepository.findById(id);
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
