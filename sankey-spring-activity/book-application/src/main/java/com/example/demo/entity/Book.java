package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "BOOK_TBL")
public class Book {
	@Id
	@GeneratedValue
	private int id;
     
	@Column(unique=true)
	private String name;
	
	private int quantity;
	private String genre;
	private boolean isBestSeller;
	 
	
	
	private Date createdAt= new Date(System.currentTimeMillis());
	
	private Date updatedAt = new Date(System.currentTimeMillis());;
	
	
	public Book() {
		super();
	}
	

	public Book(int id, String name, int quantity, String genre, boolean isBestSeller, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		
		this.name = name;
		this.quantity = quantity;
		this.genre = genre;
		this.isBestSeller = isBestSeller;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isBestSeller() {
		return isBestSeller;
	}

	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	

	

}
