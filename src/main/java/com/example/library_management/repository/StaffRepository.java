package com.example.library_management.repository;

import com.example.library_management.models.StaffModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends MongoRepository<StaffModel, String> {
}
