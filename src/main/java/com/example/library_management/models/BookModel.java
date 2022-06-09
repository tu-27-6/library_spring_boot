package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    @Id
    private String id;

    @Field(name = "book_name")
    private String bookName;

    @Field(name = "author_id")
    private String authorId;

    @Field(name = "category_id")
    private String categoryId;

    @Field(name = "publish_year")
    private Integer publishYear;
}
