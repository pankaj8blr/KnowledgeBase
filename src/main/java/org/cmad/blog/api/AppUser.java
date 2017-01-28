package org.cmad.blog.api;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name="APPUSER")
public class AppUser {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPUSER_ID",nullable=false/*, unique=true*/)
	private int appUserId;
	
	@Column(name="EMAIL_ID",nullable=false/*, unique=true*/)
	private String email;
	
	@Column(name="APPUSER_PASSWORD",nullable=false, unique=false)
	private String password;
	
	@Embedded
//	@OneToOne(cascade = CascadeType.ALL)
	private PersonalInfo personalInfo;
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="USER_TOPIC",joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="TOPIC_ID")
	)
	private Topic topic;*/
	
	@Column(name="USER_INTERESTED_TOPIC",nullable=false)
	private String userInterestedTopic;
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USER_POST",joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="POST_ID")
	)
	private Collection<Post> post = new ArrayList<Post>();*/
	
	

	
	public AppUser(){
		
	}

	public AppUser(String email,PersonalInfo personalInfo, String userInterestedTopic) {
		super();
		this.email = email;
		this.personalInfo = personalInfo;
		this.userInterestedTopic = userInterestedTopic;
	}
	
	

	public AppUser(String email, String password, PersonalInfo personalInfo,  String userInterestedTopic) {
		super();
		this.email = email;
		this.password = password;
		this.personalInfo = personalInfo;
		this.userInterestedTopic = userInterestedTopic;
	}
	
	public AppUser(int appUserId,String email, String password, PersonalInfo personalInfo, String interestedTopic) {
		this(email,password,personalInfo,interestedTopic);
		this.appUserId = appUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	/*public Topic getInterests() {
		return topic;
	}

	public void setInterests(Topic interests) {
		this.topic = interests;
	}*/

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}
	
	public String getUserInterestedTopic() {
		return userInterestedTopic;
	}

	public void setUserInterestedTopic(String userInterestedTopic) {
		this.userInterestedTopic = userInterestedTopic;
	}

	/*public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}*/
	
/*	public Collection<Post> getPost() {
		return post;
	}

	public void setPost(Collection<Post> post) {
		this.post = post;
	}*/
}
