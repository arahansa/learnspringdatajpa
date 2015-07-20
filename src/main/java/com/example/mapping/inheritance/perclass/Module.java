package com.example.mapping.inheritance.perclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Module extends Project{
	
	private String moduleName;

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString()
	{
		return super.toString()+" and Module [moduleName=" + moduleName + "]<br>";
	}
	
	
	
}