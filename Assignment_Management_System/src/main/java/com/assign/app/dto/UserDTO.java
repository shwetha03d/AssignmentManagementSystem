package com.assign.app.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_table")
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="FIRST_NAME")
	private String fName;
	@Column(name="LAST_NAME")
	private String lName;
	@Column(name="COUNTRY_CODE")
	private String cCode;
	@Column(name="MOBILE_NUMBER")
	private long mobileNo;
	@Id
	@Column(name="EMAIL_ID")
	private String email;
	@Column(name="NEW_USER")
	private boolean newUser;
	@Column(name="PASSWORD")
	private String password;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isNewUser() {
		return newUser;
	}
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDTO [fName=" + fName + ", lName=" + lName + ", cCode=" + cCode + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", newUser=" + newUser + ", password=" + password + "]";
	}
}
