package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.model.Blog;
import com.ecommerce.ecommerce_backend.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    @GetMapping
    public Map<String, Object> getFilteredBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category) {
        return blogService.getFilteredBlogs(keyword, category, page, limit);
    }



    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }

    @GetMapping("/search")
    public List<Blog> searchByTitle(@RequestParam String keyword) {
        return blogService.searchBlogs(keyword);
    }

    @GetMapping("/category")
    public List<Blog> filterByCategory(@RequestParam String category) {
        return blogService.filterByCategory(category);
    }
}
