package com.ecommerce.ecommerce_backend.repository;

import com.ecommerce.ecommerce_backend.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
