package com.phoenix.data;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phoenix.data.entities.Product1;
import com.phoenix.data.repositores.ProductRepository;

@SpringBootApplication
public class DataJdbcDemoApplication implements CommandLineRunner
{
	private static final Logger LOG = LogManager.getLogger();
	
	@Autowired
	private ProductRepository ProductRepo;

	public static void main(String[] args) {
		SpringApplication.run(DataJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		// Get All Product
		Iterable<Product1>product=ProductRepo.findAll();
		//product.forEach(System.out::println);
		product.forEach(product1->LOG.info(product1));
		
		
		
		
		LOG.info("====================================================================================================");
		LOG.info("====================================================================================================");
		/*
		 * //Get Product By Id Optional<Product1> productOp =
		 * ProductRepo.findById(4003); if(productOp.isPresent()) { Product1
		 * p=productOp.get(); LOG.debug("Product " +p); System.out.println(p); } else {
		 * LOG.error("Sorry! Product is not found"); }
		 * 
		 * 
		 * LOG.info(
		 * "===================================================================================================="
		 * ); LOG.info(
		 * "===================================================================================================="
		 * ); //Count The LOG.info("No of Products " +ProductRepo.count());
		 * 
		 * //Update Product By Changing the Price productOp =
		 * ProductRepo.findById(4004); if(productOp.isPresent()) { Product1
		 * p=productOp.get(); float oldPrice=p.getPrice();
		 * 
		 * p.setPrice(p.getPrice() +1000.0f); ProductRepo.save(p); LOG.debug("Product "
		 * + p.getId()+ " Update Successfully! "); LOG.info("Product oldPrice "
		 * +oldPrice); LOG.info("Product newPrice " +p.getPrice());
		 * //System.out.println(p); } else { LOG.error("Sorry! Product is not found"); }
		 * 
		 * 
		 * 
		 * LOG.info(
		 * "===================================================================================================="
		 * ); LOG.info(
		 * "===================================================================================================="
		 * ); //delete Product productOp = ProductRepo.findById(100);
		 * if(productOp.isPresent()) { Product1 p=productOp.get(); //float
		 * oldPrice=p.getPrice(); p.setPrice(p.getPrice() +1000.0f);
		 * ProductRepo.delete(p); LOG.debug("Product " +p.getId()+
		 * "Delete Successfully!");
		 * 
		 * } else { LOG.error("Sorry! Product is not found"); }
		 * 
		 * 
		 * 
		 * 
		 * LOG.info(
		 * "===================================================================================================="
		 * ); LOG.info(
		 * "===================================================================================================="
		 * ); //Insert New Product Product1 product1=new Product1();
		 * product1.setId(104); product1.setName("FAN"); product1.setBrand("BAJAJ");
		 * product1.setPrice(20000.0f); product1.setInsert(true);// setting true to
		 * insert the record
		 * 
		 * ProductRepo.save(product1); LOG.info("new Product " +product1.getId()+
		 * " Inserted Successfully! ");
		 */
		
		List<Product1> pByNm = ProductRepo.findByName("leptop");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("==============================================FIND BY NAME======================================================");
		
		pByNm = ProductRepo.findByName("fan");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("===========================================FIND BY BRAND=========================================================");
		pByNm = ProductRepo.findByBrand("BAJAJ");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("===========================================FIND BY PRICE=========================================================");
		pByNm = ProductRepo.findByPrice(36000.00F);
		pByNm.forEach(product1->LOG.info(product1));
		

		LOG.info("===========================================FIND BY MIN OR MAX PRICE===============================================");
		pByNm = ProductRepo.findByPriceBetween(2000.00F,35000.0F);
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================FIND BY NAME OR BRAND =================================================");
		pByNm = ProductRepo.findByNameAndBrand("FAN","BAJAJ");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("===========================================FIND BY NAME OR PRICE ==================================================");
		pByNm = ProductRepo.findByNameAndPrice("FAN",20000.0F);
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================FIND BY NAME OR LiKe ==================================================");
		pByNm = ProductRepo.findByNameLike("%_A");
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================Find By Name Order By Price ==================================================");
		pByNm = ProductRepo.findByNameOrderByPrice("fan");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("===========================================Find By Name Order By Price Desc==================================================");
		pByNm = ProductRepo.findByNameOrderByPriceDesc("fan");
		pByNm.forEach(product1->LOG.info(product1));
		
		LOG.info("===========================================ORDER BY BRAND===================================================================");
		pByNm = ProductRepo.OrderByBrand();
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================SORT BY NAME===================================================================");
		pByNm = ProductRepo.sortByName();
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================getProductsByNameAndPrice===================================================================");
		pByNm = ProductRepo.getProductsByNameAndPrice("fan",20000.00f);
		pByNm.forEach(product1->LOG.info(product1));
		
		
		LOG.info("===========================================updatePriceByName===================================================================");
		
		int updateCount = ProductRepo.updatePriceByBrand("bajaj", 20000.0f);
		LOG.info("No of product" +updateCount);
		
		
		LOG.info("===========================================DeletePriceByName===================================================================");
		
		boolean deleteCount = ProductRepo.deleteProductByName("bajaj");
		LOG.info("No of product" +deleteCount);
	}

}
