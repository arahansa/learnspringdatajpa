package com.example.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int price;

	@ManyToMany
	@JoinTable(name = "BOOK_CATEGORY", 
	joinColumns =@JoinColumn(name = "BOOK_ID_FRK"),
	inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID_FPK"))
	private Set<Category> categories = new HashSet<Category>();

	
	
	public Book() {
	}
	
	public Book(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
