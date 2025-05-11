package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Feature;
import com.ecommerce.ecommerce_backend.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import com.ecommerce.ecommerce_backend.model.Product;


import java.util.List;

@Service
public class FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private ProductRepository productRepository;

    public Feature createFeature(String content, Long productId, String name) {

        // ✅ Fetch product → throw error if not found
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        // ✅ Create review
        Feature feature = new Feature();
        feature.setContent(content);
        feature.setProduct(product);
        feature.setName(name);

        return featureRepository.save(feature);
    }

    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id).orElseThrow();
    }

    public void deleteFeature(Long id) {
        featureRepository.deleteById(id);
    }
}
