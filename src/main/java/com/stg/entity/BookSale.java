package com.stg.entity;

import javax.persistence.CascadeType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//TODO :add date and time for invoice



//@ToString
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book_sale")
public class BookSale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int bookUniqueNumber;
	@Column
	private int bookId;
	@Column(length=100)
	private String bookName;
	@Column(length=30)
	private String authorName;
	@Column
	private float price;
	@Column
	private int availableQuantity;
	@Column
	private String shopName;
	@Column
	private long contactNumber;
	
	@ManyToOne
	@JoinColumn(name="shopRegId",referencedColumnName = "shopId")
	@JsonBackReference(value="shopLink")
	private ShopRegistry shopRegisterRef;
	@Override
	public String toString() {
		return "BookSale [bookUniqueNumber=" + bookUniqueNumber + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", authorName=" + authorName + ", price=" + price + ", availableQuantity=" + availableQuantity
				+ ", contactNumber=" + contactNumber + ", shopName=" + shopName + "]";
	}
	
//	@Override
//	public String toString() {
//		return "BookSale [  bookId=" + bookId + ", bookName=" + bookName
//				+ ", authorName=" + authorName + ", price=" + price + ", availableQuantity=" + availableQuantity
//				+ ", contactNumber=" + contactNumber + "]";
//	}

	

//	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
//	@JoinColumn(name="orderId")
//	@JsonBackReference(value="dataBaseBook")
//	
//	private OrderDetails orderDetailsRef;
	


}

