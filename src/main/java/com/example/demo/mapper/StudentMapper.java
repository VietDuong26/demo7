package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.model.StudentModel;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDto toDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .build();
    }

    public Student toEntity(StudentModel studentModel) {
        return Student.builder()
                .name(studentModel.getName())
                .build();
    }

}
