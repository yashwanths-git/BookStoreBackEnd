package com.stg.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.BookSale;
import com.stg.entity.BookSaleUser;
import com.stg.entity.CustomerAddress;
import com.stg.entity.OrderDetails;
import com.stg.entity.Paid;
import com.stg.entity.RegisteredUser;
import com.stg.entity.ShopRegistry;
import com.stg.entity.UserBook;
import com.stg.exception.BookStoreException;
import com.stg.repository.BookSaleRepository;
import com.stg.repository.BookSaleUserRepository;
import com.stg.repository.SaleRepository;
import com.stg.repository.ShopRepository;
import com.stg.repository.Users;

@Service
public class SaleServiceUserImpl implements SaleServiceUser {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private BookSaleRepository bookSaleRepository;
	@Autowired
	private BookSaleUserRepository bookSaleUserRepository;
	@Autowired
	private Users usersRepository;

	@Autowired
	private ShopRepository shopRepository;

	@Override
	public OrderDetails createOrder( String customerName, long phoneNumber, CustomerAddress address,
			List<UserBook> books, String email, Paid paid) throws BookStoreException {
		boolean validationTesting = true;
		int totalBooks = 0;
		float totalPrice = 0;
		if (!(String.valueOf(phoneNumber).length() == 10)) {
			validationTesting = false;
			throw new BookStoreException("Enter a valid number");

		}
		if (!(email.matches("^(.+)@(\\S+)$"))) {
			validationTesting = false;
			throw new BookStoreException("Enter a valid Email Adress");

		}
		

		List<BookSaleUser> cart = new ArrayList<BookSaleUser>();
		OrderDetails placeOrder = new OrderDetails();
		for (UserBook bookList : books) {
//			BookSale 
			
			ShopRegistry shop=shopRepository.findByPhoneNumber(bookList.getShopPhoneNumber());

			if(shop!=null) {
	
			BookSale searchingBookMatch=bookSaleRepository.findByBookIdAndContactNumber(bookList.getBookId(),shop.getPhoneNumber());
		
			if(searchingBookMatch!=null) {
			
				
			

			//Optional<BookSale> optional = bookSaleRepository.findById(tempId);
			
			
//			if (optional.isPresent()) {
//			
//				searchingBookMatch = optional.get();
				if (searchingBookMatch.getAvailableQuantity() >= bookList.getNumberOfBooksNeeded()) {

					float singleBookTotalPrice = bookList.getNumberOfBooksNeeded() * searchingBookMatch.getPrice();
					System.err.println(singleBookTotalPrice);
					BookSaleUser bookSaleUsertemp = new BookSaleUser(searchingBookMatch.getBookId(),
							searchingBookMatch.getBookName(), searchingBookMatch.getAuthorName(),
							searchingBookMatch.getPrice(), bookList.getNumberOfBooksNeeded(), singleBookTotalPrice,placeOrder,shop);
bookSaleUsertemp.setShopName(shop.getShopName());
					cart.add(bookSaleUsertemp);
					// cart.add(searchingBookMatch);
					searchingBookMatch.setAvailableQuantity(
							searchingBookMatch.getAvailableQuantity() - bookList.getNumberOfBooksNeeded());
					totalBooks += bookList.getNumberOfBooksNeeded();
					totalPrice = totalPrice + (bookList.getNumberOfBooksNeeded() * searchingBookMatch.getPrice());

				} else {
					validationTesting = false;
					throw new BookStoreException("Book stock is less than required");

				}

			} else {
				validationTesting = false;
				throw new BookStoreException(
						"Book ID " + bookList.getBookId() + "   is invalid-Please enter a valid book ID");
			}
			}
			else {
				throw new BookStoreException("Shop not exist");
			}
		}
	
		
		if (validationTesting) {
			RegisteredUser regTemp= usersRepository.findByPhoneNumber(phoneNumber);
		
			if(regTemp!=null) {
	
//				ShopRegistry shopTemp=shopRepository.findByShopName();
//				if(shopTemp!=null) {

			if ("yes".equalsIgnoreCase(paid.toString())) {
				placeOrder.setCustomerName(customerName);
				// placeOrder.setBooks(cart);

//			
//				bookSale.setOrderDetailsRef(placeOrder);
//				bookSaleRepository.save(bookSale);
//					
//				
//				
//				bookSaleRepository.save(bookSale);
//				

				placeOrder.setPrice(totalPrice);
				placeOrder.setAddress(address);
				placeOrder.setEmail(email);
				placeOrder.setBooks(cart);

				placeOrder.setTotalNumberOfBooks(totalBooks);
				placeOrder.setPhoneNumber(phoneNumber);
				placeOrder.setPaid(paid);
			
//				placeOrder.setShopName(shopName);
//				placeOrder.setShopContactNumber(shopTemp.getPhoneNumber());
//				placeOrder.setShopRegisterRef(shopTemp);
				
				
/*
				
				for (BookSaleUser bookSaleCartUser : cart) {
					ShopRegistry shopTemp=shopRepository.findByPhoneNumber(bookSaleCartUser.getShopRegisterRef().);
					if(shopTemp!=null) {
					BookSaleUser bookSaleUse = new BookSaleUser();
					bookSaleUse.setBookId(bookSaleCartUser.getBookId());
					bookSaleUse.setBookName(bookSaleCartUser.getBookName());
					bookSaleUse.setAuthorName(bookSaleCartUser.getAuthorName());
					bookSaleUse.setQuantity(bookSaleCartUser.getQuantity());
					bookSaleUse.setPrice(bookSaleCartUser.getTotalPrice());
					bookSaleUse.setShopRegisterRef(shopTemp);
					bookSaleUse.setOrderDetailsUserRef(placeOrder);
					//bookSaleUserRepository.save(bookSaleUse);
					//placeOrder.setBookSaleUser(bookSale);

				}*/
			
				placeOrder.setDate(LocalDate.now());
				placeOrder.setTime(LocalTime.now());
				placeOrder.setRegisteredUserRef(regTemp);
//				placeOrder.setDateTime(LocalDateTime.now());
				saleRepository.save(placeOrder);


				return placeOrder;
			} else {
				throw new BookStoreException("Order Not Placed-Please make payment of Rs::"+totalPrice);
			}
		}
			
		
		else{
			throw new BookStoreException("Order Not Placed-Please Register -Moblie Number Mismatched");
		}
		}
		else {
			throw new BookStoreException("Order Not Placed-Please verify your credentials");
		}
		
		}
	@Override
	public RegisteredUser getUserDetailsWithUserId(int userId) throws BookStoreException {
	
		Optional<RegisteredUser> findWhileLogin=usersRepository.findById(userId);
		if(findWhileLogin.isPresent()) {
		
				return findWhileLogin.get();
		
		}
		else {
				throw new BookStoreException("User Id Number does Not exist");
				}
	}	
		

