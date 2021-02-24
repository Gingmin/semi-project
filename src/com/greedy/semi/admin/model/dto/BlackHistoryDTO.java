package com.greedy.semi.admin.model.dto;

import java.sql.Date;

public class BlackHistoryDTO implements java.io.Serializable {
	
	private int constraintNo;
	private int no;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	
	public BlackHistoryDTO() {}

	public BlackHistoryDTO(int constraintNo, int no, Date startDate, Date endDate) {
		super();
		this.constraintNo = constraintNo;
		this.no = no;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getConstraintNo() {
		return constraintNo;
	}

	public void setConstraintNo(int constraintNo) {
		this.constraintNo = constraintNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "BlackHistoryDTO [constraintNo=" + constraintNo + ", no=" + no + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	
}
