package com.yegorov.lab1.service;

import com.yegorov.lab1.model.Course;
import com.yegorov.lab1.model.Enrollment;
import com.yegorov.lab1.model.Student;
import com.yegorov.lab1.repository.CourseRepository;
import com.yegorov.lab1.repository.EnrollmentRepository;
import com.yegorov.lab1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repo;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository repo, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.repo = repo;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Enrollment enroll(Long studentId, Long courseId) {
        if (repo.existsByStudentIdAndCourseId(studentId, courseId)) {
            throw new IllegalStateException("Student already enrolled to this course");
        }
        Student student = studentRepository.findById(studentId).orElseThrow();
        Course course = courseRepository.findById(courseId).orElseThrow();
        Enrollment e = new Enrollment();
        e.setStudent(student);
        e.setCourse(course);
        return repo.save(e);
    }

    public List<Enrollment> all() { return repo.findAll(); }
}
