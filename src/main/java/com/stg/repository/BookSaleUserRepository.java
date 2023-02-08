package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.BookSaleUser;
@Repository
public interface BookSaleUserRepository extends JpaRepository<BookSaleUser, Integer> {

}
