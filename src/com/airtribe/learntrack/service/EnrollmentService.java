package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository repository = new EnrollmentRepository();

    public void addEnrollment(Enrollment enrollment) {
        repository.addEnrollment(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return repository.getAllEnrollments();
    }

    public Enrollment getEnrollmentById(int id) {
        Enrollment enrollment = repository.getEnrollmentById(id);
        if (enrollment == null) {
            throw new EntityNotFoundException("Enrollment not found with ID: " + id);
        }
        return enrollment;
    }
    public void updateStatus(int id, String status) {
        Enrollment enrollment = getEnrollmentById(id);
        enrollment.setStatus(status);
    }

    public void removeEnrollment(int id) {
        Enrollment e = getEnrollmentById(id); // ensures exists
        repository.removeEnrollment(id);
    }
}