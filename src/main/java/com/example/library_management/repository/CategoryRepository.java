package com.example.library_management.repository;

import com.example.library_management.models.CategoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<CategoryModel, String> {
    Optional<CategoryModel> findByTitle(String title);

    void deleteByTitle(String title);
}
