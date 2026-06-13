
package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import java.util.ArrayList;
import java.util.List;


public class EnrollmentRepository {

    private List<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollments;
    }

    public Enrollment getEnrollmentById(int id) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) return e;
        }
        return null;
    }
    public void removeEnrollment(int id) {
        enrollments.removeIf(e -> e.getId() == id);
    }
}
