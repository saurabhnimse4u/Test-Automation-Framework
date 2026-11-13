package com.ui.pojo;

public class User {
	
	private String email;
	private String pass;
	private String username;

	public User(String email, String pass, String username) {
		super();
		this.email = email;
		this.pass = pass;
		this.username=username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", pass=" + pass + ", username=" + username + "]";
	}
}
