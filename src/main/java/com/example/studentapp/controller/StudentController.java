package com.example.studentapp.controller;

import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public List<StudentEntity> student() {
        return studentService.students();
    }

    @GetMapping(value = "/getStudentById")
    public StudentEntity getByStudentId(@RequestParam int id) {
        return studentService.getByStudentId(id);
    }

    @GetMapping(value = "/getStudentByName")
    public StudentEntity getStudentByName(@RequestParam String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping(value = "/getStudentByNameAndRollNo")
    public StudentEntity GetStudentByNameAndRollNo(@RequestParam String firstName ,@RequestParam int rollNo){
        return studentService.getDetailByNameAndRollNo(firstName, rollNo);
    }

    @PostMapping(value = "/student")
    public StudentEntity addingStudent(@RequestBody StudentEntity studentEntity) {
        return studentService.addingStudent(studentEntity);
    }

    @PutMapping(value = "/student")
    public StudentEntity updateStudent(@RequestBody StudentEntity studentEntity) {
        return studentService.addAndUpdateStudent(studentEntity);
    }

    @DeleteMapping(value = "/student")
    public String deletingStudent(@RequestParam int id) {
        return studentService.deleteStudent(id);
    }



}














