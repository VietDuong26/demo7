package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/getAllStudent")
    List<StudentDto> getAllStudent(){
        return studentService.getAll();
    }
    @PostMapping("/addNewStudent")
    ResponseEntity<String> addNewStudent(@ModelAttribute("student")StudentModel model) throws IOException {
        studentService.add(model);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @PostMapping("/updateStudent")
    ResponseEntity<String> updateStudent(@RequestParam("id")int id,@ModelAttribute("student")StudentModel studentModel){
        studentService.update(id,studentModel);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
    @GetMapping("/findStudentById")
    StudentDto findStudentById(@RequestParam("id")int id){
        return  studentService.findById(id);

    }
    @GetMapping("/findStudentByName")
    List<StudentDto> findStudentByName(@RequestParam("name")String name){
        return studentService.findStudentByName(name);
    }
    @PostMapping("/deleteStudent")
    ResponseEntity<String> deleteStudentById(@RequestParam("id")int id){
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("successful");
    }
}
