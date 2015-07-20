package com.example.mapping.mappedsuperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MappedSupper extends BaseEntity<Long> {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Override
	public Long getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return super.toString()+ "and MappedSupper [id=" + id + ", name=" + name + "]<br>";
	}

}
