package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entities.Complaint;
import com.entities.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product,String> {
	
	
	
	  @Query("Select c from Product c where c.modelNumber=?1") 
	  public Product getProductByComplaint1(String modelNumber);
//	  @Query("Select p from Product p order by p.modelNumber")
//		List<Product> findByModelNumber(String modelNumber);

	
	
}
