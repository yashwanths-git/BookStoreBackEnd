package com.stg.service;

import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;

public interface ShopRegisterService {
	
	public abstract String registerShop( String shopName, String userName, String password,  long phoneNumber)throws BookStoreException ;
	public abstract String loginShop(String userName,String password)throws BookStoreException ;
	public abstract ShopRegistry loginShopWithPhoneNumber(long phoneNumber, String password) throws BookStoreException ;
	public abstract String getShopName(long phoneNumber)throws BookStoreException ;

}
