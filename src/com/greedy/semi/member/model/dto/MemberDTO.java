package com.greedy.semi.member.model.dto;

import java.sql.Date;

import com.greedy.semi.admin.model.dto.AmountDTO;
import com.greedy.semi.admin.model.dto.BlackHistoryDTO;
import com.greedy.semi.admin.model.dto.PurchaseProductDTO;

public class MemberDTO implements java.io.Serializable {

	private int no;
	private String email;
	private String pwd;
	private String name;
	private String phone;
	private java.sql.Date enrollDate;
	private java.sql.Date modifiedDate;
	private String blackStatus;
	private String role;
	private String status;
	
	private AmountDTO amountDTO;
	private PurchaseProductDTO purchaseProductDTO;
	private TrainerInfoDTO trainerInfoDTO;
	private BlackHistoryDTO blackHistoryDTO;
	
	public MemberDTO() {}

	public MemberDTO(int no, String email, String pwd, String name, String phone, Date enrollDate, Date modifiedDate,
			String blackStatus, String role, String status, AmountDTO amountDTO, PurchaseProductDTO purchaseProductDTO,
			TrainerInfoDTO trainerInfoDTO, BlackHistoryDTO blackHistoryDTO) {
		super();
		this.no = no;
		this.email = email;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.enrollDate = enrollDate;
		this.modifiedDate = modifiedDate;
		this.blackStatus = blackStatus;
		this.role = role;
		this.status = status;
		this.amountDTO = amountDTO;
		this.purchaseProductDTO = purchaseProductDTO;
		this.trainerInfoDTO = trainerInfoDTO;
		this.blackHistoryDTO = blackHistoryDTO;
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

	public java.sql.Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(java.sql.Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public java.sql.Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(java.sql.Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getBlackStatus() {
		return blackStatus;
	}

	public void setBlackStatus(String blackStatus) {
		this.blackStatus = blackStatus;
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

	public AmountDTO getAmountDTO() {
		return amountDTO;
	}

	public void setAmountDTO(AmountDTO amountDTO) {
		this.amountDTO = amountDTO;
	}

	public PurchaseProductDTO getPurchaseProductDTO() {
		return purchaseProductDTO;
	}

	public void setPurchaseProductDTO(PurchaseProductDTO purchaseProductDTO) {
		this.purchaseProductDTO = purchaseProductDTO;
	}

	public TrainerInfoDTO getTrainerInfoDTO() {
		return trainerInfoDTO;
	}

	public void setTrainerInfoDTO(TrainerInfoDTO trainerInfoDTO) {
		this.trainerInfoDTO = trainerInfoDTO;
	}

	public BlackHistoryDTO getBlackHistoryDTO() {
		return blackHistoryDTO;
	}

	public void setBlackHistoryDTO(BlackHistoryDTO blackHistoryDTO) {
		this.blackHistoryDTO = blackHistoryDTO;
	}

	@Override
	public String toString() {
		return "MemberDTO [no=" + no + ", email=" + email + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone
				+ ", enrollDate=" + enrollDate + ", modifiedDate=" + modifiedDate + ", blackStatus=" + blackStatus
				+ ", role=" + role + ", status=" + status + ", amountDTO=" + amountDTO + ", purchaseProductDTO="
				+ purchaseProductDTO + ", trainerInfoDTO=" + trainerInfoDTO + ", blackHistoryDTO=" + blackHistoryDTO
				+ "]";
	}

	
	
	
	
	
}
