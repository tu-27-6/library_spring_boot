package com.example.library_management.services;

import com.example.library_management.models.AuthorModel;
import com.example.library_management.models.BookModel;
import com.example.library_management.models.CategoryModel;
import com.example.library_management.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;


import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //create
    public BookModel createBook(BookModel book) {
        Optional<AuthorModel> optionalAuthorModel = authorRepository.findById(book.getAuthorId());

        if(optionalAuthorModel.isEmpty()) {
            throw new EntityNotFoundException("Author id is not found");
        }

        Optional<CategoryModel> optionalCategoryModel = categoryRepository.findById(book.getCategoryId());

        if(optionalCategoryModel.isEmpty()) {
            throw new EntityNotFoundException("Category id is not found");
        }

        return bookRepository.save(book);
    }

    //get
    public List<BookModel> getAllBook() {

        return bookRepository.findAll();
    }

    //delete
    public void deleteBook(String id) {
        Optional<BookModel> optionalBookModel = bookRepository.findById(id);

        if(optionalBookModel.isEmpty()) {
            throw new EntityNotFoundException("Book id is not found");
        }
        else {
            bookRepository.deleteById(id);
        }
    }

    //update
    public BookModel updateBook(BookModel book, String id) {
        Optional<BookModel> optionalBookModel = bookRepository.findById(id);
        if(optionalBookModel.isEmpty()) {
            throw new EntityNotFoundException("Book id is not found");
        }
        else {
            book.setId(id);
            if (book.getBookName() == null || book.getBookName().isEmpty()) {
                book.setBookName(optionalBookModel.get().getBookName());
            }
            if (book.getAuthorId() == null || book.getAuthorId().isEmpty()) {
                book.setAuthorId(optionalBookModel.get().getAuthorId());
            }
            if (book.getCategoryId() == null || book.getCategoryId().isEmpty()) {
                book.setCategoryId(optionalBookModel.get().getCategoryId());
            }
            if (book.getPublishYear() == null) {
                book.setPublishYear(optionalBookModel.get().getPublishYear());
            }

            return bookRepository.save(book);
        }
    }


}
