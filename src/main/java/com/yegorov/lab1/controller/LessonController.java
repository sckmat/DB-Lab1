package com.yegorov.lab1.controller;

import com.yegorov.lab1.model.Lesson;
import com.yegorov.lab1.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService service;
    public LessonController(LessonService service) { this.service = service; }

    @PostMapping
    public Lesson create(@RequestParam Long courseId, @RequestBody Lesson lesson) {
        return service.create(lesson, courseId);
    }

    @GetMapping("/by-course/{courseId}")
    public List<Lesson> byCourse(@PathVariable Long courseId) {
        return service.byCourse(courseId);
    }
}
