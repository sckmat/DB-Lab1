package com.yegorov.lab1.repository;

import com.yegorov.lab1.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> { }
