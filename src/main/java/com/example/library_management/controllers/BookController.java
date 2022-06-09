package com.example.library_management.controllers;

import com.example.library_management.models.BookModel;
import com.example.library_management.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/book")
public class BookController {

    @Autowired
    private BookService bookService;

    //create
    @PostMapping("/create_book")
    public ResponseEntity<?> createBook(@RequestBody BookModel book) {
        try {
            BookModel data = bookService.createBook(book);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_all_books")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<BookModel> data = bookService.getAllBook();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_book")
    public ResponseEntity<?> getBook() {
        try {
            List<BookModel> data = bookService.getAllBook();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_book")
    public ResponseEntity<?> deleteBook(@RequestParam String id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_book")
    public ResponseEntity<?> updateBook(@RequestBody BookModel book, @RequestParam String id) {
        try {
            BookModel data = bookService.updateBook(book ,id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

}
