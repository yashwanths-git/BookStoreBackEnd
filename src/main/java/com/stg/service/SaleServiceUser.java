package com.stg.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.stg.entity.BookSale;
import com.stg.entity.CustomerAddress;
import com.stg.entity.OrderDetails;
import com.stg.entity.Paid;
import com.stg.entity.RegisteredUser;
import com.stg.entity.UserBook;
import com.stg.exception.BookStoreException;

//@Service
public interface SaleServiceUser {
	public abstract OrderDetails createOrder( String customerName,long phoneNumber,CustomerAddress address,List<UserBook> books,String email,Paid paid) throws BookStoreException ;

	public abstract OrderDetails createOrderWithListOfBooks(OrderDetails ordDetails)throws BookStoreException ;
	//common
	
	public abstract RegisteredUser getUserDetailsWithUserId(int userId) throws BookStoreException;

	
}
