package com.greedy.semi.admin.model.dto;

import java.sql.Date;

public class PurchaseProductDTO implements java.io.Serializable {

	private String purCode;
	private int no;
	private String proCode;
	private int price;
	private java.sql.Date purDate;
	private int permitNo;
	private String purStatus;
	
	public PurchaseProductDTO() {}

	public PurchaseProductDTO(String purCode, int no, String proCode, int price, Date purDate, int permitNo,
			String purStatus) {
		super();
		this.purCode = purCode;
		this.no = no;
		this.proCode = proCode;
		this.price = price;
		this.purDate = purDate;
		this.permitNo = permitNo;
		this.purStatus = purStatus;
	}

	public String getPurCode() {
		return purCode;
	}

	public void setPurCode(String purCode) {
		this.purCode = purCode;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public java.sql.Date getPurDate() {
		return purDate;
	}

	public void setPurDate(java.sql.Date purDate) {
		this.purDate = purDate;
	}

	public int getPermitNo() {
		return permitNo;
	}

	public void setPermitNo(int permitNo) {
		this.permitNo = permitNo;
	}

	public String getPurStatus() {
		return purStatus;
	}

	public void setPurStatus(String purStatus) {
		this.purStatus = purStatus;
	}

	@Override
	public String toString() {
		return "PurchaseProductDTO [purCode=" + purCode + ", no=" + no + ", proCode=" + proCode + ", price=" + price
				+ ", purDate=" + purDate + ", permitNo=" + permitNo + ", purStatus=" + purStatus + "]";
	}
	
	
}
