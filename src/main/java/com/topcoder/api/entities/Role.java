/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The user entity, it is annotated with JPA @Entity and mapped with the "users" database table.
 * It extends IdentifiableEntity and additionally defines the 'handle' field and provides a getter and a setter for it.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends IdentifiableEntity {
    /**
     * The role name.
     */
    @NotNull
    @Column(unique = true)
    private String name;


    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties("roles")
    private List<User> users = new ArrayList<>();

    public void addRole(User user) {
        this.users.add(user);
    }
}
