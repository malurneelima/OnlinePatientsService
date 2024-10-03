package com.onlineappointment.PatientsService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineappointment.PatientsService.entity.Patient;
import com.onlineappointment.PatientsService.service.PatientService;

@RestController
public class PatientController {
	@Autowired
    private PatientService patientService;

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    @GetMapping("/patient")
    public ResponseEntity<Patient> getPatient(@RequestParam Long id) {
        return new ResponseEntity<>( patientService.getPatient(id),HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PutMapping("/patients")
    public ResponseEntity<Patient> updatePatient(@RequestParam Long id, @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    @DeleteMapping("/patients")
    public ResponseEntity<Void> deletePatient(@RequestParam Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
	

}
