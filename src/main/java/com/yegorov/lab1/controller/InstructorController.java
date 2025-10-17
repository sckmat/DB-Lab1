package com.yegorov.lab1.controller;

import com.yegorov.lab1.model.Instructor;
import com.yegorov.lab1.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService service;
    public InstructorController(InstructorService service) { this.service = service; }

    @PostMapping
    public Instructor create(@RequestBody Instructor i) { return service.create(i); }

    @GetMapping
    public List<Instructor> all() { return service.all(); }
}
