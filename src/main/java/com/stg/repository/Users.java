package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.RegisteredUser;

@Repository
public interface Users extends JpaRepository<RegisteredUser, Integer> {
	
	public abstract RegisteredUser findByPhoneNumber(long number);
	public abstract RegisteredUser findByUserName(String userName);

}
