package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Student entity.
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{}")
    Page<Student> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Student> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Student> findOneWithEagerRelationships(String id);
}
