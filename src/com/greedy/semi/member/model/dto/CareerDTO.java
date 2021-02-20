package com.greedy.semi.member.model.dto;

import java.sql.Date;

public class CareerDTO implements java.io.Serializable {

	private int no;
	private String placeWork;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private String empStatus;
	
	public CareerDTO() {}

	public CareerDTO(int no, String placeWork, Date startDate, Date endDate, String empStatus) {
		super();
		this.no = no;
		this.placeWork = placeWork;
		this.startDate = startDate;
		this.endDate = endDate;
		this.empStatus = empStatus;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPlaceWork() {
		return placeWork;
	}

	public void setPlaceWork(String placeWork) {
		this.placeWork = placeWork;
	}

	public java.sql.Date getStartDate() {
		return startDate;
	}

	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}

	public java.sql.Date getEndDate() {
		return endDate;
	}

	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "CareerDTO [no=" + no + ", placeWork=" + placeWork + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", empStatus=" + empStatus + "]";
	}
	
	
	
}
