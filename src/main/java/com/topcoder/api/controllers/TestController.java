/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.controllers;

import com.topcoder.api.Utils;
import com.topcoder.api.entities.Department;
import com.topcoder.api.entities.dtos.DepartmentRequest;
import com.topcoder.api.entities.dtos.DepartmentResponse;
import com.topcoder.api.entities.dtos.PageResponse;
import com.topcoder.api.services.Departmentervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * This controller provides endpoints for user management.
 *
 * @author TCSCODER
 * @version 1.0
 */
@RestController
@RequestMapping("/departments")
public class TestController {
    /**
     * The user service used to manage user entity in the backend.
     * It is inject by Spring.
     */
    @Autowired
    private Departmentervice departmentervice;

    /**
     * Check if all the configuration parameters are properly initialized.
     *
     * @throws ConfigurationException if userService is not properly initialized.
     */
    @PostConstruct
    public void init() {
        Utils.checkNull(departmentervice, "departmentervice");
    }

    /**
     * Handles the create user Http request.
     *
     * @param request The UserRequest instance which holds the handle of the user to create.
     * @return The created User instance.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Department create(@Valid @RequestBody DepartmentRequest request) {
        return departmentervice.create(request);
    }

    /**
     * Handles the request for getting all available users.
     *
     * @return The list of all available users.
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<Department> getUsers() {
        return departmentervice.getAllDepartments();
    }


    /**
     * Handles the request for deleting a single user identified by the given userId.
     *
     * @param departmentId The id of the user to delete.
     */
    @DeleteMapping(path = "/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID departmentId) {
        departmentervice.delete(departmentId);
    }
}
