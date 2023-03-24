package com.springboot.learnjpaandhibernate.course;

import com.springboot.learnjpaandhibernate.course.Course;
import com.springboot.learnjpaandhibernate.course.jdbc.CourseJDBCRepository;
import com.springboot.learnjpaandhibernate.course.jpa.CourseJPARepository;
import com.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJDBCRepository repositoryJDBC;

    @Autowired
    private CourseJPARepository repositoryJPA;

    @Autowired
    private CourseSpringDataJPARepository springDataJPARepository;

    @Override
    public void run(String... args) throws Exception {
        //courseJPArun();
        //courseJDCBrun();
        courseSpringDataJpaRun();
    }

    public void courseSpringDataJpaRun(){
        springDataJPARepository.save(new Course(1, "Learn Azure now with JPA Spring!", "Pouria Alikhani Fard"));
        springDataJPARepository.save(new Course(2, "Learn AWS now with JPA Spring!", "Kasra Farrokhi"));
        springDataJPARepository.save(new Course(3, "Learn Advance Programming with JPA Spring!", "Pedram Noori"));
        springDataJPARepository.deleteById(1L);

        System.out.println(springDataJPARepository.findById(2L));
        System.out.println(springDataJPARepository.findAll());
        System.out.println(springDataJPARepository.count());
        System.out.println(springDataJPARepository.findByAuthor("Kasra Farrokhi"));
        System.out.println(springDataJPARepository.findByname("Learn Advance Programming with JPA Spring!"));

    }

    public void courseJPArun() {
        repositoryJPA.insert(new Course(1, "Learn Azure now with JPA!", "Pouria Alikhani Fard"));
        repositoryJPA.insert(new Course(2, "Learn AWS now with JPA!", "Kasra Farrokhi"));
        repositoryJPA.insert(new Course(3, "Learn Advance Programming with JPA!", "Pedram Noori"));
        repositoryJPA.deleteById(1);

        System.out.println(repositoryJPA.findById(2));
    }

    public void courseJDCBrun() {
        repositoryJDBC.insert(new Course(1, "Learn Azure now with JDBC!", "Pouria Alikhani Fard"));
        repositoryJDBC.insert(new Course(2, "Learn AWS now with JDBC!", "Kasra Farrokhi"));
        repositoryJDBC.insert(new Course(3, "Learn Advance Programming with JDBC!", "Pedram Noori"));
        repositoryJDBC.deleteByID(1);

        System.out.println(repositoryJDBC.findByID(2));
    }
}
