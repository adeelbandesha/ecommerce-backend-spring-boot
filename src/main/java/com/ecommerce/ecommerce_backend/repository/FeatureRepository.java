package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
