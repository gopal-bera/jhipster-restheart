package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.feigns.StudentFeign;
import com.mycompany.myapp.repository.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;
    private final StudentFeign studentFeign;

    public DepartmentService(DepartmentRepository departmentRepository, StudentFeign studentFeign) {
        this.departmentRepository = departmentRepository;
        this.studentFeign = studentFeign;
    }

    public Department save(Department department) {
        log.debug("Request to save Department : {}", department);
        return departmentRepository.save(department);
    }

    public Department update(Department department) {
        log.debug("Request to save Department : {}", department);
        return departmentRepository.save(department);
    }

    public Optional<Department> partialUpdate(Department department) {
        log.debug("Request to partially update Department : {}", department);

        return departmentRepository
            .findById(department.getId())
            .map(existingDepartment -> {
                if (department.getName() != null) {
                    existingDepartment.setName(department.getName());
                }
                if (department.getLocation() != null) {
                    existingDepartment.setLocation(department.getLocation());
                }
                if (department.getUniversity() != null) {
                    existingDepartment.setUniversity(department.getUniversity());
                }

                return existingDepartment;
            })
            .map(departmentRepository::save);
    }

    public List<Department> findAll() {
        log.debug("Request to get all Departments");
        return departmentRepository.findAllWithEagerRelationships();
        // return studentFeign.getAllDept();
    }

    public Page<Department> findAllWithEagerRelationships(Pageable pageable) {
        return departmentRepository.findAllWithEagerRelationships(pageable);
    }

    public Optional<Department> findOne(String id) {
        log.debug("Request to get Department : {}", id);
        return departmentRepository.findOneWithEagerRelationships(id);
    }

    public void delete(String id) {
        log.debug("Request to delete Department : {}", id);
        departmentRepository.deleteById(id);
    }
}
