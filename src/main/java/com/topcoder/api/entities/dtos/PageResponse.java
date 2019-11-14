package com.topcoder.api.entities.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {
    private List<T> rows;
    private int page;
    private int pageSize;
    private long total;
}
