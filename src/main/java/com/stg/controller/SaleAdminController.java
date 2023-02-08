package com.stg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.BookSale;
import com.stg.entity.OrderDetails;
import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;
import com.stg.repository.SaleRepository;
import com.stg.service.SaleService;
import com.stg.service.SaleServiceAdmin;
import com.stg.service.SaleServiceAdminImpl;
import com.stg.service.SaleServiceImpl;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//TODO global exception handling

//import io.swagger.annotations.SwaggerDefinition;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author yashwanths
 *
 */


@RestController
@RequestMapping(value = "admin")
@CrossOrigin(origins = "*")
public class SaleAdminController {
	
	
	@Autowired
	private SaleServiceAdmin saleServiceAdmin;
	@Autowired
    private SaleService saleService;
	// Read Operation

//	@GetMapping(value = "readAll")
//	public List<OrderDetails> readAllOrders(@RequestParam long phoneNumber) throws BookStoreException {
//		return saleServiceAdmin.readAllOrders(phoneNumber);
//	}
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
	
	@GetMapping(value = "readByBookId/{id}")
	public List<BookSale> fetchByBookId(@PathVariable int id) throws BookStoreException {
		
		System.err.println(saleService.fetchByBookId(id));

		return saleService.fetchByBookId(id);
	}
	@GetMapping(value = "readByBookIdAndContactNumber/{id}/{contactNumber}")
	public BookSale fetchByBookIdAndContactNumber(@PathVariable int id,@PathVariable long contactNumber) throws BookStoreException {
		

		return saleServiceAdmin.fetchByBookIdAndContactNumber(id,contactNumber);
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
	
	@GetMapping(value = "readBooksByShopId/{shopId}")
	public List<BookSale> fetchByShopId(@PathVariable int shopId) throws BookStoreException {
		
		
		return saleServiceAdmin.fetchBooksByShopId(shopId);
	}
	@GetMapping(value = "readShopByShopId/{shopId}")
	public ShopRegistry fetchShopByShopId(@PathVariable int shopId) throws BookStoreException {
		
		
		return saleServiceAdmin.fetchShopByShopId(shopId);
	}
	// End of read operation

	//Delete operation
	
	@DeleteMapping(value = "deleteByBookId/{id}/{phoneNumber}")
	public String deleteByBookId(@PathVariable int id,@PathVariable long phoneNumber) throws BookStoreException {
	return saleServiceAdmin.deleteByBookId(id,phoneNumber);
	}

	@DeleteMapping(value = "deleteByBookName")
	public String deleteByBookName(@RequestParam String bookName,@RequestParam long phoneNumber) throws BookStoreException {
	return saleServiceAdmin.deleteByBookName(phoneNumber,bookName);
	}
	//End of delete operation
	
	
	//Create Operation
	
	@PostMapping(value="createBook/{bookId}/{bookName}/{authorName}/{availableQuantity}/{price}/{contactNumber}")
	public BookSale createBook(@PathVariable int bookId,@PathVariable String bookName,@PathVariable String authorName,@PathVariable int availableQuantity,@PathVariable float price,@PathVariable long contactNumber) throws BookStoreException {
	return 	saleServiceAdmin.createBook(bookId, bookName,authorName,availableQuantity,price,contactNumber);
	}
	
	@PutMapping(value="updateAvailabilityByBookId/{phoneNumber}/{bookId}/{newBookCount}")
	public ResponseEntity< String> updateBookCountById(@PathVariable long phoneNumber,@PathVariable int bookId,@PathVariable int newBookCount ) throws BookStoreException  {
		return new ResponseEntity<String>( saleServiceAdmin.updateByBookId(phoneNumber,bookId, newBookCount),HttpStatus.OK);
	}
	@PutMapping(value="updateAvailabilityByBookName/{phoneNumber}/{bookName}/{newBookCount}")
	public String updateBookCountByName(@PathVariable long phoneNumber,@PathVariable String bookName,@PathVariable int newBookCount ) throws BookStoreException  {
		return saleServiceAdmin.updateByBookName(phoneNumber,bookName, newBookCount);
	}
	
	@PutMapping(value="updatePriceByBookId/{phoneNumber}/{bookId}/{newPrice}")
	public ResponseEntity< String> updateBookPriceById(@PathVariable long phoneNumber,@PathVariable int bookId,@PathVariable float newPrice ) throws BookStoreException  {
		return new ResponseEntity<String>( saleServiceAdmin.updatePriceByBookId(phoneNumber,bookId, newPrice),HttpStatus.OK);
	}

}


