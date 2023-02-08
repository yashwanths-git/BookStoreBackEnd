package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

//@Table(name="cutomerCart")
public class UserBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cartId")
	private int userBookId;
	private long shopPhoneNumber;
	private int bookId;

	private int numberOfBooksNeeded;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="custRegId",referencedColumnName = "regUserId" )
	@JsonBackReference(value="cartCustomer")
	private RegisteredUser registeredUser;
	
	
	//=================================================
	private float price;
	private String bookName;
	private String authorName;

}
