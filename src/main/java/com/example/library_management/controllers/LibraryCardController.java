package com.example.library_management.controllers;

import com.example.library_management.models.LibraryCardModel;
import com.example.library_management.repository.LibraryCardRepository;
import com.example.library_management.services.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library/library_card")
public class LibraryCardController {

    @Autowired
    private LibraryCardService libraryCardService;

    @GetMapping("/get_all_library_cards")
    public ResponseEntity<?> getAllLibraryCard() {
        try {
            List<LibraryCardModel> data = libraryCardService.getAllLibraryCards();
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create_library_cards")
    public ResponseEntity<?> createLibraryCard(@RequestBody LibraryCardModel libraryCard) {
        try {
            LibraryCardModel data = libraryCardService.createLibraryCard(libraryCard);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete_library_cards")
    public ResponseEntity<?> deleteLibraryCard(@RequestParam String id) {
        try {
            libraryCardService.deleteLibraryCard(id);
            return new ResponseEntity<>("Delete success", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update_library_cards")
    public ResponseEntity<?> updateLibraryCard(@RequestBody LibraryCardModel libraryCard, @RequestParam String id) {
        try {
            LibraryCardModel data = libraryCardService.updateLibraryCard(libraryCard, id);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }


}
