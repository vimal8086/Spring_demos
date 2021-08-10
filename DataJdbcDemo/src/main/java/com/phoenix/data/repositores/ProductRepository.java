package com.phoenix.data.repositores;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.phoenix.data.entities.Product1;

public interface ProductRepository extends CrudRepository<Product1, Integer> 
{
	//Custom Finder Methods
	List<Product1> findByName(String name);
	List<Product1> findByBrand(String brand);
	List<Product1> findByPrice(float price);
	List<Product1> findByPriceBetween(float minPrice,float maxPrie);
	List<Product1> findByNameAndBrand(String name,String brand);
	List<Product1> findByNameAndPrice(String name,float price);
	List<Product1> findByNameLike(String namePattern);
	
	
	List<Product1> findByNameOrderByPrice(String name);
	List<Product1> findByNameOrderByPriceDesc(String name);
	
	
	List<Product1> OrderByBrand();
	
	@Query("select * from product1 order by name")
	List<Product1> sortByName();
	
	
	@Query("select * from product1 where name = :nm and price =:pr")
	List<Product1> getProductsByNameAndPrice(@Param("nm") String name,@Param("pr")float price); 
	
	@Modifying
	@Query("update product1 set price = price + :pr where brand = : br")
	int updatePriceByBrand(@Param("br")String brand,@Param("pr")float price);
	
	
	@Modifying
	@Query("delete from product1 where name=:nm")
	boolean deleteProductByName(@Param("nm")String name);
	
	
	
	
}
