package com.college.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity (name="Speaker")
public class Speaker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long speakerid;
	private String firstname;
	private String Lastname;
	private String title;
	private String Company;
	private String speakerbiodata;
	
	@ManyToMany(mappedBy = "speakers")
	private List<Session> sessions;

	public Long getSpeakerid() {
		return speakerid;
	}

	public void setSpeakerid(Long speakerid) {
		this.speakerid = speakerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getSpeakerbiodata() {
		return speakerbiodata;
	}

	public void setSpeakerbiodata(String speakerbiodata) {
		this.speakerbiodata = speakerbiodata;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return "Speaker [speakerid=" + speakerid + ", firstname=" + firstname + ", Lastname=" + Lastname + ", title="
				+ title + ", Company=" + Company + ", speakerbiodata=" + speakerbiodata + ", sessions=" + sessions
				+ "]";
	}

	
}
