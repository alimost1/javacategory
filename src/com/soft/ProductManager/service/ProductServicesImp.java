package com.soft.ProductManager.service;

import java.util.List;
import com.soft.ProductManager.dao.ProductDAO;
import com.soft.ProductManager.dao.ProductDAOImp;
import com.soft.ProductManager.dao.Entity.Product;

public class ProductServicesImp implements PoductServices  {
	
	ProductDAO dao = new ProductDAOImp();

	@Override
	public void add(Product e) {
		
		 dao.add(e);	
		
	}

	@Override
	public Product edit(Product e) {
		
		return dao.edit(e);
	}

	@Override
	public void delete(Long id) {
		
		 dao.delete(id);
	}

	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	
	}

	@Override
	public Product findById(Long id) {
		
		return dao.findById(id);
	}

}