	@Override
	public OrderDetails createOrderWithListOfBooks(OrderDetails ordDetails) throws BookStoreException {
		boolean validationTesting = true;
		int totalBooks = 0;
		float totalPrice = 0;
		if (!(String.valueOf(ordDetails.getPhoneNumber()).length() == 10)) {
			validationTesting = false;
			throw new BookStoreException("Enter a valid number");

		}
		if (!(ordDetails.getEmail().matches("^(.+)@(\\S+)$"))) {
			validationTesting = false;
			throw new BookStoreException("Enter a valid Email Adress");

		}

		List<BookSaleUser> cart = new ArrayList<BookSaleUser>();
		OrderDetails placeOrder = new OrderDetails();

		for (BookSaleUser bookList : ordDetails.getBooks()) {
//			BookSale 
			Integer tempId = bookList.getBookId();
			System.out.println(tempId);
			Optional<BookSale> optional = bookSaleRepository.findById(tempId);

			BookSale searchingBookMatch = new BookSale();

			if (optional.isPresent()) {

				searchingBookMatch = optional.get();
				if (searchingBookMatch.getAvailableQuantity() > bookList.getQuantity()) {

					float singleBookTotalPrice = bookList.getQuantity() * searchingBookMatch.getPrice();
					System.err.println(singleBookTotalPrice);
					BookSaleUser bookSaleUsertemp = new BookSaleUser(searchingBookMatch.getBookId(),
							searchingBookMatch.getBookName(), searchingBookMatch.getAuthorName(),
							searchingBookMatch.getPrice(), bookList.getQuantity(), singleBookTotalPrice, placeOrder);

					cart.add(bookSaleUsertemp);
					// cart.add(searchingBookMatch);
					searchingBookMatch
							.setAvailableQuantity(searchingBookMatch.getAvailableQuantity() - bookList.getQuantity());
					totalBooks += bookList.getQuantity();
					totalPrice = totalPrice + (bookList.getQuantity() * searchingBookMatch.getPrice());

				} else {
					validationTesting = false;
					throw new BookStoreException("Book stock is less than required");

				}

			} else {
				validationTesting = false;
				throw new BookStoreException(
						"Book ID " + bookList.getBookId() + "   is invalid-Please enter a valid book ID");
			}

		}

		if (validationTesting) {
			RegisteredUser regTemp = usersRepository.findByPhoneNumber(ordDetails.getPhoneNumber());
			if (regTemp != null) {

				if ("yes".equalsIgnoreCase(ordDetails.getPaid().toString())) {
					placeOrder.setCustomerName(ordDetails.getCustomerName());
					// placeOrder.setBooks(cart);

//			
//				bookSale.setOrderDetailsRef(placeOrder);
//				bookSaleRepository.save(bookSale);
//					
//				
//				
//				bookSaleRepository.save(bookSale);
//				

					placeOrder.setPrice(totalPrice);
					placeOrder.setAddress(ordDetails.getAddress());
					placeOrder.setEmail(ordDetails.getEmail());
					placeOrder.setBooks(cart);

					placeOrder.setTotalNumberOfBooks(totalBooks);
					placeOrder.setPhoneNumber(ordDetails.getPhoneNumber());
					placeOrder.setPaid(ordDetails.getPaid());

					for (BookSaleUser bookSaleCartUser : cart) {
						BookSaleUser bookSaleUse = new BookSaleUser();
						bookSaleUse.setBookId(bookSaleCartUser.getBookId());
						bookSaleUse.setBookName(bookSaleCartUser.getBookName());
						bookSaleUse.setAuthorName(bookSaleCartUser.getAuthorName());
						bookSaleUse.setQuantity(bookSaleCartUser.getQuantity());
						bookSaleUse.setPrice(bookSaleCartUser.getTotalPrice());

						bookSaleUse.setOrderDetailsUserRef(placeOrder);
						// bookSaleUserRepository.save(bookSaleUse);
						// placeOrder.setBookSaleUser(bookSale);

					}

					placeOrder.setDate(LocalDate.now());
					placeOrder.setTime(LocalTime.now());
					placeOrder.setRegisteredUserRef(regTemp);
//				placeOrder.setDateTime(LocalDateTime.now());
					saleRepository.save(placeOrder);

					return placeOrder;
				} else {
					throw new BookStoreException("Order Not Placed-Please make payment");
				}
			}

			else {
				throw new BookStoreException("Order Not Placed-Please Register -Moblie Number Mismatched");
			}
		} else {
			throw new BookStoreException("Order Not Placed-Please verify your credentials");
		}

	}
}
//@Autowired
//private BookSale bookSale;

