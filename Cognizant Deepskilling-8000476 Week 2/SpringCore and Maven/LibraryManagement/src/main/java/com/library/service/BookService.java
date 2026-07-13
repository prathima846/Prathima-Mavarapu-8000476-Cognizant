package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;
    private BookRepository setterBookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.setterBookRepository = bookRepository;
    }

    public String getBookInfo() {
        return bookRepository.findBook() + " | Setter injection: " + setterBookRepository.findBook();
    }
}
