package com.ecommerce.ecommerce_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> data;
    private long totalResults;
    private int currentPage;
    private int totalPages;
}