//ModelMapper mapper = new ModelMapper();
//UserBook dtoUserBook = mapper.map(bookSale, UserBook.class);

// BookSales bookSaleCopy = mapper.map(bookSale, BookSales.class);

/**
 * @Override public OrderDetails createOrder(String customerName, long
 *           phoneNumber, CustomerAddress address, List<UserBook> books, String
 *           email, Paid paid) throws BookStoreException {
 * 
 *           boolean validationTesting = true; int totalBooks = 0; float
 *           totalPrice = 0; if (!(String.valueOf(phoneNumber).length() == 10))
 *           { validationTesting = false; throw new BookStoreException("Enter a
 *           valid number");
 * 
 *           } // if (!(email.matches("@.com$"))) { // validationTesting =
 *           false; // throw new BookStoreException("Enter a valid Email
 *           Adress"); // // }
 * 
 *           List<BookSaleUser> cart = new ArrayList<BookSaleUser>(); for
 *           (UserBook bookList : books) { // BookSale Integer tempId =
 *           bookList.getBookId(); System.out.println(tempId);
 *           Optional<BookSale> optional = bookSaleRepository.findById(tempId);
 * 
 *           BookSale searchingBookMatch = new BookSale(); OrderDetails
 *           dummy=new OrderDetails(); if (optional.isPresent()) {
 * 
 *           searchingBookMatch = optional.get(); if
 *           (searchingBookMatch.getAvailableQuantity() >
 *           bookList.getNumberOfBooksNeeded()) { float singleBookTotalPrice =
 *           bookList.getNumberOfBooksNeeded() * searchingBookMatch.getPrice();
 *           BookSaleUser bookSaleUsertemp = new
 *           BookSaleUser(searchingBookMatch.getBookId(),
 *           searchingBookMatch.getBookId(), searchingBookMatch.getBookName(),
 *           searchingBookMatch.getAuthorName(), searchingBookMatch.getPrice(),
 *           bookList.getNumberOfBooksNeeded(), singleBookTotalPrice,dummy);
 * 
 *           cart.add(bookSaleUsertemp);
 *           searchingBookMatch.setAvailableQuantity(
 *           searchingBookMatch.getAvailableQuantity() -
 *           bookList.getNumberOfBooksNeeded()); totalBooks +=
 *           bookList.getNumberOfBooksNeeded(); totalPrice = totalPrice +
 *           (bookList.getNumberOfBooksNeeded() *
 *           searchingBookMatch.getPrice());
 * 
 *           } else { validationTesting = false; throw new
 *           BookStoreException("Book stock is less than required");
 * 
 *           }
 * 
 *           } else { validationTesting = false; throw new BookStoreException(
 *           "Book ID " + bookList.getBookId() + " is invalid-Please enter a
 *           valid book ID"); }
 * 
 *           } OrderDetails placeOrder = new OrderDetails(); if
 *           (validationTesting) {
 * 
 *           if ("yes".equalsIgnoreCase(paid.toString())) {
 *           placeOrder.setCustomerName(customerName);
 *           placeOrder.setBooks(cart);
 * 
 *           // // bookSale.setOrderDetailsRef(placeOrder); //
 *           bookSaleRepository.save(bookSale); // // // //
 *           bookSaleRepository.save(bookSale); //
 * 
 *           placeOrder.setPrice(totalPrice); placeOrder.setAddress(address);
 *           placeOrder.setEmail(email);
 * 
 *           placeOrder.setTotalNumberOfBooks(totalBooks);
 *           placeOrder.setPhoneNumber(phoneNumber);
 * 
 *           placeOrder.setPaid(paid); System.err.println("test");
 *           saleRepository.save(placeOrder);
 * 
 *           for (BookSaleUser bookSaleCart : cart) { BookSaleUser bookSaleUser
 *           = new BookSaleUser();
 *           bookSaleUser.setBookId(bookSaleCart.getBookId());
 *           bookSaleUser.setBookName(bookSaleCart.getBookName());
 *           bookSaleUser.setAuthorName(bookSaleCart.getAuthorName());
 *           bookSaleUser.setQuantity(bookSaleCart.getQuantity());
 *           bookSaleUser.setPrice(bookSaleCart.getPrice());
 *           bookSaleUser.setTotalPrice(bookSaleCart.getTotalPrice());
 * 
 *           bookSaleUser.setOrderDetailsUserRef(placeOrder);
 *           bookSaleUserRepository.save(bookSaleUser);
 * 
 *           }
 * 
 *           return placeOrder; } else { throw new BookStoreException("Order Not
 *           Placed-Please make payment"); } } else { throw new
 *           BookStoreException("Order Not Placed-Please verify your
 *           credentials"); } }
 **/

// common
