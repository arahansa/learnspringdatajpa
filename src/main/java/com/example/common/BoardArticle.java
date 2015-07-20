package com.example.common;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.example.mapping.mappedsuperclass.BaseEntity;

@Entity
public class BoardArticle{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String content;
	
	@Column(name="numread")
	private int numRead;
	
	@Column(name = "creation_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @Column(name = "modification_time", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modificationTime;

    @Version
    private long version;
    
    // 주의... cascade 타입 주의. 토이프로그램임. 
    @ManyToOne (cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
    private User user;
    
    
    @OneToMany(targetEntity=Comment.class,
    		mappedBy="article",
    		cascade=CascadeType.ALL,
    		fetch=FetchType.LAZY
    		)
    private List<Comment> comments;
    
    
    
    public BoardArticle() {
	}
    public BoardArticle(Long id){
    	this.id =id;
    }
    
    public BoardArticle(String nick, String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
    
    

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getNumRead()
	{
		return numRead;
	}

	public void setNumRead(int numRead)
	{
		this.numRead = numRead;
	}

	public DateTime getCreationTime()
	{
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime)
	{
		this.creationTime = creationTime;
	}

	public DateTime getModificationTime()
	{
		return modificationTime;
	}

	public void setModificationTime(DateTime modificationTime)
	{
		this.modificationTime = modificationTime;
	}

	public long getVersion()
	{
		return version;
	}

	public void setVersion(long version)
	{
		this.version = version;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	
	
	
	

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	@PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        this.creationTime = now;
        this.modificationTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationTime = DateTime.now();
    }

	@Override
	public String toString()
	{
		return "BoardArticle [id=" + id + ", title=" + title
				+ ", content=" + content + ", numRead=" + numRead
				+ ", creationTime=" + creationTime + ", modificationTime="
				+ modificationTime + ", version=" + version + "]<br>"
						+ "<a href=\"/commonBoard/"+id+"\"><button>글읽기</button><br><a/>";
	}
    
	
	public String toStringAll()
	{
		return "BoardArticle [id=" + id + ", title=" + title
				+ ", content=" + content + ", numRead=" + numRead
				+ ", creationTime=" + creationTime + ", modificationTime="
				+ modificationTime + ", version=" + version + "]<br>"+ getComments()  +"<br>"
				+ getUser() +"<br>"
				+ "<hr>댓글작성 : <form action=\"/commonBoard/"+id+"\" method=\"post\">"
						+ "사용자 정보: <input type=\"text\" name=\"nick\" placeholder=\"닉네임\">"
			+ "<input type=\"text\" name=\"age\" placeholder=\"나이\">"
			+"<br><input type=\"text\" name=\"reply\"><input type='submit' value='전송'></form>";
	}
	

}
