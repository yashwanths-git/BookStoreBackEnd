package com.stg.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="registered_user")
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int regUserId;
	@Column(name="accountHolderName",length = 20)
	private String name;
	@Column(length = 30,unique = true)
	private String userName;
	@Column(length=50)
	private String password;
	private long phoneNumber;

	public RegisteredUser(String name, String userName, String password, long phoneNumber) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "registeredUser" )
	@JsonManagedReference(value =  "cartCustomer")
	private List<UserBook> cartBooks;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "registeredUserRef" )
	@JsonManagedReference(value =  "ordersOfSingleCustomer")
	@JsonIgnore
	private List<OrderDetails> listOfOrders;
	

}
