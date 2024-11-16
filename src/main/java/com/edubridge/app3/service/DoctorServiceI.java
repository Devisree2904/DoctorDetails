package com.edubridge.app3.service;

import java.util.List;

import com.edubridge.app3.model.Doctor;

public interface DoctorServiceI {
	void addDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();	
	Doctor getDoctorById(Integer id);
	void updateDoctor(Doctor doctor);
	void deleteDoctor(Integer id);
	void deleteAllDoctors();
}

