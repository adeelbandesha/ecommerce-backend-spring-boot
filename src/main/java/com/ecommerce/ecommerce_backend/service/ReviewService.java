package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Review;
import com.ecommerce.ecommerce_backend.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerce_backend.repository.ProductRepository;
import com.ecommerce.ecommerce_backend.model.Product;


import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    public Review createReview(String content, int rating, Long productId, String name) {

        // ✅ Fetch product → throw error if not found
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        // ✅ Create review
        Review review = new Review();
        review.setContent(content);
        review.setRating(rating);
        review.setProduct(product);
        review.setName(name);

        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
