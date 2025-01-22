package com.mycompany.myapp.repository;

import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.Student1;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StudentRepository1 extends MongoRepository<Student1, String> {
    
}
