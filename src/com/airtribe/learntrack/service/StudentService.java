package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import java.util.List;

public class StudentService {

    private StudentRepository repository = new StudentRepository();


    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student getStudentById(int id) {
        Student student = repository.getStudentById(id);
        if (student == null) {
            throw new EntityNotFoundException("Student not found with ID: " + id);
        }
        return student;
    }

    public void setActiveStatus(int id, boolean status) {
        Student student = getStudentById(id);
        student.setActive(status);
    }

    public void removeStudent(int id) {
        Student student = getStudentById(id); // ensures exists
        repository.removeStudent(id);
    }
}