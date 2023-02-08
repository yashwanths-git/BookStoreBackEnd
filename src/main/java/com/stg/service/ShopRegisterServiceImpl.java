package com.stg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.RegisteredUser;
import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;
import com.stg.repository.ShopRepository;
@Service

public class ShopRegisterServiceImpl implements ShopRegisterService {
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public String registerShop(String shopName, String userName, String password, long phoneNumber) throws BookStoreException {
		if(String.valueOf(phoneNumber).length() ==10) {
		ShopRegistry repeatCheck=shopRepository.findByPhoneNumber(phoneNumber);
		if(repeatCheck==null) {
			ShopRegistry registShop=new ShopRegistry(shopName,userName,password,phoneNumber);
			shopRepository.save(registShop);
		return "Shop Name::"+shopName+" Registered successfully";
	}
		else {
			throw new BookStoreException("Phone number is already exist please sign in to your shop ");
		}
		}else {
			throw new BookStoreException("Phone number length invalid ");

		}
	}
	

	@Override
	public String loginShop(String userName, String password) throws BookStoreException {
		ShopRegistry findWhileLogin=shopRepository.findByUserName(userName);
		if(findWhileLogin!=null) {
			if(findWhileLogin.getPassword().equals(password)) {
				return "Welcome :: "+findWhileLogin.getShopName()+"\n \n Redirecting to Your account--> ";
			}
			else {
				throw new BookStoreException("Password Does not match");
			}
		}
		else {
				throw new BookStoreException("User Name does Not exist-Please Register");
			}
		
		}


	@Override
	public ShopRegistry loginShopWithPhoneNumber(long phoneNumber, String password) throws BookStoreException {
		ShopRegistry findWhileLogin=shopRepository.findByPhoneNumber(phoneNumber);
		if(findWhileLogin!=null) {
			if(findWhileLogin.getPassword().equals(password)) {
				return findWhileLogin;
			}
			else {
				throw new BookStoreException("Password Does not match");
			}
		}
		else {
				throw new BookStoreException("Phone Number does Not exist-Please Register");
			}
		
	}


	@Override
	public String getShopName(long phoneNumber) throws BookStoreException {
		ShopRegistry findWhileLogin=shopRepository.findByPhoneNumber(phoneNumber);
		if(findWhileLogin!=null) {
				return findWhileLogin.getShopName();
		}
		
		else {
				throw new BookStoreException("Phone Number Not Found");
			}
		
		}
}

