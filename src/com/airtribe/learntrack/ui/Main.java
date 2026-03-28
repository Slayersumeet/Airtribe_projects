package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;
import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    static StudentService studentService = new StudentService();
    static CourseService courseService = new CourseService();
    static EnrollmentService enrollmentService = new EnrollmentService();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n======= LearnTrack Management System =======");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> studentMenu();
                case 2 -> courseMenu();
                case 3 -> enrollmentMenu();
                case 0 -> {
                    System.out.println("Exiting Application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void studentMenu() {
        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Delete Student");
            System.out.println("0. Back");

            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {

                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> findStudent();
                case 4 -> deactivateStudent();
                case 5 -> deleteStudent();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter First Name: ");
        String fn = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String ln = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Batch: ");
        String batch = sc.nextLine();

        Student st = new Student(IdGenerator.getStudentId(), fn, ln, email, batch);
        studentService.addStudent(st);
        System.out.println("Student Added Successfully!");
    }

    private static void viewStudents() {
        List<Student> list = studentService.getAllStudents();
        if(list.isEmpty()) System.out.println("No students available");
        list.forEach(System.out::println);
    }

    private static void findStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        try {
            System.out.println(studentService.getStudentById(id));
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deactivateStudent() {
        System.out.print("Enter ID to deactivate: ");
        int id = sc.nextInt();

        try {
            studentService.setActiveStatus(id, false);
            System.out.println("Student Deactivated");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        try {
            studentService.removeStudent(id);
            System.out.println("Student Removed");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void courseMenu(){
        while(true){
            System.out.println("\n--- Course Menu ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Courses");
            System.out.println("3. Search Course by ID");
            System.out.println("4. Deactivate Course");
            System.out.println("5. Delete Course");
            System.out.println("0. Back");

            int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1 -> addCourse();
                case 2 -> viewCourses();
                case 3 -> findCourse();
                case 4 -> deactivateCourse();
                case 5 -> deleteCourse();
                case 0 -> { return;}
                default -> System.out.println("Invalid!");
            }
        }
    }

    private static void addCourse(){
        System.out.print("Course Name: ");
        String name = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Duration (weeks): ");
        int weeks = sc.nextInt();

        Course c = new Course(IdGenerator.getCourseId(), name, desc, weeks);
        courseService.addCourse(c);
        System.out.println("Course Added!");
    }

    private static void viewCourses(){
        List<Course> list = courseService.getAllCourses();
        if(list.isEmpty()) System.out.println("No courses found");

        list.forEach(System.out::println);
    }

    private static void findCourse(){
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();

        try{
            System.out.println(courseService.getCourseById(id));
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deactivateCourse(){
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();

        try{
            courseService.deactivateCourse(id);
            System.out.println("Course Deactivated");
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteCourse(){
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();

        try{
            courseService.removeCourse(id);
            System.out.println("Course Removed");
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }



    private static void enrollmentMenu(){
        while(true){
            System.out.println("\n--- Enrollment Menu ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollments");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Enrollment");
            System.out.println("0. Back");

            int ch=sc.nextInt(); sc.nextLine();
            switch(ch){
                case 1 -> enrollStudent();
                case 2 -> viewEnrollment();
                case 3 -> updateStatus();
                case 4 -> deleteEnrollment();
                case 0 -> { return;}
                default -> System.out.println("Invalid!");
            }
        }
    }

    private static void enrollStudent(){
        System.out.print("Enter Student ID: ");
        int sid=sc.nextInt();

        System.out.print("Enter Course ID: ");
        int cid=sc.nextInt();

        Enrollment e = new Enrollment(IdGenerator.getEnrollmentId(), sid, cid, LocalDate.now(), "ACTIVE");
        enrollmentService.addEnrollment(e);

        System.out.println("Enrollment Created!");
    }

    private static void viewEnrollment(){
        List<Enrollment> list=enrollmentService.getAllEnrollments();
        if(list.isEmpty()) System.out.println("No enrollments yet");
        list.forEach(System.out::println);
    }

    private static void updateStatus(){
        System.out.print("Enrollment ID: ");
        int id=sc.nextInt(); sc.nextLine();

        System.out.print("New Status (ACTIVE/COMPLETED/CANCELLED): ");
        String st=sc.nextLine();

        try{
            enrollmentService.updateStatus(id, st);
            System.out.println("Status Updated");
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void deleteEnrollment(){
        System.out.print("Enrollment ID to remove: ");
        int id=sc.nextInt();

        try{
            enrollmentService.removeEnrollment(id);
            System.out.println("Enrollment deleted");
        }catch(EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}