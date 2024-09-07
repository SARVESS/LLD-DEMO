package models;

import java.util.List;
import java.util.Objects;

public class Patient {
    private final String name;
    private List<Appointment> appointments;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public boolean cancelAppointment(int appointmentId) {
        for(Appointment appointment : appointments) {
            if(appointment.getAppointmentId() == appointmentId) {
                appointments.remove(appointment);
                return true;
            }
        }
        return false;
    }
}
