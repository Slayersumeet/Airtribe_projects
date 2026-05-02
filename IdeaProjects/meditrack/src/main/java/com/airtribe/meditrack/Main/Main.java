package com.airtribe.meditrack.Main;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.IdGenerator;
import com.airtribe.meditrack.interfaces.BillingStrategy;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;

public class Main {

    public static void main(String[] args) {

        DoctorService ds = new DoctorService();
        PatientService ps = new PatientService();
        AppointmentService as = new AppointmentService();

        Doctor d = new Doctor(IdGenerator.getInstance().generateId(), "Smith", 45, "Cardio", 500);
        Patient p = new Patient(IdGenerator.getInstance().generateId(), "John", 30);

        ds.addDoctor(d);
        ps.addPatient(p);

        Appointment ap = new Appointment(IdGenerator.getInstance().generateId(), d, p);
        as.addAppointment(ap);

        System.out.println(as.getAll());

        // Exception usage
        try {
            as.cancelAppointment(999);
        } catch (AppointmentNotFoundException e) {
            System.out.println(e.getMessage());
        }

        // Strategy Pattern
        BillingStrategy strategy = new NormalBilling();
        System.out.println("Bill: " + strategy.calculate(500));

        // Streams
        System.out.println("Avg Fee: " + ds.averageFee());
    }
}