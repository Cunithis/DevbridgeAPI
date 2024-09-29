package com.devbridge.booksfinal.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import com.devbridge.booksfinal.api.model.Book;
import com.devbridge.booksfinal.repository.BookRepository;

import jakarta.annotation.PostConstruct;

public class BooksService {
	
	private BookRepository bookRepository;

    @Autowired
    public BooksService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        // Clear existing data (optional)
        bookRepository.deleteAll();

        // Create mock books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, "Fiction");
        Book book2 = new Book("1984", "George Orwell", 1949, "Dystopian");
        Book book3 = new Book("Pride and Prejudice", "Jane Austen", 1813, "Romance");
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "Classic");
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951, "Fiction");
        Book book6 = new Book("Moby Dick", "Herman Melville", 1851, "Adventure");
        Book book7 = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "Fantasy");
        Book book8 = new Book("War and Peace", "Leo Tolstoy", 1869, "Historical");

        // Save mock books to the repository
        bookRepository.saveAll(Arrays.asList(book1,book2,book3,book4,book5,book6,book7,book8));
    }
	
	

}
