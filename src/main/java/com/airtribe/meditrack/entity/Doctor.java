package com.airtribe.meditrack.entity;

public class Doctor extends Person {

    private String specialization;
    private double fee;

    public Doctor(int id, String name, int age, String specialization, double fee) {
        super(id, name, age);
        this.specialization = specialization;
        this.fee = fee;
    }

    public String getSpecialization() { return specialization; }
    public double getFee() { return fee; }

    public String toString() {
        return "Doctor{id=" + id + ", name=" + name + "}";
    }
}