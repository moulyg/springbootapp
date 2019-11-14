/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.repositories;

import com.topcoder.api.entities.Department;
import com.topcoder.api.entities.User;
import com.topcoder.api.entities.dtos.DepartmentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;

/**
 * This repository provides operations on User entity.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department> {

  Page<Department> findByNameContaining(String name, Pageable pageable);

  /**
   * Gets the used identified by the given handle from the database.
   *
   * @param name The handle of the user to retrieve.
   * @return The User instance corresponding to the given input handle.
   */
  public Department findByName(String name);
}
