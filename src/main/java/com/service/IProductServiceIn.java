package com.service;
  
  import java.util.List;

import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.exceptions.InValidModelNumberException;
  
  public interface IProductServiceIn {
  
  public Product addProduct(Product product);
  public String deleteProduct(String eid); 
  public List<Product> getProduct();
  
  //public Product updateWarranty(String modelNumber,Product product)throws InValidModelNumberException ;
  public Product updateWarranty(String modelNumber,Product product);
  public List<Complaint> getProductComplaints(String productCategoryName);
  public List<Engineer> getEngineersByProduct(String productCategoryName);
//Product getProductById(String modelNumber);
//Product getProductById(String productCategoryName);
//List<Product> getProductByModelNumber(String modelNumber);


  
  
  
  }