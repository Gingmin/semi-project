package com.greedy.semi.admin.model.dto;

import java.sql.Date;

public class AmountDTO implements java.io.Serializable {

	private int no;
	private int amount;
	private java.sql.Date expDate;
	
	public AmountDTO() {}

	public AmountDTO(int no, int amount, Date expDate) {
		super();
		this.no = no;
		this.amount = amount;
		this.expDate = expDate;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public java.sql.Date getExpDate() {
		return expDate;
	}

	public void setExpDate(java.sql.Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "AmountDTO [no=" + no + ", amount=" + amount + ", expDate=" + expDate + "]";
	}
	
	
	
}
