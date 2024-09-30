package com.onlineappointment.PatientsService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineappointment.PatientsService.entity.Patient;
import com.onlineappointment.PatientsService.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Long id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public List<Patient> searchPatients(String name, Integer age, String gender) {
        List<Patient> patients = patientRepository.findAll();
		
		 return patients.stream() .filter(p -> (name == null ||
		  p.getName().toLowerCase().contains(name.toLowerCase())) && (age == null ||
		  p.getAge() == age) && (gender == null ||
		  p.getGender().equalsIgnoreCase(gender))) .toList();
		 
        
    }

}
