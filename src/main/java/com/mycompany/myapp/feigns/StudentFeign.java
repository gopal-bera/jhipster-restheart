package com.mycompany.myapp.feigns;

import java.util.List;
import java.util.Optional;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.domain.Student;
import com.mycompany.myapp.domain.Student1;

@FeignClient(name = "student-feign", url = "http://localhost:8080/jhipsterRest")
public interface StudentFeign {
    @GetMapping("/student")
    public List<Student> getAllStud();

    @GetMapping("/student/{id}")
    public Optional<Student> getOneStud(@PathVariable String id);

    @PostMapping("/student1/")
    public Student1 addOne(Student1 student1);

    @DeleteMapping("/student1/{id}")
    public void deleteById(@PathVariable String id);

    @GetMapping("/department")
    public List<Department> getAllDept();
}
