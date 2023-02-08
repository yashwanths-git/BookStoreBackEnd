package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.BookSale;
import com.stg.exception.BookStoreException;
import com.stg.service.SaleService;


@RestController
@RequestMapping("nonRegisteredUser")
@CrossOrigin(origins = "*")
public class CommonController {
	
	@Autowired
	private SaleService saleService;
	

	
	
	@GetMapping(value="readAllBooks")
	public List<BookSale> readAllBooks() throws BookStoreException {
		return saleService.readAllBooks();
	}
	@GetMapping(value = "readByBookId/{id}")
	public List<BookSale> fetchByBookId(@PathVariable int id) throws BookStoreException {
		

		return saleService.fetchByBookId(id);
	}
	@GetMapping(value="readByBookName/{bookName}")
	public List<BookSale> fetchByBookName(@PathVariable  String bookName) throws BookStoreException {
		return saleService.fetchByBookName(bookName);
	}
	@GetMapping(value ="readBookByAuthorName/{authorName}")
	public List< BookSale>fetchByAuthorName(@PathVariable String authorName) throws BookStoreException
	{
	return saleService.fetchByAuthorName(authorName);
	}

}
