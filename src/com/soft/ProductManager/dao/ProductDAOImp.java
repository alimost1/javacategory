package com.soft.ProductManager.dao;

import java.util.List;

import org.hibernate.Session;



import com.soft.ProductManager.dao.Entity.Product;
import com.soft.ProductManager.util.HibernateUtil;



public class ProductDAOImp implements ProductDAO {
	
	Session session = HibernateUtil.openSession();


	@Override
	    public void add(Product e) {
		try {
	        session.getTransaction().begin();
			session.save(e);
			session.getTransaction().commit();
		}
		catch (RuntimeException ex) {
		    session.getTransaction().rollback();
		}

	

	}

	@Override
	public Product edit(Product e) {
		session.getTransaction().begin();
		Product p = (Product) session.merge(e);
		session.getTransaction().commit();
		return p;
		
	}

	@Override
	public void delete(Long id) {
		try {
			session.getTransaction().begin();
			Product p = findById(id);
			session.delete(p);
			session.getTransaction().commit();
		}
		catch (RuntimeException ex) {
		    session.getTransaction().rollback();
		}
	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return session.createQuery("from  Product ").list();

	}

	@Override
	public Product findById(Long id) {
		
		return (Product) session.get(Product.class, id);
        
	}
	
	

}
