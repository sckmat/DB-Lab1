package com.yegorov.lab1.repository;

import com.yegorov.lab1.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("select l from Lesson l where l.course.id = :courseId order by l.id")
    List<Lesson> findByCourseId(Long courseId);
}
