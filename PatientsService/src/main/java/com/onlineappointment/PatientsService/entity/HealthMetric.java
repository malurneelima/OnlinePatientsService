package com.onlineappointment.PatientsService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "health_metrics")
	public class HealthMetric {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private Long patientId; 
	    private Double height; 
	    private Double weight; 
	    private String bloodPressure;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getPatientId() {
			return patientId;
		}
		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}
		public Double getHeight() {
			return height;
		}
		public void setHeight(Double height) {
			this.height = height;
		}
		public Double getWeight() {
			return weight;
		}
		public void setWeight(Double weight) {
			this.weight = weight;
		}
		public String getBloodPressure() {
			return bloodPressure;
		}
		public void setBloodPressure(String bloodPressure) {
			this.bloodPressure = bloodPressure;
		}
	    
	    
}

