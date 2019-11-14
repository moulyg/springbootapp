/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.services;

import com.topcoder.api.Utils;
import com.topcoder.api.entities.Department;
import com.topcoder.api.entities.dtos.DepartmentRequest;
import com.topcoder.api.entities.dtos.DepartmentResponse;
import com.topcoder.api.entities.dtos.PageResponse;
import com.topcoder.api.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The service provides User related CRUD operations.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Service
@Transactional
public class Departmentervice extends BaseService {
    /**
     * The user repository used to manage user data in the database.
     * It is injected by Spring, it should not be null.
     */
    @Autowired
    private DepartmentRepository departmentRepository;

    /**
     * Check if all the configuration parameters are properly initialized.
     *
     * @throws ConfigurationException if userRepository is not properly initialized.
     */
    @PostConstruct
    public void init() {
        Utils.checkNull(departmentRepository, "departmentRepository");
    }

    /**
     * Creates a User instance in the database using the handle specified in the given UserRequest.
     *
     * @param request The UserRequest which contains the handle of the user to create.
     * @return The created User instance.
     */
    public Department create(DepartmentRequest request) {
        // Check if the user handle already exists
        Department existingDepartment = departmentRepository.findByName(request.getName());
        if (existingDepartment != null) {
            throw new IllegalArgumentException(String.format("The department name '%s' already exists", request.getName()));
        }

        Department department = new Department();
        department.setName(request.getName());

        return departmentRepository.save(department);
    }

    /**
     * Retrieved the list of all users from the database.
     *
     * @return The List of all users in the database.
     */
    @Transactional(readOnly = true)
    public PageResponse<Department> getAllDepartments() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        int pageNumber = 2, pageSize = 3;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sort);
        Page<Department> allDepartments = departmentRepository.findByNameContaining("", pageable);
        PageResponse<Department> result = new PageResponse<>();
        result.setPage(allDepartments.getNumber());
        result.setPageSize(allDepartments.getSize());
        result.setTotal(allDepartments.getTotalElements());
        result.setRows(allDepartments.getContent());
        return result;
    }


    /**
     * Deletes the user identified by the given userId from the database.
     *
     * @param departmentId The id of the user to delete.
     */
    public void delete(UUID departmentId) {
        // check if user exists
        getUserById(departmentId);

        // Delete the user
        departmentRepository.deleteById(departmentId);
    }

    /**
     * This private method gets a user by its id.
     * It throws EntityNotFoundException if the user is not found.
     *
     * @param departmentId The id of the user to search for.
     * @return The User instance identified by the given id.
     */
    private Department getUserById(UUID departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if (!department.isPresent()) {
            throw new EntityNotFoundException(String.format("The department identified by id = %s does not exist", departmentId));
        }
        return department.get();
    }
}
