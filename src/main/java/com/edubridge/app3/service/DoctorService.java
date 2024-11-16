package com.edubridge.app3.service;

import com.edubridge.app3.model.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    private List<Doctor> doctorList = new ArrayList<>();

    // Add Doctor
    public void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("Doctor added successfully");
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorList;
    }

    // Get doctor by id
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctorList) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Update doctor
    public void updateDoctor(Doctor doctor) {
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getId() == doctor.getId()) {
                doctorList.set(i, doctor);
                System.out.println("Doctor updated successfully");
                return;
            }
        }
        System.out.println("Doctor not found");
    }

    // Delete doctor by id
    public void deleteDoctor(int id) {
        doctorList.removeIf(doctor -> doctor.getId() == id);
        System.out.println("Doctor deleted successfully");
    }

    // Delete all doctors
    public void deleteAllDoctors() {
        doctorList.clear();
        System.out.println("All doctors deleted");
    }
}
