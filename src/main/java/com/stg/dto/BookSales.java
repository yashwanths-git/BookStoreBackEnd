package com.stg.dto;


import com.stg.entity.OrderDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSales {
	private int bookId;
	private String bookName;
	private String authorName;
	private float price;
	private int availableQuantity;
	private OrderDetails orderDetailsRef;


}
