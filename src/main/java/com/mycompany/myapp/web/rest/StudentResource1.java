package com.mycompany.myapp.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.mycompany.myapp.domain.Student1;
import com.mycompany.myapp.repository.StudentRepository1;
import com.mycompany.myapp.service.StudentService1;


@RestController
@RequestMapping("/api")
public class StudentResource1 {

    private final Logger log = LoggerFactory.getLogger(StudentResource.class);

    private static final String ENTITY_NAME = "student1";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    @Autowired
    StudentService1 studentService1;

    @Autowired
    StudentRepository1 studentRepository1;

    @GetMapping("/students1")
    public List<Student1> getAll(){
        return studentService1.getAllStudent1();
    }


    @GetMapping("/students1/{id}")
    public Optional<Student1> getStudent1(@PathVariable String id){
        // return studentService1.getOne(id);
        return studentRepository1.findById(id);
    }


    @PostMapping("/students1")
    public Student1 createStudent(@RequestBody Student1 student1) throws URISyntaxException {
        // log.debug("REST request to save Student1 : {}", student1);
        // if (student1.getId() != null) {
        //     throw new BadRequestAlertException("A new student cannot already have an ID", ENTITY_NAME, "idexists");
        // }
        return studentService1.addStudent1(student1);
        // return ResponseEntity
        //     .created(new URI("/api/students1/" + result.getId()))
        //     .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId()))
        //     .body(result);
    }

     @DeleteMapping("/students1/{id}")
    public void deleteStudent(@PathVariable String id) {
        log.debug("REST request to delete Student1 : {}", id);
        studentService1.delete(id);
        // return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id)).build();
        
    }
}
