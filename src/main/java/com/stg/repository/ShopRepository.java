package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.RegisteredUser;
import com.stg.entity.ShopRegistry;
@Repository
public interface ShopRepository extends JpaRepository<ShopRegistry, Integer> {
	public abstract ShopRegistry findByPhoneNumber(long number);
	public abstract ShopRegistry findByUserName(String userName);
	public abstract ShopRegistry findByShopName(String shopName);
	

}
