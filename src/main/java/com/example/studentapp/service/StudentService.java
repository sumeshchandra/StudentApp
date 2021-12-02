package com.example.studentapp.service;

import com.example.studentapp.entity.StudentEntity;
import com.example.studentapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> students() {
        return studentRepository.findAll();
    }

    public StudentEntity getByStudentId(int id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if(studentEntity.isPresent()){
            return studentEntity.get();
        }
        return null;
    }


    public StudentEntity addingStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity addAndUpdateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public String deleteStudent(int id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        if (studentEntity.isPresent()) {
            studentRepository.delete(studentEntity.get());
            return "Record deleted Successfully";
        }
        return "Record does not exists id : " + id;
    }


    public StudentEntity getStudentByName(String name) {
        Optional<StudentEntity> studentEntity = studentRepository.findByFirstName(name);
        if(studentEntity.isPresent())
        return studentEntity.get();
            return null;
    }

    public StudentEntity getDetailByNameAndRollNo(String name, int rollNo) {
        Optional<StudentEntity> studentEntity = studentRepository.findByFirstNameAndRollNo(name, rollNo);
        if(studentEntity.isPresent())
            studentRepository.save(studentEntity.get());
        return studentEntity.get();
    }
}
