package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;

@Document(collection = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffModel {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field (name = "dob")
    private Date dob;

    @Field (name = "phone_number")
    private String phoneNumber;
}
