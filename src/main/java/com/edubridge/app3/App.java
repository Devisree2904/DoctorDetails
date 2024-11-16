package com.edubridge.app3;

import java.util.List;
import java.util.Scanner;

import com.edubridge.app3.model.Doctor; // Import Doctor model
import com.edubridge.app3.service.DoctorService; // Import modified service

public class App {
    public static void main(String[] args) {
        int option = 0;
        Scanner in = new Scanner(System.in);
        DoctorService service = new DoctorService(); // Instantiate service for doctors
        String name, email, mobile;
        name = email = mobile = null;
        int status = 0;

        do {
            System.out.println("Welcome to Doctor Management Application");
            System.out.println("=======================================");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Delete All Doctors");
            System.out.println("0. Exit");
            System.out.println("Please choose option: ");
            option = in.nextInt();

            switch (option) {
            case 1:
                System.out.println("Add New Doctor");
                System.out.println("------------");
                System.out.println("Enter Doctor Name: ");
                name = in.next();
                System.out.println("Enter Doctor Email: ");
                email = in.next();
                System.out.println("Enter Doctor Mobile: ");
                mobile = in.next();

                Doctor doctor = new Doctor();
                doctor.setName(name);
                doctor.setEmail(email);
                doctor.setMobile(mobile);

                service.addDoctor(doctor); // Add doctor to the service
                break;

            case 2:
                System.out.println("View All Doctors");
                System.out.println("-----------------");
                List<Doctor> doctors = service.getAllDoctors(); // Fetch all doctors
                if (doctors.size() != 0) {
                    for (Doctor d : doctors) {
                        System.out.println(d.getId() + "\t" + d.getName() + "\t" + d.getEmail() + "\t" + d.getMobile());
                    }
                } else {
                    System.out.println("No doctors found");
                }
                break;

            case 3:
                System.out.println("Search Doctor");
                System.out.println("---------------");
                System.out.println("Please enter doctor id: ");
                int id = in.nextInt();
                Doctor d = service.getDoctorById(id); // Fetch doctor by ID
                if (d != null) {
                    System.out.println("Doctor Name: " + d.getName());
                    System.out.println("Doctor Email: " + d.getEmail());
                    System.out.println("Doctor Mobile: " + d.getMobile());
                } else {
                    System.out.println("No doctor found with id: " + id);
                }
                break;
                
            case 4:
                System.out.println("Update Doctor Details");
                System.out.println("----------------------");
                System.out.println("Enter Doctor Id: ");
                int doctorId = in.nextInt();
                System.out.println("Enter Doctor Name: ");
                name = in.next();
                System.out.println("Enter Doctor Email: ");
                email = in.next();
                System.out.println("Enter Doctor Mobile: ");
                mobile = in.next();

                Doctor updatedDoctor = new Doctor();
                updatedDoctor.setId(doctorId);
                updatedDoctor.setName(name);
                updatedDoctor.setEmail(email);
                updatedDoctor.setMobile(mobile);

                service.updateDoctor(updatedDoctor); // Update doctor information
                break;
                
            case 5:
                System.out.println("Delete Doctor");
                System.out.println("--------------");
                System.out.println("Please enter doctor id: ");
                int doctorIdToDelete = in.nextInt();
                service.deleteDoctor(doctorIdToDelete); // Delete a doctor by ID
                break;

            case 6:
                System.out.println("Are you sure you want to delete all doctors? [Y/N]");
                String confirm = in.next();
                if (confirm.equalsIgnoreCase("Y")) {
                    service.deleteAllDoctors(); // Delete all doctors
                }
                break;
                
            case 0:
                System.out.println("Bye!!!");
                System.exit(0);
                break;
                
            default:
                System.out.println("Please choose a correct option.");
                break;
            }

        } while (option != 0);
    }
}
