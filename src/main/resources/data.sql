-- ======== Преподаватели ========
INSERT INTO instructor (id, full_name, email)
VALUES
    (1, 'Alice Johnson', 'alice@example.com'),
    (2, 'Bob Smith', 'bob@example.com')
    ON CONFLICT DO NOTHING;

-- ======== Курсы ========
INSERT INTO course (id, title, description, instructor_id)
VALUES
    (1, 'Java Basics', 'Introduction to Java programming language', 1),
    (2, 'Spring Boot Pro', 'Advanced REST API development with Spring Boot', 2)
    ON CONFLICT DO NOTHING;

-- ======== Студенты ========
INSERT INTO student (id, full_name, email)
VALUES
    (1, 'John Doe', 'john@example.com'),
    (2, 'Jane Roe', 'jane@example.com')
    ON CONFLICT DO NOTHING;

-- ======== Уроки ========
INSERT INTO lesson (id, title, content, course_id)
VALUES
    (1, 'Variables and Types', 'Learn about primitive types in Java', 1),
    (2, 'Collections in Java', 'Working with lists, sets and maps', 1),
    (3, 'Controllers and REST', 'Building REST APIs with Spring', 2)
    ON CONFLICT DO NOTHING;

-- ======== Записи на курсы ========
INSERT INTO enrollment (id, student_id, course_id, enrolled_at)
VALUES
    (1, 1, 1, CURRENT_DATE),
    (2, 2, 2, CURRENT_DATE)
    ON CONFLICT DO NOTHING;
