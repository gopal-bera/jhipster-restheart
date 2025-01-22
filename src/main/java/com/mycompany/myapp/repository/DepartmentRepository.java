package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Department;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Department entity.
 */
@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
    @Query("{}")
    Page<Department> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Department> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Department> findOneWithEagerRelationships(String id);
}
