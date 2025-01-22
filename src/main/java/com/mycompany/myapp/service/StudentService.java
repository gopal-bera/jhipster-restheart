package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Student;
import com.mycompany.myapp.feigns.StudentFeign;
import com.mycompany.myapp.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final StudentFeign studentFeign;

    public StudentService(StudentRepository studentRepository, StudentFeign studentFeign){
        this.studentRepository = studentRepository;
        this.studentFeign = studentFeign;
    }

    
    public Student save(Student student) {
        log.debug("Request to save Student : {}", student);
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        log.debug("Request to save Student : {}", student);
        return studentRepository.save(student);
    }

    public Optional<Student> partialUpdate(Student student) {
        log.debug("Request to partially update Student : {}", student);

        return studentRepository
            .findById(student.getId())
            .map(existingStudent -> {
                if (student.getName() != null) {
                    existingStudent.setName(student.getName());
                }
                if (student.getStream() != null) {
                    existingStudent.setStream(student.getStream());
                }
                if (student.getCourse() != null) {
                    existingStudent.setCourse(student.getCourse());
                }
                if (student.getPercentage() != null) {
                    existingStudent.setPercentage(student.getPercentage());
                }

                return existingStudent;
            })
            .map(studentRepository::save);
    }

    public List<Student> findAll() {
        log.debug("Request to get all Students");
        // List<Student> students = studentFeign.getAll();
        // log.debug("Received students: {}", students);
        // return students;
        return studentFeign.getAll();
        // return studentRepository.findAllWithEagerRelationships();
    }

    public Page<Student> findAllWithEagerRelationships(Pageable pageable) {
        return studentRepository.findAllWithEagerRelationships(pageable);
    }

    public Optional<Student> findOne(String id) {
        log.debug("Request to get Student : {}", id);
        // return studentFeign.getOne(id);
        return studentRepository.findOneWithEagerRelationships(id);
    }

    public void delete(String id) {
        log.debug("Request to delete Student : {}", id);
        studentRepository.deleteById(id);
    }
}
