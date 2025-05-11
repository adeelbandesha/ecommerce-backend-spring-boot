package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Feature;
import com.ecommerce.ecommerce_backend.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ecommerce.ecommerce_backend.model.FeatureRequest;
import com.ecommerce.ecommerce_backend.model.Feature;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public Feature createFeature(@RequestBody FeatureRequest request) {
        return featureService.createFeature(request.getContent(), request.getProductId(), request.getName());
    }


    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
    }
}
