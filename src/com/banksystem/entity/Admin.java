package com.banksystem.entity;

/**
 * Admin entity. 
 */

public class Admin implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private String secucode;
	public Admin() {
		super();
	}
	public Admin(String username, String password, String secucode) {
		super();
		this.username = username;
		this.password = password;
		this.secucode = secucode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getSecucode() {
		return secucode;
	}
	public void setSecucode(String secucode) {
		this.secucode = secucode;
	}
	
}