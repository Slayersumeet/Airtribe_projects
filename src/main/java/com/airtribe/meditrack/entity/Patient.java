package com.airtribe.meditrack.entity;

public class Patient extends Person implements Cloneable {

    public Patient(int id, String name, int age) {
        super(id, name, age);
    }

    public Patient clone() {
        return new Patient(id, name, age);
    }

    public String toString() {
        return "Patient{id=" + id + ", name=" + name + "}";
    }
}