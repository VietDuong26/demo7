package com.example.demo.repository.impl;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryImplement implements StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    StudentMapper mapper;
    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("select * from student", new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt(1),rs.getString(2));
            }
        });
    }

    @Override
    public void add(Student student) {
        jdbcTemplate.update("insert into student(name) value(?)",student.getName());
    }

    @Override
    public void update(Student student) {
        jdbcTemplate.update("update student set name=? where id=?",student.getName(),student.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from student where id=?",id);
    }

    @Override
    public Student findById(int id) {
        return jdbcTemplate.query("select * from student where id=?",new RowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt(1),rs.getString(2));
            }
        },id).get(0);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return jdbcTemplate.query("select * from student where name=?",new RowMapper<Student>(){

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt(1),rs.getString(2));
            }
        },name);
    }
}
