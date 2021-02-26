package com.greedy.semi.trainer.dto;

import java.io.Serializable;

public class PtReservationDTO implements Serializable {
	
	private int permitNo;
	private int trainerNo;
	private int memberNo;
	private int applyDate;
	private int permitYn;
	private int permitDate;
	
	public PtReservationDTO() {}

	public PtReservationDTO(int permitNo, int trainerNo, int memberNo, int applyDate, int permitYn, int permitDate) {
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

	public int getTrainerNo() {
		return trainerNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public int getApplyDate() {
		return applyDate;
	}

	public int getPermitYn() {
		return permitYn;
	}

	public int getPermitDate() {
		return permitDate;
	}

	public void setPermitNo(int permitNo) {
		this.permitNo = permitNo;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public void setApplyDate(int applyDate) {
		this.applyDate = applyDate;
	}

	public void setPermitYn(int permitYn) {
		this.permitYn = permitYn;
	}

	public void setPermitDate(int permitDate) {
		this.permitDate = permitDate;
	}

	@Override
	public String toString() {
		return "PtReservationDTO [permitNo=" + permitNo + ", trainerNo=" + trainerNo + ", memberNo=" + memberNo
				+ ", applyDate=" + applyDate + ", permitYn=" + permitYn + ", permitDate=" + permitDate + "]";
	}
	
	
	

}
