package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Product;
import com.ecommerce.ecommerce_backend.model.PageResponse;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public PageResponse<Product> getProducts(int page, int limit, String search, String category, Boolean featured) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());

        // Simple search logic → you can make advanced later
        Page<Product> productPage;

        if(featured != null){
            productPage = productRepository.findByFeatured(featured, pageable);
        }
        else if (search != null && category != null) {
            productPage = productRepository.findByNameContainingAndDescriptionContainingAndCategory(search, search, category, pageable);
        } else if (search != null) {
            productPage = productRepository.findByNameContainingOrDescriptionContaining(search, search, pageable);
        } else if (category != null) {
            productPage = productRepository.findByCategory(category, pageable);
        } else {
            productPage = productRepository.findAll(pageable);
        }

        return new PageResponse<>(
                productPage.getContent(),
                productPage.getTotalElements(),
                productPage.getNumber(),
                productPage.getTotalPages()
        );
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setImages(productDetails.getImages());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
