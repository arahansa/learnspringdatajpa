package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class JustOne {

	@Id // 주키생성 
	@GeneratedValue //자동생성. 자세한 것은 API 혹은 서적 참고
	private Long id;
	
	@Column(name="msg" , length=100) //테이블에 저장될 때 컬럼네임 msg, 길이 100
	private String message;
	
	@Temporal(TemporalType.DATE) //날짜 저장형식. type 에 date, time, timestamp
	private Date dateJoin;
	
	@Enumerated // enum 저장 형식. 자세한 것은 API 혹은 서적 참고
	private JustOneEnum enumOne;

	@Transient // transient 는 저장하지 않습니다.
	private String passwordConfirm;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(Date dateJoin) {
		this.dateJoin = dateJoin;
	}

	public JustOneEnum getEnumOne() {
		return enumOne;
	}

	public void setEnumOne(JustOneEnum enumOne) {
		this.enumOne = enumOne;
	}
	
	
	
}
