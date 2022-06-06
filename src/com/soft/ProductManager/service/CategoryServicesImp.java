package com.soft.ProductManager.service;

import java.util.List;
import com.soft.ProductManager.dao.CategoryDAO;
import com.soft.ProductManager.dao.CategoryDAOImp;
import com.soft.ProductManager.dao.Entity.Category;

public class CategoryServicesImp implements CategoryServices  {
	
	CategoryDAO dao = new CategoryDAOImp();

	@Override
	public void add(Category e) {
		
		 dao.add(e);	
		
	}

	@Override
	public Category edit(Category e) {
		
		return dao.edit(e);
	}

	@Override
	public void delete(Long id) {
		
		 dao.delete(id);
	}

	@Override
	public List<Category> findAll() {
		
		return dao.findAll();
	
	}

	@Override
	public Category findById(Long id) {
		
		return dao.findById(id);
	}

}