package com.example.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class University{
	@Id 
	private Long id;
	private String name;
	@OneToMany(
			targetEntity=Student.class, 
			mappedBy="university",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY)
	private List<Student> students;
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + "]";
	}
	
	public String toStringPlusStudents(){
		StringBuilder builder = new StringBuilder();
		builder.append("University [id=" + id + ", name=" + name + "]<br>");
		builder.append("Students <Br>");
		builder.append("====================<br>");
		for (Student student : students) 
			builder.append(student.toString()+"<br>");
		builder.append("================<br>");
		builder.append("Complete");
		return builder.toString();
	}
	
	
	
}
