package com.example.mapping.inheritance.join;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "person_id")
public class HanWhaPlayer extends BaseBallPlayer {

	private int eaglesPower;
	
	
	public int getEaglesPower()
	{
		return eaglesPower;
	}

	public void setEaglesPower(int eaglesPower)
	{
		this.eaglesPower = eaglesPower;
	}

	@Override
	public String toString()
	{
		return super.toString() + " and HanWhaPlayer [eaglesPower="
				+ eaglesPower + "]<br>";
	}

}
