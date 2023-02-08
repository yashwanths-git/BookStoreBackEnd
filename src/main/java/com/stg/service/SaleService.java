package com.stg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.stg.entity.BookSale;
import com.stg.entity.CustomerAddress;
import com.stg.entity.OrderDetails;
import com.stg.entity.RegisteredUser;
import com.stg.exception.BookStoreException;
//@Service
public interface SaleService {
	
	public abstract OrderDetails fetchByOrderId(int id) throws BookStoreException;
	public  abstract List<OrderDetails> fetchByOrderPhoneNumber( long phoneNumber)throws BookStoreException;
	public abstract List<BookSale> fetchByBookId(int bookId)throws BookStoreException;
	public abstract List<BookSale> fetchByBookName(String bookName)throws BookStoreException;
	public abstract List< BookSale>fetchByAuthorName(String authorName)throws BookStoreException;
	public abstract List<BookSale>readAllBooks()throws BookStoreException;



}
