package models;

public class Appointment {
    private int appointmentId;
    private final Doctor doctor;
    private final Patient patient;
    private final String slot;

    public Appointment(int appointmentId, Doctor doctor, Patient patient, String slot) {
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int id) {
        appointmentId = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getSlot() {
        return slot;
    }
}
