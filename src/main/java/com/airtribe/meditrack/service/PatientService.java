package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import java.util.*;

public class PatientService {

    private List<Patient> list = new ArrayList<>();

    public void addPatient(Patient p) {
        list.add(p);
    }

    public Patient getPatient(int id) {
        for (Patient p : list) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    // Method Overloading
    public List<Patient> searchPatient(int id) {
        return list.stream().filter(p -> p.getId() == id).toList();
    }

    public List<Patient> searchPatient(String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }
}