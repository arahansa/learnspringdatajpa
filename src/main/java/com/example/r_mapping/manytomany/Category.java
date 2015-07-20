package com.example.r_mapping.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category{
	@ManyToMany
	@JoinTable(name = "BOOK_CATEGORY", 
	joinColumns= @JoinColumn(name = "CATEGORY_ID_FPK"),
	inverseJoinColumns=@JoinColumn(name = "BOOK_ID_FRK"))
	private Set<Book> books = new HashSet<Book>();
	

	@Id @GeneratedValue
	private Long id;
	private String name;
	
	

	public Category() {
	}
	
	public Category(String name) {
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

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]"+"<br>"+
					"(ManyTomany)"+getBooks();
	}
	
	
	
}
