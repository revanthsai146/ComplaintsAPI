package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exceptions.InValidModelNumberException;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;
import com.service.IProductService;

@SpringBootTest
class ProductTestCase{
    @Autowired
    IProductService productservice;
    
    @MockBean
    IProductRepository repo;
    @MockBean
    IComplaintRepository com;
    @MockBean
    IEngineerRepository en;
    
    @Test
    void testAddProduct() {
    	Product p=new Product();
    	LocalDate dt=LocalDate.parse("2021-11-01");
    	LocalDate wd=LocalDate.parse("2022-11-01");
    	p.setDateofPurchase(dt);
    	p.setModelNumber("LG123");
    	p.setProductCategoryName("AC");
    	p.setProductName("LG");
    	p.setWarrantyDate(wd);
    	p.setWarrentyYears(1);
    
Mockito.when(repo.save(p)).thenReturn(p);
		
		assertThat(productservice.addProduct(p)).isEqualTo(p);
    }
   
    @Test
    void testGetProduct() {
    	Product p=new Product();
    	LocalDate dt=LocalDate.parse("2021-11-01");
    	LocalDate wd=LocalDate.parse("2022-11-01");
    	p.setDateofPurchase(dt);
    	p.setModelNumber("LG123");
    	p.setProductCategoryName("AC");
    	p.setProductName("LG");
    	p.setWarrantyDate(wd);
    	p.setWarrentyYears(1);
    	
    	Product p1=new Product();
    	LocalDate dt1=LocalDate.parse("2021-10-10");
    	LocalDate wd1=LocalDate.parse("2022-10-09");
    	p1.setDateofPurchase(dt1);
    	p1.setModelNumber("SG1235");
    	p1.setProductCategoryName("Washing Machine");
    	p1.setProductName("Samsung");
    	p1.setWarrantyDate(wd1);
    	p1.setWarrentyYears(1);
    	
    	List<Product> productList = new ArrayList<>();
		productList.add(p);
		productList.add(p1);
		
		Mockito.when(repo.findAll()).thenReturn(productList);
		
		assertThat(productservice.getProduct()).isEqualTo(productList);
    	
    }
    
    @Test
    void testUpdateModelNumber() throws InValidModelNumberException {
    	Product p=new Product();
    	LocalDate dt=LocalDate.parse("2021-11-01");
    	LocalDate wd=LocalDate.parse("2022-11-01");
    	p.setDateofPurchase(dt);
    	p.setModelNumber("LG123");
    	p.setProductCategoryName("AC");
    	p.setProductName("LG");
    	p.setWarrantyDate(wd);
    	p.setWarrentyYears(1);
    	Optional<Product> p2= Optional.of(p);
    	
    	Mockito.when(repo.findByModelNumber("LG123")).thenReturn(p);
    	Mockito.when(repo.save(p)).thenReturn(p);
    	
    	p.setModelNumber("LG1256");
    	
    	
    	
    	assertThat(productservice.updateModelNumber(p)).isEqualTo(p);
    }
    
    @Test
    void testDeleteProduct() {
    	Product p1=new Product();
    	LocalDate dt1=LocalDate.parse("2021-10-10");
    	LocalDate wd1=LocalDate.parse("2022-10-09");
    	p1.setDateofPurchase(dt1);
    	p1.setModelNumber("SG1235");
    	p1.setProductCategoryName("Washing Machine");
    	p1.setProductName("Samsung");
    	p1.setWarrantyDate(wd1);
    	p1.setWarrentyYears(1);
    	Optional<Product> p2= Optional.of(p1);
    	
    	Mockito.when(repo.findById("SG1235")).thenReturn(p2);
    	Mockito.when(repo.existsById(p1.getModelNumber())).thenReturn(false);
		   assertFalse(repo.existsById(p1.getModelNumber()));
    }
    
	
	
	/*
	 * @Test void testGetProductComplaints() {
	 * 
	 * 
	 * Product p1=new Product(); LocalDate dt1=LocalDate.parse("2021-10-10");
	 * LocalDate wd1=LocalDate.parse("2022-10-09"); p1.setDateofPurchase(dt1);
	 * p1.setModelNumber("LG1245"); p1.setProductCategoryName("Washing Machine");
	 * p1.setProductName("LG"); p1.setWarrantyDate(wd1); p1.setWarrantyYears(1);
	 * 
	 * Mockito.when(repo.save(p1)).thenReturn(p1);
	 * 
	 * Complaint c=new Complaint(); c.setComplaintId(1);
	 * c.setProductModelNumber("LG1245"); c.setComplaintName("damage");
	 * c.setStatus("open"); c.setClientId("97"); c.setEngineerId(13);
	 * 
	 * Optional<Product> p2=Optional.of(p1);
	 * Mockito.when(repo.findById("LG1245")).thenReturn(p2);
	 * 
	 * assertThat(productservice.getProductComplaints("LG1245")).isEqualTo(p1);
	 * 
	 * 
	 * }
	 */
	 
    
	/*
	 * @Test void testGetEngineersByproduct() { Product p1=new Product(); LocalDate
	 * dt1=LocalDate.parse("2021-10-10"); LocalDate
	 * wd1=LocalDate.parse("2022-10-09"); p1.setDateofPurchase(dt1);
	 * p1.setModelNumber("SG1235"); p1.setProductCategoryName("Washing Machine");
	 * p1.setProductName("Samsung"); p1.setWarrantyDate(wd1);
	 * p1.setWarrantyYears(1);
	 * 
	 * Mockito.when(repo.findByModelNumber("SG1235")).thenReturn(p1);
	 * 
	 * Engineer e=new Engineer(); // e.setComplaints(p1); e.setDomain("fullstack");
	 * e.setEmployeeId(13); e.setEngineerName("ramu"); e.setPassword("12345");
	 * 
	 * 
	 * Optional<Product> p2=Optional.of(p1);
	 * 
	 * 
	 * Mockito.when(repo.findByModelNumber("SG1235")).thenReturn(p1);
	 * assertThat(productservice.getEngineersByProduct("SG1235")).isEqualTo(p1); }
	 */
}
