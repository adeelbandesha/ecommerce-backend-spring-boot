package com.ecommerce.ecommerce_backend.model;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductUploadRequest {

    @Schema(description = "Product Name")
    public String name;

    @Schema(description = "Product Description")
    public String description;

    @Schema(description = "Product Price")
    public double price;

    @Schema(description = "Product Category")
    public String category;

    @Schema(description = "Product Images", type = "array", implementation = MultipartFile.class)
    public List<MultipartFile> images;

}
