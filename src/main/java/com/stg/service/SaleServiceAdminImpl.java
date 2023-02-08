package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.stg.entity.BookSale;
import com.stg.entity.OrderDetails;
import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;
import com.stg.repository.BookSaleRepository;
import com.stg.repository.SaleRepository;
import com.stg.repository.ShopRepository;

@Service
public class SaleServiceAdminImpl implements SaleServiceAdmin {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private BookSaleRepository bookSaleRepository;
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public BookSale createBook(int bookId, String bookName, String authorName, int availableQuantity, float price, long contactNumber) throws BookStoreException {
ShopRegistry validate=shopRepository.findByPhoneNumber(contactNumber);
if(validate!=null) {
	BookSale bookSale= bookSaleRepository.findByBookIdAndContactNumber(bookId, contactNumber);
	if(!(bookSale!=null)) {
	BookSale bookTemp=new BookSale();
	bookTemp.setBookId(bookId);
	bookTemp.setBookName(bookName);
	bookTemp.setAuthorName(authorName);
	bookTemp.setAvailableQuantity(availableQuantity);
	bookTemp.setPrice(price);
	bookTemp.setContactNumber(contactNumber);
	bookTemp.setShopName(validate.getShopName());
	bookTemp.setShopRegisterRef(validate);
		
			bookSaleRepository.save(bookTemp);
			return bookTemp;
		
}
	else {
		throw new BookStoreException("Book already exist please update the stock");

	}
}
else {
	throw new BookStoreException("Please check the Registered phone number");
}
	}
	@Override
	public BookSale fetchByBookIdAndContactNumber(int id, long contactNumber) throws BookStoreException {
		ShopRegistry checkShop=shopRepository.findByPhoneNumber(contactNumber);
		if(checkShop!=null) {
			return  bookSaleRepository.findByBookIdAndContactNumber(id,contactNumber);
		}
		else {
			throw new BookStoreException("Book/shop Name does not exist");

		}
	}
	@Override
	public List<BookSale> fetchBooksByShopId(int shopId) throws BookStoreException {
		Optional<ShopRegistry> checkShop=shopRepository.findById(shopId);
		if(checkShop.isPresent()) {
			
			return  checkShop.get().getBookSales();
		}
		else {
			throw new BookStoreException("Book/shop Name does not exist");

		}
	}
	@Override
	public ShopRegistry fetchShopByShopId(int shopId) throws BookStoreException {
		Optional<ShopRegistry> checkShop=shopRepository.findById(shopId);
		if(checkShop.isPresent()) {
			
			return  checkShop.get();
		}
		else {
			throw new BookStoreException("Shop  does not exist");

		}
	}
	

	/*
	 * @Override public List<OrderDetails> readAllOrders(long phoneNumber) throws
	 * BookStoreException { // List<ShopRegistry> checkShop=
	 * shopRepository.findByPhoneNumber(phoneNumber); // if(checkShop.size()>0) {
	 * List<OrderDetails> result =
	 * saleRepository.findByShopContactNumber(phoneNumber); if (result.size() > 0) {
	 * return result; } else { throw new
	 * BookStoreException("No values in database"); }
	 * 
	 * }
	 */
	
	@Override
	public String updateByBookId(long phoneNumber,int bookId, int updateAvailability) throws BookStoreException {
ShopRegistry checkShop=shopRepository.findByPhoneNumber(phoneNumber);
if(checkShop!=null) {
		BookSale temp = bookSaleRepository.findByBookIdAndContactNumber(bookId,phoneNumber);

		if (temp != null) {
			int appendAvailability = temp.getAvailableQuantity() + updateAvailability;
			temp.setAvailableQuantity(appendAvailability);
			temp.setShopRegisterRef(checkShop);

			bookSaleRepository.save(temp);
			return "Updated Successfully";
		}

		else {
			throw new BookStoreException("Not Updated---Book ID does not exist");
		}

	}
else {
	throw new BookStoreException("Shop Does not exist Please register");
	}
	}
	@Override
	public String updatePriceByBookId(long phoneNumber,int bookId, float updatedPrice) throws BookStoreException {
ShopRegistry checkShop=shopRepository.findByPhoneNumber(phoneNumber);
if(checkShop!=null) {
		BookSale temp = bookSaleRepository.findByBookIdAndContactNumber(bookId,phoneNumber);

		if (temp != null) {
			
			temp.setPrice(updatedPrice);
			temp.setShopRegisterRef(checkShop);

			bookSaleRepository.save(temp);
			return "Updated Successfully";
		}

		else {
			throw new BookStoreException("Not Updated---Book ID does not exist");
		}

	}
else {
	throw new BookStoreException("Shop Does not exist Please register");
	}
	}
	@Override
	public String deleteByBookName(long phoneNumber,String bookName) throws BookStoreException {
		ShopRegistry checkShop=shopRepository.findByPhoneNumber(phoneNumber);
		if(checkShop!=null) {
		
		BookSale temp = bookSaleRepository.findByBookNameAndContactNumber(bookName,phoneNumber);
		if (temp != null) {
			bookSaleRepository.delete(temp);
			return "Deleted Successfully";
		}

		else {
			throw new BookStoreException("Not Deleted---Book name does not exist");
		}
		}
		else {
			throw new BookStoreException("Not Deleted---Shop name does not exist");

		}
	}

	@Override
	public String deleteByBookId(int id,long phoneNumber) throws BookStoreException {
		ShopRegistry checkShop=shopRepository.findByPhoneNumber(phoneNumber);
		if(checkShop!=null) {
			BookSale temp = bookSaleRepository.findByBookIdAndContactNumber(id,phoneNumber);
			if (temp != null) {
				bookSaleRepository.delete(temp);
				return "Deleted Successfully";
			}


		else {
			throw new BookStoreException("Not Deleted---ID does not exist");
		}
		}
		
		else {
			throw new BookStoreException("Not Deleted---Shop does not exist");

		}
	}

	@Override
	public String updateByBookName(long phoneNumber,String bookName, int updateAvailability) throws BookStoreException {

		BookSale temp = bookSaleRepository.findByBookNameAndContactNumber(bookName,phoneNumber);

		if (temp != null) {
			int appendAvailability = temp.getAvailableQuantity() + updateAvailability;
			temp.setAvailableQuantity(appendAvailability);

			bookSaleRepository.save(temp);
			return "Updated Successfully";
		}

		else {
			throw new BookStoreException("Not Updated---Book/shop Name does not exist");
		}
	}

	
	//common
	
	

	}
	
	

	



	
	

	


	
	

