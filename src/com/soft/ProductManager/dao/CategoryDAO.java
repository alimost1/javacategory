package com.soft.ProductManager.dao;

import java.util.List;

import com.soft.ProductManager.dao.Entity.Category;



public interface CategoryDAO {
	
	public void add(Category e);
	
	public Category edit(Category e);
	
	public void  delete(Long id);
	
	public List<Category> findAll();
	
	public Category findById(Long id);
	
	

}
