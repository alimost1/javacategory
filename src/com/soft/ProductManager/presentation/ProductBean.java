package com.soft.ProductManager.presentation;

import com.soft.ProductManager.dao.Entity.Product;
import com.soft.ProductManager.dao.Entity.Category;

//import com.soft.ProductManager.dao.ProductDAO;
//import com.soft.ProductManager.dao.ProductDAOImp;

import com.soft.ProductManager.service.CategoryServices;
import com.soft.ProductManager.service.CategoryServicesImp;

import com.soft.ProductManager.service.PoductServices;
import com.soft.ProductManager.service.ProductServicesImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean(name = "productBean2")
@RequestScoped

public class ProductBean {

	private PoductServices productServices = new ProductServicesImp();
	private CategoryServices categoryServices = new CategoryServicesImp();

	private String name;
	private String price;
	private String category;
	private String active;
	private String id;
	private String operation;
	private Boolean showForm=true;
	private List<Product> productlist;
	private List<SelectItem> categorylist;
	
	

@PostConstruct
	public void initBean() {
	  
	
	  
		categorylist = new ArrayList<>();
		categorylist.add(new SelectItem("",""));
		
		List<Category> listServices = categoryServices.findAll();
		
		for(Category o:listServices){
			
			categorylist.add(new SelectItem(o.getId(),o.getCategoryname()));
		}
		productlist = productServices.findAll();
		
		
		
		if ("edit".equalsIgnoreCase(getParam("operation"))) {
			setOperation(getParam("operation"));
			Long id = null;
			Product product = null;
			try {
				id = Long.valueOf(getParam("id"));
				setId(getParam("id"));

			} catch (Exception e) {

				if (id != null) {
					product = productServices.findById(id);

					if (product != null) {
						name = product.getName();
						if (product.getPrice() != null) {

							price = product.getPrice().toString();
						}
						category = product.getCategoryId() + "";
						active = product.getActive();
						showForm = true;

					}

				}

			}
		}


}
		



	public void ddproduct(ActionEvent e) {
		
	
		Product p = null;
		if("edit".equalsIgnoreCase(operation)) {
			p = productServices.findById(new Long(id));
			
		}
		else {
			p= new Product ();
			
		}
		
		p.setName(name);
		p.setPrice(Double.valueOf(price));
		p.setCategoryId(Long.valueOf(category));
		p.setActive(active);
		
		productServices.add(p);
		
		
		
		
		name = "";
	    price= "";
		category= "";
		active= "";
		id= "";
		operation="";
		
	
		productlist = productServices.findAll();
		
	}

	public void deletProduct(ActionEvent e) {

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();

		productServices.delete(new Long(param.get("id")));
		
		productlist = productServices.findAll();
        


	}
	
	public String getParam(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		return params.get(name);
		
	}

	
	public void showFormAction (ActionEvent e) {
		showForm =true; 
	}
	
	public void HidFormAction (ActionEvent e) {
		showForm =false ; 
	}



	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoductServices getProductServices() {
		return productServices;
	}

	public void setProductServices(PoductServices productServices) {
		this.productServices = productServices;
	}

	public CategoryServices getCategoryServices() {
		return categoryServices;
	}

	public void setCategoryServices(CategoryServices categoryServices) {
		this.categoryServices = categoryServices;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

	public List<SelectItem> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<SelectItem> categorylist) {
		this.categorylist = categorylist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Boolean getShowForm() {
		return showForm;
	}

	public void setShowForm(Boolean showForm) {
		this.showForm = showForm;
	}
	
	
	
	
   
}
