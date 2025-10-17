package com.yegorov.lab1.controller;

import com.yegorov.lab1.model.Enrollment;
import com.yegorov.lab1.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;
    public EnrollmentController(EnrollmentService service) { this.service = service; }

    @PostMapping
    public Enrollment enroll(@RequestParam Long studentId, @RequestParam Long courseId) {
        return service.enroll(studentId, courseId);
    }

    @GetMapping
    public List<Enrollment> all() { return service.all(); }
}
