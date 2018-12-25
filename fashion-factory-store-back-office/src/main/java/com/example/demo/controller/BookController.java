package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

	@GetMapping("/books-from-bo")
	public String findAll() {
		StringBuilder builder = new StringBuilder("initial\n");
		builder.append("second\n");
		builder.append("third\n");
		log.info("web works fine from root");
		return builder.toString();
	}

}
