package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.Blog;
import com.ecommerce.ecommerce_backend.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import com.ecommerce.ecommerce_backend.specification.BlogSpecification;
import org.springframework.data.jpa.domain.Specification;
import java.util.Map;
import java.util.HashMap;


@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Map<String, Object> getPaginatedBlogs(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Blog> blogPage = blogRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("data", blogPage.getContent());
        response.put("page", blogPage.getNumber());
        response.put("limit", blogPage.getSize());
        response.put("totalResults", blogPage.getTotalElements());
        response.put("totalPages", blogPage.getTotalPages());

        return response;
    }

    public Map<String, Object> getFilteredBlogs(String keyword, String category, int page, int limit) {
        Specification<Blog> spec = Specification.where(null);

        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and(BlogSpecification.titleContains(keyword));
        }

        if (category != null && !category.isEmpty()) {
            spec = spec.and(BlogSpecification.categoryEquals(category));
        }

        PageRequest pageable = PageRequest.of(page, limit);
        Page<Blog> blogPage = blogRepository.findAll(spec, pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("data", blogPage.getContent());
        response.put("page", blogPage.getNumber());
        response.put("limit", blogPage.getSize());
        response.put("totalResults", blogPage.getTotalElements());
        response.put("totalPages", blogPage.getTotalPages());

        return response;
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        Blog existing = getBlogById(id);
        existing.setTitle(updatedBlog.getTitle());
        existing.setCover(updatedBlog.getCover());
        existing.setCategory(updatedBlog.getCategory());
        existing.setContent(updatedBlog.getContent());
        return blogRepository.save(existing);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    public List<Blog> searchBlogs(String keyword) {
        return blogRepository.searchByTitle(keyword);
    }

    public List<Blog> filterByCategory(String category) {
        return blogRepository.findByCategoryIgnoreCase(category);
    }
}
