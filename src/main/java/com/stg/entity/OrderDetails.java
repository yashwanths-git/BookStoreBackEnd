package com.stg.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_details")

public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	@Column(length = 20)
	private String customerName;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "orderDetailsUserRef")
	@JsonManagedReference("invoiceBook")
	private List<BookSaleUser> books;
	
//	@Embedded
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "orderDetailsUserRef")
//	@JsonManagedReference(value="invoiceBook")
//	private BookSaleUser bookSaleUser;
	@Column
	private float price;
	@Column
	private long phoneNumber;
//	@Column
//	private long shopContactNumber;
//	@Column
//	private String shopName;
	@Column
	private int totalNumberOfBooks;
	@Column
	private String email;
	
@Enumerated(EnumType.STRING)
	private Paid paid;

//@JsonFormat(pattern = "dd-MM-yyyy") 
//private Date date;
//@JsonFormat(pattern = "hh:mm:ss")
//private Time time;


private LocalDate date;


private LocalTime time;
//private LocalDateTime dateTime;
	@Embedded
	private CustomerAddress address;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customerRegId",referencedColumnName = "regUserId" )
	@JsonBackReference(value="ordersOfSingleCustomer")
	private RegisteredUser registeredUserRef;
	
//	@ManyToOne
//	@JoinColumn(name="shopRegId", referencedColumnName  ="shopId")
//	@JsonBackReference(value="orderLink")
//	private ShopRegistry shopRegisterRef;

}
