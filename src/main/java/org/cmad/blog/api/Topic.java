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
@Table (name="TOPIC")
public class Topic {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TOPIC_ID")
	private int id;
	
	@Column(name="TOPIC_NAME")
	private String name;
	
	public Topic(){
		
	}
	
	public Topic(String name) {
		super();
		this.name = name;
	}
	public Topic(int id, String name) {
		this(name);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	/*public void setId(int id) {
		this.id = id;
	}*/
	public String getName() {
		return name;
	}
	/*public void setName(String name) {
		this.name = name;
	}
	*/
}
