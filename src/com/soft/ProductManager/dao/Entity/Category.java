package com.soft.ProductManager.dao.Entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id 
	private Long id;
	
	@Column
	private String categoryname;
	private String active;
	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    

	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String name) {
		this.categoryname = name;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Category( String categoryname, String active) {
		super();
		this.categoryname = categoryname;
		this.active = active;
	}
	
	


}