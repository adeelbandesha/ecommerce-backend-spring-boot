package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Review;
import com.ecommerce.ecommerce_backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ecommerce.ecommerce_backend.model.ReviewRequest;
import com.ecommerce.ecommerce_backend.model.Review;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(request.getContent(), request.getRating(), request.getProductId(), request.getName());
    }


    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
