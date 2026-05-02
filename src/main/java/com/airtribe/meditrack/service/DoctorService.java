package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import java.util.*;

public class DoctorService {

    private List<Doctor> list = new ArrayList<>();

    public void addDoctor(Doctor d) {
        list.add(d);
    }

    public Doctor getDoctor(int id) {
        for (Doctor d : list) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public double averageFee() {
        return list.stream()
                .mapToDouble(Doctor::getFee)
                .average()
                .orElse(0);
    }
}