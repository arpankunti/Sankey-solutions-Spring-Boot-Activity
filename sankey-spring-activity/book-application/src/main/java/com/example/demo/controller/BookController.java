package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customException.ResourceNotFoundExceptio;
import com.example.demo.entity.Book;
import com.example.demo.response.ResponseHandler;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService service;

	@PostMapping
	public ResponseEntity<Object> addBook(@RequestBody Book book) {
		try {
			Book result = service.saveBook(book);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
	}

	@GetMapping
	public ResponseEntity<Object>  findAllBooks() {
		try {
		List<Book> result = service.getBooks();
		return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		}
		catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> findBookById(@PathVariable int id) {
		try {
			Book result = service.getBookById(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
	}
	@GetMapping("/bookname/{name}")
	public ResponseEntity<Object> findBookByName(@PathVariable String name){
		try {
			Book result = service.getBookByName(name);
			return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
		}
		catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
	}

	@PutMapping
	public ResponseEntity<Object> updateBook(@RequestBody Book book) {
		try {
			Book result = service.updateBook(book);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable int id) {
		try {
            String result = service.deleteBook(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
		
		
	}

}
