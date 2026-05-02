package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.exception.AppointmentNotFoundException;

import java.util.*;

public class AppointmentService {

    private List<Appointment> list = new ArrayList<>();

    public void addAppointment(Appointment a) {
        list.add(a);
    }

    public Appointment getAppointment(int id) throws AppointmentNotFoundException {
        for (Appointment a : list) {
            if (a.getId() == id) return a;
        }
        throw new AppointmentNotFoundException("Appointment not found: " + id);
    }

    public void cancelAppointment(int id) throws AppointmentNotFoundException {
        getAppointment(id).cancel();
    }

    public List<Appointment> getAll() {
        return list;
    }
}