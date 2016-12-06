package com.bcbs.sentimentanalysis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USERDETAILS")
public class User implements Serializable{

	
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID" ,unique=true, nullable=false)
	private Integer id;

	@NotEmpty
	@Column(name="EMAIL", unique=true, nullable=false)
	private String email;
	
	@NotEmpty
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	
	@NotEmpty
	@Column(name="FULLNAME", nullable=false)
	private String fullName;

	@Transient
	public Integer errorcode;
	@Transient
	public String errorMessage;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Integer getErrorcode() {
		return errorcode;
	}


	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
