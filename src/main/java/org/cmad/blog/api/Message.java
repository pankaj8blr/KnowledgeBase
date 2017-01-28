package org.cmad.blog.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table (name="MESSAGE")
public class Message {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MESSAGE_ID")
	private int messageID;
	
	@Column(name="MESSAGE_DESC")
	private String messageDesc;
	
	public Message(){
		
	}
	public Message(String messageDesc) {
		super();
		this.messageDesc = messageDesc;
	}
	public Message(int messageID, String messageDesc) {
		this(messageDesc);
		this.messageID = messageID;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public String getMessageDesc() {
		return messageDesc;
	}
	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
	
}
