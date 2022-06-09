package com.example.library_management.services;

import com.example.library_management.models.AuthorModel;
import com.example.library_management.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorModel createAuthor(AuthorModel author) {
        Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(author.getId());
        if(optionalAuthorModel.isPresent()) {
            throw new EntityNotFoundException("Author already exist");
        }
        return authorRepository.save(author);
    }

    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(String id) {
        Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(id);
        if(optionalAuthorModel.isEmpty()) {
            throw new EntityNotFoundException("Author id is not found");
        }
        else {
            authorRepository.deleteById(id);
        }
    }

    public AuthorModel updateAuthor(AuthorModel author, String id) {
        Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(id);
        if(optionalAuthorModel.isEmpty()) {
            throw new EntityNotFoundException("Author id is not found");
        }
        else {
            author.setId(id);
            if(author.getAuthorName() == null || author.getAuthorName().isEmpty()) {
                author.setAuthorName(optionalAuthorModel.get().getAuthorName());
            }
            if(author.getNote() == null || author.getNote().isEmpty()) {
                author.setNote(optionalAuthorModel.get().getNote());
            }

            return authorRepository.save(author);
        }
    }


}
