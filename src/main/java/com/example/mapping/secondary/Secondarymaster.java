package com.example.mapping.secondary;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name="sub1secondary", pkJoinColumns=@PrimaryKeyJoinColumn(
		name="SECONDARYMASTER_ID_FPK", referencedColumnName="SECONDARYMASTER_ID_PK"
		)
)
public class Secondarymaster {
	
	@Id
	@GeneratedValue
	@Column(name="SECONDARYMASTER_ID_PK")
	private Long id;
	
	@Basic(fetch=FetchType.LAZY) 
	//lazy로 불러오는 게 안되나? 쿼리보니깐..음..다 불러오는 것같은데..?
	@Column(table="sub1secondary", name="sub1")
	private String sub1;

	@Column(name="sub2")
	private String sub2;
	
	public Secondarymaster() {
	
	}
	
	
	

	public Secondarymaster(String sub1, String sub2) {
		super();
		this.sub1 = sub1;
		this.sub2 = sub2;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getSub1()
	{
		return sub1;
	}

	public void setSub1(String sub1)
	{
		this.sub1 = sub1;
	}

	public String getSub2()
	{
		return sub2;
	}

	public void setSub2(String sub2)
	{
		this.sub2 = sub2;
	}

	@Override
	public String toString()
	{
		return "Secondarymaster [id=" + id + ", sub1=" + sub1 + ", sub2="
				+ sub2 + "]<br>";
	}
	
	
}
