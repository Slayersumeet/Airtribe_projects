package com.airtribe.meditrack.entity;

public class Appointment {

    private int id;
    private Doctor doctor;
    private Patient patient;
    private AppointmentStatus status;

    public Appointment(int id, Doctor doctor, Patient patient) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.status = AppointmentStatus.PENDING;
    }

    public int getId() { return id; }

    public void cancel() {
        status = AppointmentStatus.CANCELLED;
    }

    public String toString() {
        return "Appointment{id=" + id +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", status=" + status + "}";
    }
}