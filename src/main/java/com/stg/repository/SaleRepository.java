package com.stg.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.BookSale;
import com.stg.entity.OrderDetails;

@Repository
public interface SaleRepository extends JpaRepository<OrderDetails, Integer> {

	public abstract OrderDetails findByOrderId(int id) ;
	
	public abstract List< OrderDetails> findByPhoneNumber(long phoneNumber) ;
	//public abstract List< OrderDetails> findByShopContactNumber(long phoneNumber) ;
	//TODO :try to remove bookId 
	
	
	
	

}
