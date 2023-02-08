package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Embeddable

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book_sale_user")
public class BookSaleUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userBookId;
	@Column
	private int bookId;
	@Column(length=100)
	private String bookName;
	@Column(length=30)
	private String authorName;
	@Column
	private float price;
	@Column
	private int Quantity;
	//TODO:here<3
	@ManyToOne
	@JoinColumn(name="shopRegId", referencedColumnName  ="shopId")
	@JsonBackReference(value="shopsLink")
	private ShopRegistry shopRegisterRef;

	

//	@OneToOne
//	@JoinColumn(name="orderId")
//	@JsonBackReference(value="invoiceBook")
//	
//	private OrderDetails orderDetailsUserRef;
	
	@Column
	private float totalPrice;
	
	private String shopName;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="orderId")
	@JsonBackReference(value="invoiceBook")
	
	private OrderDetails orderDetailsUserRef;

	public BookSaleUser(int bookId, String bookName, String authorName, float price, int quantity, float totalPrice,
			OrderDetails orderDetailsUserRef) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		Quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDetailsUserRef = orderDetailsUserRef;
	}
	public BookSaleUser(int bookId, String bookName, String authorName, float price, int quantity, float totalPrice,
			OrderDetails orderDetailsUserRef,ShopRegistry shopRegisterRef) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.price = price;
		Quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDetailsUserRef = orderDetailsUserRef;
		this.shopRegisterRef=shopRegisterRef;
	}


}
