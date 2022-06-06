package com.soft.ProductManager.dao;

import java.util.List;

import com.soft.ProductManager.dao.Entity.Product;



public interface ProductDAO {
	
	public void add(Product e);
	
	public Product edit(Product e);
	
	public void  delete(Long id);
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	

}
