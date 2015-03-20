package com.example.onetomany;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student{

	@Id @GeneratedValue
	private Long id;
	private String name;
	private String numPhone;
	@ManyToOne 
	@JoinColumn(name="university_id")
	private University university;
	
	public Student() {
	}
	public Student(String name, String numPhone, University university) {
		super();
		this.name = name;
		this.numPhone = numPhone;
		this.university = university;
	}


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
	public String getNumPhone() {
		return numPhone;
	}
	public void setNumPhone(String numPhone) {
		this.numPhone = numPhone;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", numPhone=" + numPhone + "]";
	}
	
	
}
