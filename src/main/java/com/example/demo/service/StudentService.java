package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    void add(StudentModel studentModel);
    void update(int id,StudentModel studentModel);
    void delete(int id);
    StudentDto findById(int id);
    List<StudentDto> findStudentByName(String name);
}
