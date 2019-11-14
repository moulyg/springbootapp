/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.repositories;

import com.topcoder.api.entities.Role;
import com.topcoder.api.entities.User;
import org.springframework.stereotype.Repository;

/**
 * This repository provides operations on User entity.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Repository
public interface RolesRepository extends BaseRepository<Role> {
  /**
   * Gets the used identified by the given handle from the database.
   *
   * @param name The handle of the user to retrieve.
   * @return The User instance corresponding to the given input handle.
   */
  public Role findByName(String name);
}
