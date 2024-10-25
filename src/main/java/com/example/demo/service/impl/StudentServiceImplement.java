package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    StudentRepository repository;
    @Autowired
    StudentMapper mapper;
    @Override
    public List<StudentDto> getAll() {
        return repository.getAll().stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }

    @Override
    public void add(StudentModel studentModel) {
        repository.add(mapper.toEntity(studentModel));
    }

    @Override
    public void update(int id,StudentModel studentModel) {
        Student student=repository.findById(id);
        student.setName(studentModel.getName());
        repository.update(student);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public StudentDto findById(int id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    public List<StudentDto> findStudentByName(String name) {
        return repository.findStudentByName(name).stream().map(x->mapper.toDto(x)).collect(Collectors.toList());
    }
}
