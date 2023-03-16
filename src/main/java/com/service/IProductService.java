package com.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.exceptions.InValidModelNumberException;
import com.exceptions.OutOfWarrantyException;

import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;

@Service
@EnableJpaRepositories(basePackages="com.repository")
@Component
public class IProductService implements IProductServiceIn
{	
	@Autowired
	IProductRepository repo;
	@Autowired
	IComplaintRepository com;
	@Autowired
	IEngineerRepository en;
	
	
	
	@Override
	public Product addProduct(Product product) {
		repo.save(product);
		return product;
	}
	
	@Override
	public List<Product> getProduct() {
		List<Product> p=repo.findAll();
		return p;
	}

	@Override
	public String deleteProduct(String eid) {
		
		 repo.deleteById(eid);
		 return "Deleted";
	
		
	}
//	public Product getProductById1(String modelNumber) {
//		
//		Product p=repo.findByModelNumber(modelNumber);
//		return p;
//	}
//	@Override
//	public Product updateModelNumber(Product p) throws InValidModelNumberException {
//		Product p1=repo.save(p);
//		return p1;
//	}
	
//	public Product updateWarranty(Product p) throws Throwable {
//		String id=p.getModelNumber();
//		Supplier s=()->new InValidModelNumberException ("Product Does not exist");
//	
//		Product p1=repo.findByModelNumber(id).orElseThrow(s);
//	    p1.setProduct(p.getName());
//		bd1.setMobileNumber(bd.getMobileNumber());
//		repo.save(bd1);
//		
//		return bd1;
//		Product p1=repo.save(p);
//		
//	}
//	@Override
//	public List<Product> updateProduct(Product p) {
//		List<Product> plist = p.findAll();
//		for(Product product : plist)
//		{
//			try {
//				if(Product.getModelNumber() ==p.getModelNumber())
//				{
//					product.setProductName(p.getProductName());
//					product.setProductCategoryName(p.getProductCategoryName());
//					
//					break;
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		ur.saveAll(ulist);
//		
//		return ur.findAll();
//	}
	
//	@Override
//	public Product updateWarranty(String modelNumber,Product product)throws InValidModelNumberException{
//	Product p=repo.findByModelNumber(product.getModelNumber());
//	
//	if(product.getDateofPurchase()!=null) {
//		p.setDateofPurchase(product.getDateofPurchase());
//	}
//	if(product.getProductCategoryName()!=null) {
//		p.setProductCategoryName(product.getProductCategoryName());
//	}
//	if(product.getProductName()!=null) {
//		p.setProductName(product.getProductName());
//	}
//	if(product.getWarrantyDate()!=null) {
//		p.setWarrantyDate(product.getWarrantyDate());
//	}
////	if(product.getWarrantyYears()!=null) {
////		p.setWarrantyYears(product.getWarrantyYears());
////	}
//		return repo.save(p);
//		
//	}
	@Override
	  public Product updateWarranty(String modelNumber ,Product product) {
		  Product p=repo.findById(modelNumber).orElseThrow();
		  p.setDateofPurchase(product.getDateofPurchase());
		  p.setProductCategoryName(product.getProductCategoryName());
		  p.setProductName(product.getProductName());
		  p.setWarrantyDate(product.getWarrantyDate());
		  p.setModelNumber(product.getModelNumber());
		  p.setWarrantyYears(product.getWarrantyYears());
		  return repo.save(p);
	  }
	
	
	
	
	  @Override
	  public List<Complaint> getProductComplaints(String productCategoryName) {
		  List<Complaint> lc= ((IProductService) repo).getProductComplaints(productCategoryName); 
		  return lc; 
		  }
	@Override
	public List<Engineer> getEngineersByProduct(String productCategoryName) {
		 List<Engineer> lc= ((IProductService) repo). getEngineersByProduct(productCategoryName); 
		  return lc; 
		
	}

	

//	@Override
//		public List<Product> getProductByModelNumber(String modelNumber) {
//	List<Product> p=repo.findByModelNumber(modelNumber);
//	return p;
//}



}

	
	 
	
	