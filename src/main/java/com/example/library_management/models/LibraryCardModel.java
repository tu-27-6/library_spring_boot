package com.example.library_management.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Date;

@Document(collection = "libary_card")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCardModel {

    @Id
    private String id;

    @Field(name = "start_date")
    private Date startDate;

    @Field(name = "end_date")
    private Date endDate;

    @Field(name = "id_card")
    @Indexed(unique = true)
    private String idCard;
}
