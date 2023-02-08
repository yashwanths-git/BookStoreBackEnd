package com.stg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stg.entity.BookSale;
import com.stg.entity.OrderDetails;
import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;
//@Service
public interface SaleServiceAdmin {
	//a
		public abstract BookSale createBook(int bookId, String bookName, String authorName, int availableQuantity, float price, long contactNumber)  throws BookStoreException ;
		//a
//		public abstract List<OrderDetails> readAllOrders(long phoneNumber) throws BookStoreException;
		public abstract BookSale fetchByBookIdAndContactNumber(int id,long contactNumber) throws BookStoreException;

		//a
		public abstract String deleteByBookId(int id,long phoneNumber)throws BookStoreException;
		//a
		public abstract String deleteByBookName(long phoneNumber,String bookName)throws BookStoreException;
		//a
		public abstract String updateByBookId(long phoneNumber,int bookId,int updateAvailability )throws BookStoreException;
		//a
		public abstract String updateByBookName(long phoneNumber ,String bookName,int updateAvailability )throws BookStoreException;
		public abstract List<BookSale> fetchBooksByShopId(int shopId) throws BookStoreException;
		public abstract ShopRegistry fetchShopByShopId(int shopId) throws BookStoreException;
		//common
		 public abstract String updatePriceByBookId(long phoneNumber, int bookId, float updatedPrice) throws BookStoreException;
		

}
