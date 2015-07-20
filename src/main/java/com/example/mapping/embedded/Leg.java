package com.example.mapping.embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Leg {

	@Column(name="kneepowerleft")
	private int kneePowerLeft;
	
	
	@Column(name="kneepowerright")
	private int kneePowerRight;


	public int getKneePowerLeft()
	{
		return kneePowerLeft;
	}


	public void setKneePowerLeft(int kneePowerLeft)
	{
		this.kneePowerLeft = kneePowerLeft;
	}


	public int getKneePowerRight()
	{
		return kneePowerRight;
	}


	public void setKneePowerRight(int kneePowerRight)
	{
		this.kneePowerRight = kneePowerRight;
	}


	@Override
	public String toString()
	{
		return "Leg [kneePowerLeft=" + kneePowerLeft + ", kneePowerRight="
				+ kneePowerRight + "]<br>";
	}
	
	
	
	
	
	
}
