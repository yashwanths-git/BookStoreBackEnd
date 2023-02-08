package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.BookSale;
@Repository
public interface BookSaleRepository extends JpaRepository<BookSale, Integer>{
	//@Query(value="SELECT * FROM book_sale WHERE book_id=:bookId",nativeQuery = true)
	public abstract List<BookSale> findAllByBookId(int bookId);
//	public abstract BookSale findByBookIdAndShopName(int bookId,String shopName);
	
	public abstract List<BookSale> findByBookName(String bookName);
	public abstract List< BookSale> findAllByAuthorName(String authorName);
//	public abstract String deleteById(int bookId);
	
//	@Query(value="DELETE FROM book_sale WHERE book_name=:bookName",nativeQuery = true)
//	public abstract String deleteByBookName(@Param("bookName") String bookName);	
	
	public abstract BookSale findByBookIdAndContactNumber(int bookId,long contactNumber);
	public abstract BookSale findByBookNameAndContactNumber(String bookName,long contactNumber);
	
//	@Query(value = "UPDATE book_sale SET available_quantity =:appendAvailability WHERE book_id =:bookId",nativeQuery = true)
//	public abstract String updateBookQuantityById( int appendAvailability, int bookId);
	
	
	//public abstract boolean existsByName(String bookName);

}
