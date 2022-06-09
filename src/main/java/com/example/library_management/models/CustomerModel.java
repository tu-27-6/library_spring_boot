package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field (name = "address")
    private String address;

    @Field (name = "library_card_id")
    private String libraryCardId;
}
