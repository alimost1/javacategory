package com.soft.ProductManager.dao;

import java.util.List;

import org.hibernate.Session;

import com.soft.ProductManager.dao.Entity.Category;
import com.soft.ProductManager.util.HibernateUtil;

public class CategoryDAOImp implements CategoryDAO {

	Session session = HibernateUtil.openSession();
	@Override
	public void add(Category e) {
	session.getTransaction().begin();
	session.save(e);
	session.getTransaction().commit();
	

	}

	@Override
	public Category edit(Category e) {
		session.getTransaction().begin();
		Category p = (Category) session.merge(e);
		session.getTransaction().commit();
		
			return p;
	}

	@Override
	public void delete(Long id) {
		session.getTransaction().begin();
		Category p = findById(id);
		session.delete(p);
		session.getTransaction().commit();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		session.getTransaction().begin();
		return session.createQuery(" from Category").list();
	
	}

	@Override

	public Category findById(Long id) {
		return (Category) session.get(Category.class, id);
	}
	
	

}