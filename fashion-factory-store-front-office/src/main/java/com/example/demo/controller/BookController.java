package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@Autowired
	BookService bookService;
	Long id = (long) 1003;

	@GetMapping("/books")
	public Iterable<Book> findAll() {

		return bookService.findAll();
	}

	@PostMapping(value="/book")
	public Book addBook() {
		
		Book book = new Book(id.toString(), "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017");
		id++;
		log.info(id+ " ");
		return bookService.save(book);
	}
	


}
