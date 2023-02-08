package com.stg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.dto.BookSales;
import com.stg.entity.BookSale;
import com.stg.entity.CustomerAddress;
import com.stg.entity.OrderDetails;
import com.stg.entity.UserBook;
import com.stg.exception.BookStoreException;
import com.stg.repository.BookSaleRepository;
import com.stg.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private BookSaleRepository bookSaleRepository;
	
//	@Autowired
//	private BookSale bookSale;
//	
//	ModelMapper mapper = new ModelMapper();
//	BookSales bookSaleCopy = mapper.map(bookSale, BookSales.class);
	


	//admin&user
	@Override
	public List<BookSale> fetchByBookId(int bookId) throws BookStoreException {
		List<BookSale> result = bookSaleRepository.findAllByBookId(bookId);
		List<BookSale>result1=new ArrayList<BookSale>();
		for (BookSale bookSale : result) {
			if(bookSale.getAvailableQuantity()>0) {
				result1.add(bookSale);
			}
			
		}
	
			if(result1.size()>0) {
			
			
			return result1;
		}
			
		

		else {
			throw new BookStoreException("Book ID " + bookId + "  Not Found");
		}

	}
	//admin&user

	@Override
	public List<BookSale> fetchByBookName(String bookName) throws BookStoreException {
		List<BookSale> result = bookSaleRepository.findByBookName(bookName);
		List<BookSale>result1=new ArrayList<BookSale>();
		for (BookSale bookSale : result) {
			if(bookSale.getAvailableQuantity()>0) {
				result1.add(bookSale);
			}
			
		}
	
			if(result1.size()>0) {
			return result1;
		} else {
			throw new BookStoreException("Book Name Not Found");
		}
	}
	
	//admin&user

	@Override
	public List<BookSale> fetchByAuthorName(String authorName) throws BookStoreException {
		List<BookSale> result = bookSaleRepository.findAllByAuthorName(authorName);
		List<BookSale>result1=new ArrayList<BookSale>();
		for (BookSale bookSale : result) {
			if(bookSale.getAvailableQuantity()>0) {
				result1.add(bookSale);
			}
			
		}
	
			if(result1.size()>0) {
			return result1;
		} else {
			throw new BookStoreException("Books Not Found for the author : " + authorName);
		}
	}

	
	//End of book side
	
	
	
	//order side started
	
	

	
	
//admin & user
	@Override
	public OrderDetails fetchByOrderId(int id) throws BookStoreException {
		// TODO : check whether findById works!!! given findByBookId
		Optional<OrderDetails> optional = saleRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}

		else {
			throw new BookStoreException("ID Not Found");
		}
	}
	
	
	//admin & user


	@Override
	public List<OrderDetails> fetchByOrderPhoneNumber(long phoneNumber) throws BookStoreException {

		List<OrderDetails> result = saleRepository.findByPhoneNumber(phoneNumber);
		if (result.size() > 0) {
			return result;
		} else {
			throw new BookStoreException("Phone Number Not Found");
		}

	}

	@Override
	public List<BookSale> readAllBooks() throws BookStoreException {
		List<BookSale>books=bookSaleRepository.findAll();
		List<BookSale>result1=new ArrayList<BookSale>();
		for (BookSale bookSale : books) {
			if(bookSale.getAvailableQuantity()>0) {
				result1.add(bookSale);
			}
			
		}
	
			if(result1.size()>0) {
			return result1;
		}
		else {
			throw new BookStoreException("Currently No Books Available");
		}
	}
	
	

	


	
	
	//create order -only user side

	


	

}
