package com.yegorov.lab1.service;

import com.yegorov.lab1.model.Student;
import com.yegorov.lab1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo) { this.repo = repo; }

    public Student create(Student s) { return repo.save(s); }
    public List<Student> all() { return repo.findAll(); }
    public Student get(Long id){ return repo.findById(id).orElseThrow(); }
}
