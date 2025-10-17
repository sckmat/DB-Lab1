package com.yegorov.lab1.controller;

import com.yegorov.lab1.model.Course;
import com.yegorov.lab1.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) { this.service = service; }

    @PostMapping
    public Course create(@RequestBody Course course) { return service.create(course); }

    @GetMapping
    public List<Course> list(@RequestParam(required = false) String keyword) {
        return service.search(keyword);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
