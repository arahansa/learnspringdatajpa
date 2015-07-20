package com.example.mapping.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//I had to make class quickly. naming is not good^^;; excuse me. hehe.

@Entity
public class HumanBody {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="ownername")
	private String ownerName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="myleftkneepower", column=@Column(name="kneepowerleft")),
		@AttributeOverride(name="myrightkneepower", column=@Column(name="kneepowerright")),
	})
	private Leg leg;
	
	

	public HumanBody(Long id, String ownerName, Leg leg) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.leg = leg;
	}

	public HumanBody() {
		
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	public Leg getLeg()
	{
		return leg;
	}

	public void setLeg(Leg leg)
	{
		this.leg = leg;
	}

	@Override
	public String toString()
	{
		return "Body [id=" + id + ", ownerName=" + ownerName + ", leg=" + leg
				+ "]";
	}
	
	
	
}
