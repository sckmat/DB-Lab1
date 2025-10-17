package com.yegorov.lab1.controller;

import com.yegorov.lab1.model.Course;
import com.yegorov.lab1.model.Enrollment;
import com.yegorov.lab1.model.Student;
import com.yegorov.lab1.service.StudentService;
import com.yegorov.lab1.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    private final CourseRepository courseRepository;

    public StudentController(StudentService service, CourseRepository courseRepository) {
        this.service = service;
        this.courseRepository = courseRepository;
    }

    @PostMapping
    public Student create(@RequestBody Student s) { return service.create(s); }

    @GetMapping
    public List<Student> all() { return service.all(); }

    @GetMapping("/{id}/courses")
    public List<Course> courses(@PathVariable Long id) {
        Student s = service.get(id);
        return s.getEnrollments().stream().map(Enrollment::getCourse).toList();
    }
}
