package com.yegorov.lab1.service;

import com.yegorov.lab1.model.Instructor;
import com.yegorov.lab1.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repo;
    public InstructorService(InstructorRepository repo) { this.repo = repo; }

    public Instructor create(Instructor i) { return repo.save(i); }
    public List<Instructor> all() { return repo.findAll(); }
}
