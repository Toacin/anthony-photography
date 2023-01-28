package com.antphoto.controller;

import com.antphoto.model.Category;
import com.antphoto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository repository;

    @GetMapping("/api/categories")
    public List<Category> getAllCategories() {
        List<Category> categories = repository.findAll();
        return categories;
    }

    @GetMapping("/api/categories/{id}")
    public Category getSingleCategory(@PathVariable Integer id) {
        Category category = repository.getReferenceById(id);
        return category;
    }

    @PutMapping("/api/categories/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        Category tempCategory = repository.getReferenceById(id);
        category.setId(tempCategory.getId());
        repository.save(category);
        return category;
    }

    @PostMapping("/api/categories")
    public Category addCategory(@RequestBody Category category) {
        Category newCategory = repository.save(category);
        return newCategory;
    }

    @DeleteMapping("/api/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
