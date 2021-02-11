package com.greedy.semi.member.model.dto;

import java.sql.Date;

public class MemberDTO implements java.io.Serializable {

	private int no;
	private String email;
	private String pwd;
	private String name;
	private String phone;
	private java.sql.Date enroll_date;
	private java.sql.Date modified_Date;
	private String black_status;
	private String role;
	private String status;
	
	public MemberDTO() {}

	public MemberDTO(int no, String email, String pwd, String name, String phone, Date enroll_date, Date modified_Date,
			String black_status, String role, String status) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.enroll_date = enroll_date;
		this.modified_Date = modified_Date;
		this.black_status = black_status;
		this.role = role;
		this.status = status;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public java.sql.Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(java.sql.Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public java.sql.Date getModified_Date() {
		return modified_Date;
	}

	public void setModified_Date(java.sql.Date modified_Date) {
		this.modified_Date = modified_Date;
	}

	public String getBlack_status() {
		return black_status;
	}

	public void setBlack_status(String black_status) {
		this.black_status = black_status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", email=" + email + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", enroll_date=" + enroll_date + ", modified_Date=" + modified_Date + ", black_status=" + black_status
				+ ", role=" + role + ", status=" + status + "]";
	}
	
	
}
