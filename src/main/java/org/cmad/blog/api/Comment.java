package org.cmad.blog.api;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name="COMMENT")
public class Comment {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMMENT_ID")
	private int id;
	
	@Column(name="COMMENT_DESC")
	private String commentDesc;
	
	@Column(name="COMMENT_CREATION_TIME")
//	@Temporal(value = TemporalType.TIMESTAMP)
	private String creationTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AppUser byUser;
	
	public Comment(){
		
	}
	public Comment(String comment,String createdTime,AppUser user){
		super();
		this.commentDesc=comment;
		this.creationTime=createdTime;
		this.byUser = user;
	}
	
	public Comment(int id, String comment,String createdTime,AppUser user){
		this(comment,createdTime,user);
		this.id=id;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommentDesc() {
		return commentDesc;
	}
	public void setCommentDesc(String comment) {
		this.commentDesc = comment;
	}

	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public AppUser getByUser() {
		return byUser;
	}
	public void setByUser(AppUser byUser) {
		this.byUser = byUser;
	}
	
}
