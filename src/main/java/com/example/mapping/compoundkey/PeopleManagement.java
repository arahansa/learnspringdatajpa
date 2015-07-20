package com.example.mapping.compoundkey;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@IdClass(ComposedIdKey.class)
public class PeopleManagement {
	@Id
	@Column(name="lastname")
	private String lastname;
	@Id
	@Column(name="firstname")
	private String firstname;
	@Id
	@Column(name="city")
	private String city;
	
	private String message;
	
	
	public PeopleManagement() {
	
	}


	public PeopleManagement(String lastname, String firstname, String city) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.city = city;
	}


	public PeopleManagement(String lastname, String firstname, String city,
			String message) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.city = city;
		this.message = message;
	}
	
	


	public String getLastname()
	{
		return lastname;
	}


	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}


	public String getFirstname()
	{
		return firstname;
	}


	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}


	public String getCity()
	{
		return city;
	}


	public void setCity(String city)
	{
		this.city = city;
	}


	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	@Override
	public String toString()
	{
		return "PeopleManagement [lastname=" + lastname + ", firstname="
				+ firstname + ", city=" + city + ", message=" + message + "]<br>";
	}
	
	
}


