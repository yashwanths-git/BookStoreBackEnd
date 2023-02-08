package com.stg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.stg.entity.RegisteredUser;
import com.stg.exception.BookStoreException;
import com.stg.repository.Users;

@Service
public class RegisterUserImpl implements RegisterUserService {
	
@Autowired
private Users usersRepository;

	@Override
	public String registerUser( String name, String userName, String password,  long phoneNumber) throws BookStoreException {
		if(String.valueOf(phoneNumber).length()==10) {
			RegisteredUser repeatCheck=usersRepository.findByPhoneNumber(phoneNumber);
			if(repeatCheck==null) {
				RegisteredUser registUser=new RegisteredUser(name,userName,password,phoneNumber);
			usersRepository.save(registUser);
			return "Registered successfully";
		}
			else {
				throw new BookStoreException("Phone number is already exist please sign in ");
			}
		}
		else {
			throw new BookStoreException("Phone number length Invalid ");
		}
		}
	
		
	

	@Override
	public String loginWithPhoneNumber(long phoneNumber, String password) throws BookStoreException {
		RegisteredUser findWhileLogin=usersRepository.findByPhoneNumber(phoneNumber);
		if(findWhileLogin!=null) {
			if(findWhileLogin.getPassword().equals(password)) {
				return "Welcome User:: "+findWhileLogin.getName()+"\n \n Redirecting to Your account--> ";
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
	public RegisteredUser getUserDetailsWithPhoneNumber(long phoneNumber, String password) throws BookStoreException {
		RegisteredUser findWhileLogin=usersRepository.findByPhoneNumber(phoneNumber);
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
	public RegisteredUser getUserWithPhoneNumber(long phoneNumber) throws BookStoreException {
		RegisteredUser findWhileLogin=usersRepository.findByPhoneNumber(phoneNumber);
		if(findWhileLogin!=null) {
			return findWhileLogin;
		}
		else {
				throw new BookStoreException("Phone Number does Not exist-Please Register");
			}
		
		}




	
}


