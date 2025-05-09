package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
