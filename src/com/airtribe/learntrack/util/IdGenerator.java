package com.airtribe.learntrack.util;

public class IdGenerator {

    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1;
    private static int enrollmentIdCounter = 1;

    public static int getStudentId() {
        return studentIdCounter++;
    }

    public static int getCourseId() {
        return courseIdCounter++;
    }
    public static int getEnrollmentId() {
        return enrollmentIdCounter++;
    }
}