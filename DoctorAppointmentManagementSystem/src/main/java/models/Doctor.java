package models;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private final String name;
    private final String speciality;
    private List<String> availableSots;

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        this.availableSots = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void addSlots(List<String> slots) {
        availableSots = slots;
    }

    public List<String> getAvailableSots() {
        return availableSots;
    }
}
