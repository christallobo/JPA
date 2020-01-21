package com.lti.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Orders;
import com.lti.model.Products;

public class MainClass {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		
		Products elecProduct =new Products();
		elecProduct.setProductId(1);
		elecProduct.setProductName("LED TV");
		elecProduct.setProductPrice(45000);
		
		Products beautyProduct =new Products();
		beautyProduct.setProductId(2);
		beautyProduct.setProductName("face Wash");
		beautyProduct.setProductPrice(230);
		
		Products babyProduct =new Products();
		babyProduct.setProductId(3);
		babyProduct.setProductName("Pampers");
		babyProduct.setProductPrice(300);
		

		Products eleProduct =new Products();
		eleProduct.setProductId(4);
		eleProduct.setProductName("CFL");
		eleProduct.setProductPrice(200);
		
		Orders firstOrder=new Orders();
		firstOrder.setOrderId(1000);
		firstOrder.setOrderDate(new Date());
		List<Products> list1 = new ArrayList<>();
		list1.add(elecProduct);
		list1.add(beautyProduct);
		firstOrder.setProducts(list1);
		
		Orders secondOrder=new Orders();
		secondOrder.setOrderId(1001);
		secondOrder.setOrderDate(new Date());
		List<Products> list2 = new ArrayList<>();
		list2.add(babyProduct);
		list2.add(eleProduct);
		secondOrder.setProducts(list2);
		
		entityManager.getTransaction().begin();
		entityManager.persist(firstOrder);
		entityManager.persist(secondOrder);
		
		entityManager.getTransaction().commit();

		entityManager.close();
		factory.close();

	}
}
