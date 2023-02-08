package com.stg.service;

import com.stg.entity.RegisteredUser;
import com.stg.exception.BookStoreException;


public interface RegisterUserService {

	public abstract String registerUser( String name, String userName, String password,  long phoneNumber)throws BookStoreException ;
	//public abstract String loginWithPhoneNumber(String userName,String password)throws BookStoreException ;
	public abstract String loginWithPhoneNumber(long phoneNumber, String password) throws BookStoreException;
	public abstract RegisteredUser getUserDetailsWithPhoneNumber(long phoneNumber, String password) throws BookStoreException;
	RegisteredUser getUserWithPhoneNumber(long phoneNumber) throws BookStoreException;
}
