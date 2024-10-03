package com.onlineappointment.PatientsService.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.Patient;
import com.onlineappointment.PatientsService.exception.ResourceNotFoundException;
import com.onlineappointment.PatientsService.repository.PatientRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PatientService {

	@Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("getPatient","id",id));
    }
    @CircuitBreaker(name="getAllPatientsdb",fallbackMethod ="getAllPatientsFallback" )
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public List<Patient> getAllPatientsFallback(Throwable throwable) {
    	System.out.println("Fallback triggered for getAllPatientsFallback due to: " + throwable.getMessage());
        return Collections.emptyList(); 
    }
    
    public Patient updatePatient(Long id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }
    @CircuitBreaker(name="deletePatientdb",fallbackMethod ="deletePatientFallback" )
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    
    public void deletePatientFallback(Long id,Throwable throwable) {
        System.out.println("Fallback triggered for deletePatientFallback due to: "+throwable.getMessage());
    }

    @CircuitBreaker(name = "searchPatientsdb" , fallbackMethod = "searchPatientsFallback")
    public List<Patient> searchPatients(String name, Integer age, String gender) {
        List<Patient> patients = patientRepository.findAll();
		
		 return patients.stream() .filter(p -> (name == null ||
		  p.getName().toLowerCase().contains(name.toLowerCase())) && (age == null ||
		  p.getAge() == age) && (gender == null ||
		  p.getGender().equalsIgnoreCase(gender))) .toList();
		 
        
    }
    
    public List<Patient> searchPatientsFallback(String name, Integer age, String gender,Throwable throwable) {
    	System.out.println("Fallback triggered for searchPatientsFallback due to: " + throwable.getMessage());
        return Collections.emptyList(); 
		 
        
    }

}
