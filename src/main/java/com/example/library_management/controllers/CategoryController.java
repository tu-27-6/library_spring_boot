package com.example.library_management.controllers;

import com.example.library_management.models.AuthorModel;
import com.example.library_management.models.CategoryModel;
import com.example.library_management.repository.CategoryRepository;
import com.example.library_management.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get_all_categories")
    public ResponseEntity<?> getAllCategories() {
        try {
            List<CategoryModel> data = categoryService.getAllCategory();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_category")
    public ResponseEntity<?> createCategory(@RequestBody CategoryModel category) {
        try {
            CategoryModel data = categoryService.createCategory(category);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete_category")
    public ResponseEntity<?> deleteCategory(@RequestParam String title) {
        try {
            categoryService.deleteCategory(title);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_category")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryModel category, @RequestParam String id) {
        try {
            CategoryModel data = categoryService.updateCategory(category, id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
