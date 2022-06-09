package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorModel {

    @Id
    private String id;

    @Field(name = "author_name")
    private String authorName;

    @Field(name = "note")
    private String note;
}
