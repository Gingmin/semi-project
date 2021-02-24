package com.greedy.semi.trainer.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class TrainerPtPermitDTO implements Serializable {
	
	private int permitNo;
	private ClassDTO trainerNo;
	private int memberNo;
	private Date applyDate;
	private String permitYn;
	private Date permitDate;
	
	
	public TrainerPtPermitDTO() {}


	public TrainerPtPermitDTO(int permitNo, ClassDTO trainerNo, int memberNo, Date applyDate, String permitYn,
			Date permitDate) {
		super();
		this.permitNo = permitNo;
		this.trainerNo = trainerNo;
		this.memberNo = memberNo;
		this.applyDate = applyDate;
		this.permitYn = permitYn;
		this.permitDate = permitDate;
	}


	public int getPermitNo() {
		return permitNo;
	}


	public ClassDTO getTrainerNo() {
		return trainerNo;
	}


	public int getMemberNo() {
		return memberNo;
	}


	public Date getApplyDate() {
		return applyDate;
	}


	public String getPermitYn() {
		return permitYn;
	}


	public Date getPermitDate() {
		return permitDate;
	}


	public void setPermitNo(int permitNo) {
		this.permitNo = permitNo;
	}


	public void setTrainerNo(ClassDTO trainerNo) {
		this.trainerNo = trainerNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}


	public void setPermitYn(String permitYn) {
		this.permitYn = permitYn;
	}


	public void setPermitDate(Date permitDate) {
		this.permitDate = permitDate;
	}


	@Override
	public String toString() {
		return "TrainerPtPermitDTO [permitNo=" + permitNo + ", trainerNo=" + trainerNo + ", memberNo=" + memberNo
				+ ", applyDate=" + applyDate + ", permitYn=" + permitYn + ", permitDate=" + permitDate + "]";
	}

	

}
