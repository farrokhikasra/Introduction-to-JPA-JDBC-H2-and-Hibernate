package com.springboot.learnjpaandhibernate.course.springdatajpa;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);
    List<Course> findByname(String name);
}
