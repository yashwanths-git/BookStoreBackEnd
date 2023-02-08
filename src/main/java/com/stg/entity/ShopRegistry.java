package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ShopRegistry {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int shopId;
@Column(length=50)
private String shopName;
@Column(length = 30)
private String userName;
public ShopRegistry(String shopName, String userName, String password, long phoneNumber) {
	super();
	this.shopName = shopName;
	this.userName = userName;
	this.password = password;
	this.phoneNumber = phoneNumber;
}
@Column(length = 30)
private String password;
@Column
private long phoneNumber;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "shopRegisterRef")
@JsonManagedReference("shopLink")
private List<BookSale>bookSales;
//TODO:Here<3 
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "shopRegisterRef")
@JsonManagedReference("shopsLink")
private List<BookSaleUser> listOfOrderedBooks;
//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "shopRegisterRef")
//@JsonManagedReference("orderLink")
//private List<OrderDetails> listOfOrdersRef;
}
