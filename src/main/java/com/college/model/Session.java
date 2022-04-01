package com.college.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="Session")

public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionid;
	private String sessionname;
	private String sessiondescription;
	private Integer sessionlength;
	
	
	
	@ManyToMany
	@JoinTable(name="Session_Speaker",joinColumns = @JoinColumn(name="sessionid"),
	inverseJoinColumns = @JoinColumn(name="speakerid"))
	
	private List<Speaker> speakers;
	

	public Long getSessionid() {
		return sessionid;
	}

	public void setSessionid(Long sessionid) {
		this.sessionid = sessionid;
	}

	public String getSessionname() {
		return sessionname;
	}

	public void setSessionname(String sessionname) {
		this.sessionname = sessionname;
	}

	public String getSessiondescription() {
		return sessiondescription;
	}

	public void setSessiondescription(String sessiondescription) {
		this.sessiondescription = sessiondescription;
	}

	public Integer getSessionlength() {
		return sessionlength;
	}

	public void setSessionlength(Integer sessionlength) {
		this.sessionlength = sessionlength;
	}

	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}

	@Override
	public String toString() {
		return "Session [sessionid=" + sessionid + ", sessionname=" + sessionname + ", sessiondescription="
				+ sessiondescription + ", sessionlength=" + sessionlength + ", speakers=" + speakers + "]";
	}
	
	

}
