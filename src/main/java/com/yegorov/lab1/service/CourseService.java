package com.yegorov.lab1.service;

import com.yegorov.lab1.model.Course;
import com.yegorov.lab1.model.Instructor;
import com.yegorov.lab1.repository.CourseRepository;
import com.yegorov.lab1.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;
    private final InstructorRepository instructorRepository;

    public CourseService(CourseRepository repo, InstructorRepository instructorRepository) {
        this.repo = repo;
        this.instructorRepository = instructorRepository;
    }

    public Course create(Course course) {
        Long instructorId = course.getInstructor() != null ? course.getInstructor().getId() : null;
        if (instructorId != null) {
            Instructor i = instructorRepository.findById(instructorId)
                    .orElseThrow(() -> new IllegalArgumentException("Instructor not found: " + instructorId));
            course.setInstructor(i);
        } else {
            throw new IllegalArgumentException("Instructor is required");
        }
        return repo.save(course);
    }

    public List<Course> search(String keyword) {
        return repo.findByTitleContainingIgnoreCase(keyword == null ? "" : keyword);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
