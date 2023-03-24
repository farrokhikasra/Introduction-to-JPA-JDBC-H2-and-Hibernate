package com.springboot.learnjpaandhibernate.course.jdbc;

import com.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;
    private static String INSERT_QUERY =
            """
                    insert into course values(?, ?, ?);
                    """;
    private static String DELETE_ID_QUERY =
            """
                    delete from course where id = ?;
                    """;

    private static String SELECT_BY_ID =
            """
                    select * from course where id = ?;
                    """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteByID(long id) {
        springJdbcTemplate.update(DELETE_ID_QUERY, id);
    }

    public Course findByID(long id) {
        return springJdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
