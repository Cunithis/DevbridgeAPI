package com.devbridge.booksfinal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devbridge.booksfinal.api.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByPublicationYear(Integer publicationYear);
    List<Book> findByRating(Integer rating);
    
    
		
}