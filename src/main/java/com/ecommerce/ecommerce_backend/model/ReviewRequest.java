package com.ecommerce.ecommerce_backend.model;

public class ReviewRequest {
    private String content;
    private int rating;
    private Long productId;

    // ✅ Add getters and setters (or use Lombok)
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
}
