package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stg.entity.UserBook;

public interface CartRepository extends JpaRepository<UserBook, Integer> {

}
