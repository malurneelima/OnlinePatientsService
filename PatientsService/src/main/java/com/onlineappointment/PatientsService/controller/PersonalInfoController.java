package com.onlineappointment.PatientsService.controller;

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

import com.onlineappointment.PatientsService.entity.PersonalInfo;
import com.onlineappointment.PatientsService.service.PersonalInfoService;

@RestController
@RequestMapping("/patients/{patientId}/personal-info")
public class PersonalInfoController {

	@Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping
    public ResponseEntity<PersonalInfo> addPersonalInfo(@PathVariable Long patientId, @RequestBody PersonalInfo personalInfo) {
        return ResponseEntity.ok(personalInfoService.addPersonalInfo(patientId, personalInfo));
    }

    @GetMapping
    public ResponseEntity<PersonalInfo> getPersonalInfo(@PathVariable Long patientId) {
        return ResponseEntity.ok(personalInfoService.getPersonalInfoByPatientId(patientId));
    }

    @PutMapping
    public ResponseEntity<PersonalInfo> updatePersonalInfo(@PathVariable Long patientId, @RequestBody PersonalInfo personalInfo) {
        return ResponseEntity.ok(personalInfoService.updatePersonalInfo(patientId, personalInfo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePersonalInfo(@PathVariable Long patientId) {
        personalInfoService.deletePersonalInfo(patientId);
        return ResponseEntity.noContent().build();
    

}
}
