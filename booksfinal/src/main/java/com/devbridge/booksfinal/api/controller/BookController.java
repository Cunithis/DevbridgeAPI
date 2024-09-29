package com.devbridge.booksfinal.api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devbridge.booksfinal.api.model.Book;
import com.devbridge.booksfinal.repository.BookRepository;
import com.devbridge.booksfinal.services.BooksService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	Boolean isExecuted = false;
	public void mockData() {

		if(!isExecuted) // Ensures the books are saved 1 time
		{
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
	        isExecuted = true;
		}
    }
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Integer id)
	{
		mockData();
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
	}
	
	@GetMapping("/rating")
	public void setBookRating(@RequestParam Integer id,@RequestParam Integer rating)
	{
		mockData();
		if(rating >= 0 && rating <= 5)
		{
			Book book = bookRepository.getById(id);
			book.setRating(rating);
			bookRepository.save(book);
		}

	}
	
	@GetMapping()
	public List<Book> filterBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer publicationYear,
            @RequestParam(required = false) Integer rating) {
		mockData();

          if (title != null) {
            return bookRepository.findByTitleContaining(title);
        } else if (author != null) {
            return bookRepository.findByAuthorContaining(author);
        } else if (publicationYear != null) {
            return bookRepository.findByPublicationYear(publicationYear);
        } else if (rating != null) {
            return bookRepository.findByRating(rating);
        } else {
            return bookRepository.findAll(); // Return all books if no filters applied
        }
    }

	
	@PostMapping
	public Book createBook(@RequestBody Book book)
	{
		return bookRepository.save(book);
	}
	
}
