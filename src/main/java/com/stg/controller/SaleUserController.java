	package com.stg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.BookSale;
import com.stg.entity.CustomerAddress;
import com.stg.entity.OrderDetails;
import com.stg.entity.Paid;
import com.stg.entity.RegisteredUser;
import com.stg.entity.UserBook;
import com.stg.exception.BookStoreException;
import com.stg.service.SaleService;
import com.stg.service.SaleServiceImpl;
import com.stg.service.SaleServiceUser;
import com.stg.service.SaleServiceUserImpl;

@RestController
@RequestMapping(value="user")
@CrossOrigin(origins = "*")
public class SaleUserController {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
private	SaleServiceUser saleServiceUser;
	
		// Read Operation-order details
	
	@GetMapping(value="readAllBooks")
	public List<BookSale> readAllBooks() throws BookStoreException {
		return saleService.readAllBooks();
	}
	
	@GetMapping(value = "readByOrderId/{id}")
	public OrderDetails fetchByOrderId(@PathVariable int id) throws BookStoreException {
		return saleService.fetchByOrderId(id);
		
	}

	@GetMapping(value = "readByPhoneNumber/{phoneNumber}")
	public List<OrderDetails> fetchByOrderPhoneNumber(@PathVariable long phoneNumber) throws BookStoreException {
		

		return saleService.fetchByOrderPhoneNumber(phoneNumber);
	}
	//read operation-book details
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
//@PostMapping(value="createOrder")
//public OrderDetails createOrderDetails(
//		@RequestParam("customerName") String customerName,@RequestParam("phoneNumber") long phoneNumber,@RequestBody List<UserBook>books,@RequestParam("email") String email,@RequestParam("paid") Paid paid, @RequestParam String city,@RequestParam int doorNo,@RequestParam String streetName,@RequestParam String state)  throws BookStoreException {
//
//	CustomerAddress address=new CustomerAddress(doorNo, streetName, city, state);
////			UserBook book=new UserBook(bookId, numberOfBooksNeeded);
////			UserBook book1=new UserBook(103, 15);
////			UserBook book2=new UserBook(104, 2);
//			
////			List<UserBook>books=new ArrayList<UserBook>();
////			books.add(book);
////			books.add(book1);
////			books.add(book2);
//	
//	
//	return saleServiceUser.createOrder(shopName,customerName, phoneNumber, address, books, email, paid);
//}
	@PostMapping(value="createOrder/{customerName}/{phoneNumber}/{email}/{paid}/{city}/{doorNo}/{streetName}/{state}")
	public OrderDetails createOrderDetails(
			@PathVariable("customerName") String customerName,@PathVariable("phoneNumber") long phoneNumber,@PathVariable("email") String email,@PathVariable("paid") Paid paid, @PathVariable String city,@PathVariable int doorNo,@PathVariable String streetName,@PathVariable String state,@RequestBody List<UserBook>books)  throws BookStoreException {

		CustomerAddress address=new CustomerAddress(doorNo, streetName, city, state);
//				UserBook book=new UserBook(bookId, numberOfBooksNeeded);
//				UserBook book1=new UserBook(103, 15);
//				UserBook book2=new UserBook(104, 2);
				
//				List<UserBook>books=new ArrayList<UserBook>();
//				books.add(book);
//				books.add(book1);
//				books.add(book2);
		
		
		return saleServiceUser.createOrder(customerName, phoneNumber, address, books, email, paid);
	}
	
	@GetMapping(value="getUserDetailsWithUserId/{userId}")
	public ResponseEntity <RegisteredUser> getUserDetailsWithUserId(@PathVariable int userId) throws BookStoreException {
		return new ResponseEntity<RegisteredUser>(  saleServiceUser.getUserDetailsWithUserId(userId),HttpStatus.OK);
	}
}
