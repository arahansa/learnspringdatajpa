package com.example.mapping.inheritance.join;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("sk")
public class SkPlayer extends BaseBallPlayer {

	
	
	private int incheonPower;


	public int getIncheonPower()
	{
		return incheonPower;
	}

	public void setIncheonPower(int incheonPower)
	{
		this.incheonPower = incheonPower;
	}

	@Override
	public String toString()
	{
		return super.toString() + " and SkPlayer [incheonPower=" + incheonPower
				+ "]<Br>";
	}

}
