package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="customer_address")
public class CustomerAddress {
	@Column
	private int doorNo;
	@Column(length = 20)
	private String streetName;
	@Column(length = 20)
	private String city;
	@Column(length = 15)
	private String state;

}
