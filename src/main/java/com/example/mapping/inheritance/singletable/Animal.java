package com.example.mapping.inheritance.singletable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Animal {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	
	
	public Animal() {
	}
	public Animal(String name) {
		super();
		this.name = name;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	@Override
	public String toString()
	{
		return "Animal [id=" + id + ", name=" + name + "]";
	}
	
	

}
