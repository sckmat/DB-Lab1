package com.yegorov.lab1.service;

import com.yegorov.lab1.model.Course;
import com.yegorov.lab1.model.Lesson;
import com.yegorov.lab1.repository.CourseRepository;
import com.yegorov.lab1.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepository repo;
    private final CourseRepository courseRepository;

    public LessonService(LessonRepository repo, CourseRepository courseRepository) {
        this.repo = repo;
        this.courseRepository = courseRepository;
    }

    public Lesson create(Lesson lesson, Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseId));
        lesson.setCourse(course);
        return repo.save(lesson);
    }

    public List<Lesson> byCourse(Long courseId) {
        return repo.findByCourseId(courseId);
    }
}
