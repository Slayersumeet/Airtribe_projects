package com.airtribe.learntrack.service;

import java.util.List;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.exception.EntityNotFoundException;

public class CourseService {

    private CourseRepository repository = new CourseRepository();

    public void addCourse(Course course) {
        repository.addCourse(course);
    }

    public List<Course> getAllCourses() {
        return repository.getAllCourses();
    }

    public Course getCourseById(int id) {
        Course course = repository.getCourseById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        return course;
    }
    public void deactivateCourse(int id) {
        Course course = repository.getCourseById(id);
        if (course == null) {
            throw new EntityNotFoundException("Course not found with ID: " + id);
        }
        course.setActive(false);
    }

    public void removeCourse(int id) {
        repository.removeCourse(id);
    }
}