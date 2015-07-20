package com.example.etc.validation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class DressOrder {

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String name;

	@Email
	@NotEmpty
	private String email;

	@Digits(fraction = 2, integer = 2)
	private Integer size;

	@Max(10)
	private String address;

	public DressOrder() {

	}

	public DressOrder(String name, String email, Integer size, String address) {
		super();
		this.name = name;
		this.email = email;
		this.size = size;
		this.address = address;
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

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Integer getSize()
	{
		return size;
	}

	public void setSize(Integer size)
	{
		this.size = size;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "DressOrder [id=" + id + ", name=" + name + ", email=" + email
				+ ", size=" + size + ", address=" + address + "]<br>";
	}

	
	
}
