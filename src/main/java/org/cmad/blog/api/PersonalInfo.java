package org.cmad.blog.api;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/*@Entity
@XmlRootElement*/
@Embeddable
public class PersonalInfo {

//	@Id
	@Column(name="USER_NAME")
	private String name;
	
	@Column(name="PHONE_NO")
	private String phoneNum;
	
	@Column(name="USER_DOB")
//	@Temporal(value = TemporalType.TIMESTAMP)
	private String dob;
	
	/*@Column(name="REG_TIME")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date registeredTime;*/
	
	public PersonalInfo(){
		
	}
	
	public PersonalInfo(String name, String phoneNum, String dob) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
/*	public Date getRegisteredTime() {
		return registeredTime;
	}
	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}*/

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
}
