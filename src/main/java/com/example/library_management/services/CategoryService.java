package com.example.library_management.services;

import com.example.library_management.models.CategoryModel;
import com.example.library_management.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryModel createCategory(CategoryModel category) {
        Optional<CategoryModel> optionalCategoryModel = categoryRepository.findByTitle(category.getTitle());
        if(optionalCategoryModel.isPresent()) {
            throw new EntityNotFoundException("Category already exist");
        }
        else {
            return categoryRepository.save(category);
        }
    }

    public void deleteCategory(String title) {
        Optional<CategoryModel> optionalCategoryModel = categoryRepository.findByTitle(title);
        if(optionalCategoryModel.isEmpty()) {
            throw new EntityNotFoundException("Category doesn't exist");
        }
        else {
            categoryRepository.deleteByTitle(title);
        }
    }

    public List<CategoryModel> getAllCategory() {
        return categoryRepository.findAll();
    }

    public CategoryModel updateCategory(CategoryModel category, String id) {
        Optional<CategoryModel> optionalCategoryModel = categoryRepository.findById(id);
        if(optionalCategoryModel.isEmpty()) {
            throw new EntityNotFoundException("Category is not found");
        }
        else {
            category.setId(id);
            if(category.getTitle() == null || category.getTitle().isEmpty()) {
                category.setTitle(optionalCategoryModel.get().getTitle());
            }

            return categoryRepository.save(category);
        }
    }
}
