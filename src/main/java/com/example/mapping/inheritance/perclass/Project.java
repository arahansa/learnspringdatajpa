package com.example.mapping.inheritance.perclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Project {

	private Long projectId;
	private String projectName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString()
	{
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + "]";
	}
	
	
}