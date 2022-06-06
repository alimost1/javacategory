package com.soft.ProductManager.dao.Entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	private Double price ;
	private String active;
	@Column(name="id_category")
	private Long categoryId;
	
	@ManyToOne
	@JoinColumn(name="id_category",referencedColumnName="id",insertable=false, updatable=false)
	private Category category;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Product(String name, Double price, String active, Long categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.active = active;
		this.categoryId = categoryId;
	}









	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public Double getPrice() {
		return price;
	}




	public void setPrice(Double price) {
		this.price = price;
	}




	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	public Long getId_category() {
		return getId_category();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

   
	


}