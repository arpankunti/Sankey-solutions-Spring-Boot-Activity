package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customException.ResourceNotFoundExceptio;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public Book saveBook(Book book) {
		if (repository.findByName(book.getName()) == null) {
			return repository.save(book);

		} else
			throw new ResourceNotFoundExceptio("book already exists");

	}

	public List<Book> getBooks() {
		return repository.findAll();
	}

	public Book getBookById(int id) {
		if (repository.findById(id).orElse(null)==null) { throw new ResourceNotFoundExceptio("book is not there");}
		else {
		return repository.findById(id).orElse(null);}
	}

	public String deleteBook(int id) {
		if (repository.findById(id).orElse(null)==null) { throw new ResourceNotFoundExceptio("book is not there");}
		else {
		repository.deleteById(id);
		return " Book deleted with id no : " + id;}
	}

	public Book updateBook(Book book) {
		
		System.out.println("inside method::::::::");
		if (getBookById(book.getId())==null) {
			//System.out.println(repository.findByName(book.getName())+ "::::::::");
			throw new ResourceNotFoundExceptio("book is not there");
		} else {

			Book existingBook = repository.findById(book.getId()).orElse(null);
			existingBook.setName(book.getName());
			existingBook.setId(book.getId());
			existingBook.setGenre(book.getGenre());
			existingBook.setBestSeller(book.isBestSeller());
			existingBook.setCreatedAt(book.getCreatedAt());
			existingBook.setUpdatedAt(book.getUpdatedAt());
			return repository.save(existingBook);
			
		}

	}

	public Book getBookByName(String name) {
		return repository.findByName(name);
	}

}
