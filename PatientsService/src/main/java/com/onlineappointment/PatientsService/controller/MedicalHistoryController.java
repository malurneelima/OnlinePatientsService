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

import com.onlineappointment.PatientsService.entity.MedicalHistory;
import com.onlineappointment.PatientsService.service.MedicalHistoryService;

@RestController
@RequestMapping("/patients/{patientId}/medical-history")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping
    public ResponseEntity<MedicalHistory> addMedicalHistory(@PathVariable Long patientId, @RequestBody MedicalHistory medicalHistory) {
        return ResponseEntity.ok(medicalHistoryService.addMedicalHistory(patientId, medicalHistory));
    }

    @GetMapping
    public ResponseEntity<List<MedicalHistory>> getMedicalHistory(@PathVariable Long patientId) {
        return ResponseEntity.ok(medicalHistoryService.getMedicalHistoryByPatientId(patientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistory> getMedicalHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(medicalHistoryService.getMedicalHistory(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistory> updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
        return ResponseEntity.ok(medicalHistoryService.updateMedicalHistory(id, medicalHistory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalHistory(@PathVariable Long id) {
        medicalHistoryService.deleteMedicalHistory(id);
        return ResponseEntity.noContent().build();
    }
}
