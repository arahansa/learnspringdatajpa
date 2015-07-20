package com.example.common;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nick;
	
	private int age;
	
	@OneToMany(
			targetEntity=BoardArticle.class,
			mappedBy="user",
			cascade=CascadeType.ALL,
			fetch=FetchType.LAZY
			)
	private List<BoardArticle> articles;
	
	@OneToMany(targetEntity=User.class,
			mappedBy="user")
	private List<Comment> comments;
	

	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNick()
	{
		return nick;
	}

	public void setNick(String nick)
	{
		this.nick = nick;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public List<BoardArticle> getArticles()
	{
		return articles;
	}

	public void setArticles(List<BoardArticle> articles)
	{
		this.articles = articles;
	}
	
	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", nick=" + nick + ", age=" + age
				+ "]";
	}
	
	public String toStringAll(){
		return "";
	}
	
	
	
	
	
	
	
}
