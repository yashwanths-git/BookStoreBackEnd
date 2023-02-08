package com.stg.controller;

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

import com.stg.entity.ShopRegistry;
import com.stg.exception.BookStoreException;
import com.stg.service.ShopRegisterService;

@RestController
@RequestMapping(value="shopRegistry")
@CrossOrigin(origins = "*")
public class ShopRegistryController {
	@Autowired
	private ShopRegisterService shopRegistryService;
	
	@PostMapping(value="registerShop/{shopName}/{userName}/{password}/{phoneNumber}")
	public ResponseEntity< String >registerShop(@PathVariable String shopName,@PathVariable String userName,@PathVariable String password,@PathVariable  long phoneNumber)throws BookStoreException {
		
		return new ResponseEntity<String>( shopRegistryService.registerShop(shopName, userName, password, phoneNumber),HttpStatus.OK);
	}
	
	@GetMapping(value="loginShop")
	public ResponseEntity<String> loginShop(@RequestParam String userName,@RequestParam String password) throws BookStoreException {
		return  new ResponseEntity<String>(shopRegistryService.loginShop(userName, password),HttpStatus.OK);
	}
	@GetMapping(value="shopDetailsWithPhoneNumber/{phoneNumber}/{password}")
	public ShopRegistry getShopDetailsWithPhoneNumber(@PathVariable long phoneNumber,@PathVariable String password) throws BookStoreException {
		return shopRegistryService.loginShopWithPhoneNumber(phoneNumber, password);
	}
	@GetMapping(value="shopName/{phoneNumber}")
	public ResponseEntity<String> shopName(@PathVariable long phoneNumber) throws BookStoreException {
		return  new ResponseEntity<String>(shopRegistryService.getShopName( phoneNumber),HttpStatus.OK);
	}

}
