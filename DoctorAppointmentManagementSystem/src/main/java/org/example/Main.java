package org.example;

import services.AppointmentBookingService;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AppointmentBookingService aptBookingService = new AppointmentBookingService();
        aptBookingService.registerDoctor("Curios", "Cardiologist");
        aptBookingService.markDocAvail("Curios", Arrays.asList("9:00-10:00", "10:00-11:00"));
    }
}