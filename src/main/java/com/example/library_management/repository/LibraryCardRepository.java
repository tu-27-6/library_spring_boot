package com.example.library_management.repository;

import com.example.library_management.models.LibraryCardModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryCardRepository extends MongoRepository<LibraryCardModel, String> {
    Optional<LibraryCardModel> findByIdCard(String idCard);
}
