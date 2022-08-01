package com.example.collegemodule;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College {

	int id;
	String user;
	String collegename;
	String location;
	
	public College() {
		super();
	}

	public College(int id, String user, String collegename, String location) {
		super();
		this.id = id;
		this.user = user;
		this.collegename = collegename;
		this.location = location;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "College [id=" + id + ", user=" + user + ", collegename=" + collegename + ", location=" + location + "]";
	}
	
	
	
}
