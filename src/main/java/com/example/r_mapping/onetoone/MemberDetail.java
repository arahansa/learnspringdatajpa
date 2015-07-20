package com.example.r_mapping.onetoone;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class MemberDetail {
	@OneToOne(mappedBy="memberDetail")
	private Member member;
	
	
	@Id	@GeneratedValue
	private Long id;

	
	private String address;

	@Lob	@Basic
	private byte[] picture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "MemberDetail [id=" + id + ", picture=" + Arrays.toString(picture) + "]";
	}

}
