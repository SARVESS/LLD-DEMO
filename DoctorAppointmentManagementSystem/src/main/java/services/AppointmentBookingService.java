package services;

import models.Appointment;
import models.Doctor;
import models.Patient;

import java.util.HashMap;
import java.util.List;

public class AppointmentBookingService {
    private HashMap<String, Doctor> doctors;
    private HashMap<String, Patient> patients;
    private HashMap<Integer, Appointment> appointments;
    private int appointmentNumber;

    public AppointmentBookingService() {
        doctors = new HashMap<>();
        patients = new HashMap<>();
        appointments = new HashMap<>();
        appointmentNumber = 0;
    }

    public void registerDoctor(String name, String speciality) {
        if(!doctors.containsKey(name)) {
            Doctor doc = new Doctor(name, speciality);
            doctors.put(name, doc);
            System.out.println("Welcome Dr. " + name + "!!");
        } else {
            System.out.println("Doctor already exists");
        }
    }

    public void markDocAvail(String name, List<String> slots) {
        if(doctors.containsKey(name)) {
            Doctor doc = doctors.get(name);
            doc.addSlots(slots);
            System.out.println("Done Doc!");
        } else {
            System.out.println("Doctor is not registered !!");
        }
    }
}
