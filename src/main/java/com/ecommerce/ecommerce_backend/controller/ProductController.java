package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.Operation;

import java.io.IOException;
import java.math.BigDecimal;
import com.ecommerce.ecommerce_backend.model.PageResponse;
import org.springframework.web.bind.annotation.RequestParam;
import com.ecommerce.ecommerce_backend.model.ProductUploadRequest;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Product Management APIs")
public class ProductController {

    @Autowired
    private ProductService productService;

    // @PostMapping
    // public Product createProduct(@RequestBody Product product) {
    //     return productService.createProduct(product);
    // }

    @GetMapping
    public PageResponse getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean featured
    ) {
        return productService.getProducts(page, limit, search, category,featured);
    }

    @PostMapping("/create")
@Operation(summary = "Create product with images")
public Product createProductWithImages(
        @RequestPart("name") String name,
        @RequestPart("description") String description,
        @RequestPart("price") String price,  // ✅ as String → Fixes content-type issue
        @RequestPart("category") String category,
        @RequestPart("featured") String featured,
        @Parameter(description = "Product Images", content = @Content(mediaType = "multipart/form-data",
                schema = @Schema(type = "string", format = "binary")))
        @RequestPart("images") List<MultipartFile> images
) throws IOException {

    Product product = new Product();
    product.setName(name);
    product.setDescription(description);
    product.setCategory(category);
    
    // ✅ convert price to BigDecimal safely
    product.setPrice(new BigDecimal(price));
    product.setFeatured(Boolean.parseBoolean(featured));

    for (MultipartFile file : images) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String uploadDir = "uploaded_images/";
        java.nio.file.Path uploadPath = java.nio.file.Paths.get(uploadDir);

        if (!java.nio.file.Files.exists(uploadPath)) {
            java.nio.file.Files.createDirectories(uploadPath);
        }

        java.nio.file.Path filePath = uploadPath.resolve(fileName);
        java.nio.file.Files.copy(file.getInputStream(), filePath);

        product.getImages().add(filePath.toString());
    }

    return productService.createProduct(product);
}



    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
