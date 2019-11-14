/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * This class is a simple data transfer object which holds the user handle.
 * It provides a getter and a setter for the defined field.
 *
 * @author TCSCODER
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class DepartmentRequest {
  /**
   *
   * The user handle.
   */
  @NotBlank
  private String name;
}
