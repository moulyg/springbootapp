/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities.dtos;


import java.util.Set;
import java.util.UUID;

/**
 * This class is a simple data transfer object which holds the user handle.
 * It provides a getter and a setter for the defined field.
 *
 * @author TCSCODER
 * @version 1.0
 */
public interface DepartmentResponse {
    UUID getId();

    String getName();

    Set<UserResponse> getUsers();
}

