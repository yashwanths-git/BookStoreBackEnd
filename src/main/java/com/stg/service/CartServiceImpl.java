package com.stg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.RegisteredUser;
import com.stg.entity.UserBook;
import com.stg.exception.BookStoreException;
import com.stg.repository.CartRepository;
import com.stg.repository.Users;
//@Service
//public class CartServiceImpl implements CartService {
//	@Autowired
//	private Users usersRepository;
//	@Autowired
//	private CartRepository cartRepository;
//	@Override
//	public String addToCart(UserBook bookToCart,int regUserId) throws BookStoreException {
//		Optional<RegisteredUser> optional=usersRepository.findById(regUserId);
//		if(optional.isPresent()) {
//			RegisteredUser regUser=optional.get();
//		
//			if(bookToCart!=null) {
//			bookToCart.setRegisteredUser(regUser);
//			cartRepository.save(bookToCart);
//			return "Added to cart";
//		}
//			else {
//				throw new BookStoreException("Empty value is passed to cart");
//			}
//		}
//			else {
//				throw new BookStoreException("User Not Found");
//			}
//	}
//
//}
