package com.company.store;

import com.company.store.entity.Product;
import com.company.store.repository.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StoreApplication.class, args);

        ApplicationContext context = SpringApplication.run(StoreApplication.class,args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        //create products
        Product product1 = new Product("rice",2.50);
        Product product2 = new Product("oil",3.50);
        Product product3 = new Product("bread",0.40);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
	}

}
