package com.example.mapping.inheritance.perclass;

import javax.persistence.Entity;

@Entity
public class PrivateProject extends Project{

	private String projectManager;

	public String getProjectManager()
	{
		return projectManager;
	}

	public void setProjectManager(String projectManager)
	{
		this.projectManager = projectManager;
	}

	@Override
	public String toString()
	{
		return super.toString()+" and PrivateProject [projectManager=" + projectManager + "]<Br>";
	}
	
	
	
	
}
