package com.example.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tags {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nametag;
	
	
	
	
}
