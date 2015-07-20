package com.example.common;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	private String reply;
	
	private int numlike;
	
	
	@ManyToOne 
	@JoinColumn(name="article_id")
	private BoardArticle article;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getComment()
	{
		return reply;
	}

	public void setComment(String comment)
	{
		this.reply = comment;
	}

	public int getNumlike()
	{
		return numlike;
	}

	public void setNumlike(int numlike)
	{
		this.numlike = numlike;
	}

	public BoardArticle getArticle()
	{
		return article;
	}

	public void setArticle(BoardArticle article)
	{
		this.article = article;
	}
	
	

	public String getReply()
	{
		return reply;
	}

	public void setReply(String reply)
	{
		this.reply = reply;
	}

	@Override
	public String toString()
	{
		return "Comment [id=" + id + ", comment=" + reply + ", numlike="
				+ numlike + "]<br>";
	}
	
	
	
	
	
	
	
	
	
	
}
