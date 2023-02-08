package com.stg.controller;

import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.RegisteredUser;
import com.stg.exception.BookStoreException;
import com.stg.service.RegisterUserService;

@RestController
@RequestMapping(value = "registry")
@CrossOrigin(origins = "*")
public class RegistryController {
	@Autowired
	private RegisterUserService registryService;
	
	@PostMapping(value="register/{name}/{userName}/{password}/{phoneNumber}")
	public ResponseEntity< String> registerUser(@PathVariable String name,@PathVariable String userName,@PathVariable String password,@PathVariable  long phoneNumber)throws BookStoreException {
		
		return new ResponseEntity<String>( registryService.registerUser(name, userName, password, phoneNumber),HttpStatus.OK);
	}
	
	@GetMapping(value="login")
	public String login(@RequestParam long phoneNumber,@RequestParam String password) throws BookStoreException {
		return registryService.loginWithPhoneNumber(phoneNumber, password);
	}
	
	@GetMapping(value="getUserDetails/{phoneNumber}/{password}")
	public ResponseEntity <RegisteredUser> getUserDetails(@PathVariable long phoneNumber,@PathVariable String password) throws BookStoreException {
		return new ResponseEntity<RegisteredUser>(  registryService.getUserDetailsWithPhoneNumber(phoneNumber, password),HttpStatus.OK);
	}
	
	@GetMapping(value="getUserDetailsWithPhoneNumber/{phoneNumber}")
	public ResponseEntity <RegisteredUser> getUserDetailsWithPhoneNumber(@PathVariable long phoneNumber) throws BookStoreException {
		return new ResponseEntity<RegisteredUser>(  registryService.getUserWithPhoneNumber(phoneNumber),HttpStatus.OK);
	}

}
