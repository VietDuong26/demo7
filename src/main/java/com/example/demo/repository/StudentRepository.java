package com.example.demo.repository;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();
    void add(Student student);
    void update(Student student);
    void delete(int id);
    Student findById(int id);
    List<Student> findStudentByName(String name);
}
