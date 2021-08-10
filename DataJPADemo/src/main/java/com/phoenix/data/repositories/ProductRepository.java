package com.phoenix.data.repositories;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phoenix.data.Product;
//import com.phoenix.data.entities.Product1;

public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	List<Product>findByName(String name);
	List<Product> findByBrand(String brand);
	List<Product> findByPrice(float price);
	List<Product> findByPriceBetween(float minPrice,float maxPrie);
	List<Product> findByNameAndBrand(String name,String brand);
	List<Product> findByNameAndPrice(String name,float price);
	List<Product> findByNameLike(String namePattern);
	
	List<Product> findByNameOrderByPrice(String name);
	List<Product> findByNameOrderByPriceDesc(String name);
	
	
	List<Product> OrderByBrand();
	
	
	@Query("select p from Product p where p.name = ?1 and p.price= ?2")
	List<Product> getProductsByNameAndPrice(String name,float price);
	
	/*
	 * @Query("select * from product1 order by name") List<Product> sortByName();
	 * 
	 * 
	 * //@Modifying
	 * 
	 * @Query("update Product p set p.price = p.price +? where b b.brand =?") int
	 * updatePriceByBrand(String brand,float price);
	 * 
	 * 
	 * //@Modifying
	 * 
	 * @Query("delete from Product p where p.name=?") boolean
	 * deleteProductByName(@Param("nm")String name);
	 */
}
