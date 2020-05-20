package com.banksystem.entity;

import java.sql.Date;

/**
 * Personinfo entity.
 */

public class Personinfo implements java.io.Serializable {

	private Integer id;
	private Account account;
	private String realname;
	private Integer age;
	private String sex;
	private Long cardid;
	private String address;
	private String telephone;
	private Date birthday;
	private String email;
	private String secucode;
	public Personinfo() {
		super();
	}
	public Personinfo(Account account, String realname, Integer age, String sex, Long cardid, String address,
			String telephone, Date birthday, String email, String secucode) {
		super();
		this.account = account;
		this.realname = realname;
		this.age = age;
		this.sex = sex;
		this.cardid = cardid;
		this.address = address;
		this.telephone = telephone;
		this.birthday = birthday;
		this.email = email;
		this.secucode = secucode;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Long getCardid() {
		return cardid;
	}
	public void setCardid(Long cardid) {
		this.cardid = cardid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSecucode() {
		return secucode;
	}
	public void setSecucode(String secucode) {
		this.secucode = secucode;
	}
	
}