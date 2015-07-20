package com.example.mapping.inheritance.singletable;

import javax.persistence.Entity;

@Entity
public class Lion  extends Animal{
	private String nameFood;

	public Lion() {
	
	}
	public Lion(String nameFood) {
		super();
		this.nameFood = nameFood;
	}

	public String getNameFood()
	{
		return nameFood;
	}

	public void setNameFood(String nameFood)
	{
		this.nameFood = nameFood;
	}
	@Override
	public String toString()
	{
		return super.toString()+"and Lion [nameFood=" + nameFood + "]<br>";
	}
	
	
	
	
}
