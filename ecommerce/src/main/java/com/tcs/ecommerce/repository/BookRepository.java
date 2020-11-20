package com.tcs.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ecommerce.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	Optional<Book> findByIsbn(String isbn);
	
	
	
	
}
