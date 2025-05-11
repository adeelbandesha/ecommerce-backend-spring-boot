package com.ecommerce.ecommerce_backend.specification;

import com.ecommerce.ecommerce_backend.model.Blog;
import org.springframework.data.jpa.domain.Specification;

public class BlogSpecification {

    public static Specification<Blog> titleContains(String keyword) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<Blog> categoryEquals(String category) {
        return (root, query, builder) -> builder.equal(builder.lower(root.get("category")), category.toLowerCase());
    }
}
