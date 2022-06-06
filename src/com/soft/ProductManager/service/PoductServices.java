package com.soft.ProductManager.service;

import java.util.List;

import com.soft.ProductManager.dao.Entity.Product;

public interface PoductServices {
	

	public void add(Product e);
	
	public Product edit(Product e);
	
	public void  delete(Long id);
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	

}
