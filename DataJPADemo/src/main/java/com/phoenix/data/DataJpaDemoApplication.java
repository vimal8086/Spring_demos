package com.phoenix.data;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.phoenix.data.entities.Product1;
import com.phoenix.data.repositories.ProductRepository;

@SpringBootApplication
public class DataJpaDemoApplication implements CommandLineRunner {

	private static final Logger LOG=LogManager.getLogger();
	
	@Autowired
	private ProductRepository productRepo;
	public static void main(String[] args) {
		SpringApplication.run(DataJpaDemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("No of Products" + productRepo.count());
		
		//LOG.info("No of Products" + productRepo.findAll());
		
		List<Product>products=productRepo.findAll();
		products.forEach(product ->LOG.info(product));
		
		LOG.info("====================================================================================================");
		LOG.info("====================================================================================================");
		
		List<Product> pByNm = productRepo.findByName("leptop");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("====================================================================================================");
		LOG.info("==================================GET PRODUCT BY NAME AND PRICE=====================================");
		
		List<Product> pByNmAndP = productRepo.getProductsByNameAndPrice("leptop",2000.0f);
		pByNmAndP.forEach(product->LOG.info(product));
		
		LOG.info("===========================================FIND BY BRAND=========================================================");
		pByNm = productRepo.findByBrand("BAJAJ");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("===========================================FIND BY PRICE=========================================================");
		pByNm = productRepo.findByPrice(36000.00F);
		pByNm.forEach(product->LOG.info(product));
		

		LOG.info("===========================================FIND BY MIN OR MAX PRICE===============================================");
		pByNm = productRepo.findByPriceBetween(2000.00F,35000.0F);
		pByNm.forEach(product->LOG.info(product));
		
		
		LOG.info("===========================================FIND BY NAME OR BRAND =================================================");
		pByNm = productRepo.findByNameAndBrand("FAN","BAJAJ");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("===========================================FIND BY NAME OR PRICE ==================================================");
		pByNm = productRepo.findByNameAndPrice("FAN",20000.0F);
		pByNm.forEach(product->LOG.info(product));
		
		
		LOG.info("===========================================FIND BY NAME OR LiKe ==================================================");
		pByNm = productRepo.findByNameLike("%_A");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("===========================================Find By Name Order By Price ==================================================");
		pByNm = productRepo.findByNameOrderByPrice("fan");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("===========================================Find By Name Order By Price Desc==================================================");
		pByNm = productRepo.findByNameOrderByPriceDesc("fan");
		pByNm.forEach(product->LOG.info(product));
		
		LOG.info("===========================================ORDER BY BRAND===================================================================");
		pByNm = productRepo.OrderByBrand();
		pByNm.forEach(product->LOG.info(product));
		/*
		 * LOG.info(
		 * "===========================================updatePriceByName==================================================================="
		 * );
		 * 
		 * int updateCount = productRepo.updatePriceByBrand("bajaj", 20000.0f);
		 * LOG.info("No of product" +updateCount);
		 * 
		 * 
		 * LOG.info(
		 * "===========================================DeletePriceByName==================================================================="
		 * );
		 * 
		 * boolean deleteCount = productRepo.deleteProductByName("bajaj");
		 * LOG.info("No of product" +deleteCount);
		 * 
		 */
		
	}

}
