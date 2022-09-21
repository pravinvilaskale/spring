package com.example.product;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voting {
	
	int id;
	String username;
	String password;
	String email;
	Integer phone;
	String type;
	Integer vote;
	
	
	public Voting() {
		super();
	}


	public Voting(int id, String username, String password, String email, Integer phone, String type, Integer vote) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.vote = vote;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getPhone() {
		return phone;
	}


	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getVote() {
		return vote;
	}


	public void setVote(Integer vote) {
		this.vote = vote;
	}


	@Override
	public String toString() {
		return "Voting [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", type=" + type + ", vote=" + vote + "]";
	}
	
}
