package com.example.library_management.services;

import com.example.library_management.models.LibraryCardModel;
import com.example.library_management.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryCardService {

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public LibraryCardModel createLibraryCard(LibraryCardModel card) {
        Optional<LibraryCardModel> opCard = libraryCardRepository.findByIdCard(card.getIdCard());
        if (opCard.isPresent()) {
            throw new EntityNotFoundException("Id card already exist!");
        }

        return libraryCardRepository.save(card);
    }

    public List<LibraryCardModel> getAllLibraryCards() {
        return libraryCardRepository.findAll();
    }

    public void deleteLibraryCard(String id) {
        Optional<LibraryCardModel> optional = libraryCardRepository.findById(id);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("Id not found!");
        } else {
            libraryCardRepository.deleteById(id);
        }
    }

    public LibraryCardModel updateLibraryCard(LibraryCardModel card, String id) {
        Optional<LibraryCardModel> optional = libraryCardRepository.findById(id);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("Id not found!");
        } else {
            card.setId(id);
            if (card.getStartDate() == null) {
                card.setStartDate(optional.get().getStartDate());
            }
            if (card.getEndDate() == null) {
                card.setEndDate(optional.get().getEndDate());
            }
            if (card.getIdCard() == null || card.getIdCard().isEmpty()) {
                card.setIdCard(optional.get().getIdCard());
            }
            return libraryCardRepository.save(card);
        }
    }

}
