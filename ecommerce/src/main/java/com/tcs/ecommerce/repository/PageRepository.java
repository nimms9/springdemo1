package com.tcs.ecommerce.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ecommerce.model.Book;
import com.tcs.ecommerce.model.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
	
	List<Page> findByBook(Book book, Sort sort);
	
}
