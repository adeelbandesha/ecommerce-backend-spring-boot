package com.ecommerce.ecommerce_backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String name;
    private String description;
    private String category;
    private double price;

    // No need for images here → we will receive separately
}
