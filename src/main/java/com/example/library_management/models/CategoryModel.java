package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    @Id
    private String id;

    @Field(name = "title")
    private String title;
}
