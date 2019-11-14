/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * The user entity, it is annotated with JPA @Entity and mapped with the "users" database table.
 * It extends IdentifiableEntity and additionally defines the 'handle' field and provides a getter and a setter for it.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@Table(name = "department")
@Getter
@Setter
@ToString(callSuper = true)
public class Department extends IdentifiableEntity {
  /**
   * The user handle.
   */
  @NotNull
  @Column(unique = true)
  private String name;

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.EAGER,
          mappedBy = "department")
  @JsonIgnoreProperties(value = {"department", "roles"})
  private Set<User> users = new HashSet<>();
}
