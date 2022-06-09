package com.example.library_management.controllers;

import com.example.library_management.models.AuthorModel;
import com.example.library_management.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/get_all_authors")
    public ResponseEntity<?> getAllAuthors() {
        try {
            List<AuthorModel> data = authorService.getAllAuthors();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_author")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorModel author) {
        try {
            AuthorModel data = authorService.createAuthor(author);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_author")
    public ResponseEntity<?> deleteAuthor(@RequestParam String id) {
        try {
            authorService.deleteAuthor(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_author")
    public ResponseEntity<?> updateAuthor(@RequestBody AuthorModel author, @RequestParam String id) {
        try {
            AuthorModel data = authorService.updateAuthor(author, id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
