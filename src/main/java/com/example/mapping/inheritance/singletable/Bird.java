package com.example.mapping.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class Bird extends Animal{

	private String nameNest;

	public String getNameNest()
	{
		return nameNest;
	}

	public void setNameNest(String nameNest)
	{
		this.nameNest = nameNest;
	}

	@Override
	public String toString()
	{
		return super.toString()+"and  Bird [nameNest=" + nameNest + "]+<br>";
	}
	
	
	
	
}
