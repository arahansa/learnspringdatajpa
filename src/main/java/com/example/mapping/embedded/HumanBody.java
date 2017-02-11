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
@lombok.Data
public class HumanBody {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="ownername")
	private String ownerName;
	
	@Embedded
	@AttributeOverrides({
					@AttributeOverride(name="kneePowerLeft", column=@Column(name="kneepowerleft1")),
					@AttributeOverride(name="kneePowerRight", column=@Column(name="kneepowerright2")),
	})
	private Leg leg1;

	@Embedded
	@AttributeOverrides({
					@AttributeOverride(name="kneePowerLeft", column=@Column(name="kneepowerleft3")),
					@AttributeOverride(name="kneePowerRight", column=@Column(name="kneepowerright4")),
	})
	private Leg leg2;
	
	

	public HumanBody(Long id, String ownerName, Leg leg1) {
		super();
		this.id = id;
		this.ownerName = ownerName;
		this.leg1 = leg1;
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


	
	
	
}
