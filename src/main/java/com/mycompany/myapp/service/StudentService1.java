package com.mycompany.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.Student;
import com.mycompany.myapp.domain.Student1;
import com.mycompany.myapp.feigns.StudentFeign;
import com.mycompany.myapp.repository.StudentRepository1;

@Service
public class StudentService1 {

    @Autowired
    StudentRepository1 studentRepository1;
    @Autowired 
    StudentFeign studentFeign;

    public List<Student1> getAllStudent1(){
        // return studentFeign.getAll();
        return studentRepository1.findAll();
    }

    public Optional<Student> getOne(String id){
        return studentFeign.getOne(id);
    }

    public Student1 addStudent1(Student1 student1){
        return studentFeign.addOne(student1);
        // return studentRepository1.save(student1);
    }


    public void delete(String id) {
        studentFeign.deleteById(id);
        // studentRepository1.deleteById(id);
    }
}
