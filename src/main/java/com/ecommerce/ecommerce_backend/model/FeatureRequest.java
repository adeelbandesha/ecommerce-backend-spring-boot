package com.ecommerce.ecommerce_backend.model;

public class FeatureRequest {
    private String content;
    private Long productId;
    private String name;

    // ✅ Add getters and setters (or use Lombok)
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
