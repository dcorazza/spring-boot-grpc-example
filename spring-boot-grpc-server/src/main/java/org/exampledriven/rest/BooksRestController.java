package org.exampledriven.rest;

import java.util.List;

import org.exampledriven.BookUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksRestController {
	@Autowired
	HttpMessageConverters httpMessageConverters;

	@PostMapping("book")
	public List<Book> createBooks(@RequestBody List<Book> books) {

		books.forEach(book -> {
			book.setISBN(BookUtil.generateISBN());
		});

		return books;
	}

	@GetMapping("/teste")
	public ResponseEntity<String> test() {
		System.out.println("aqui");
		return ResponseEntity.ok("OK");
	}

}
