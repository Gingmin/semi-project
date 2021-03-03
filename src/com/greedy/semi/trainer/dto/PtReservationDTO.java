package com.greedy.semi.trainer.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class PtReservationDTO implements Serializable {
	
	private int permitNo;
	private int trainerNo;
	private int memberNo;
	private Date applyDate;
	private String permitYn;
	private Date permitDate;
	private int classNo;
	
	private List<AttachmentDTO> attachmentList;
	
	public PtReservationDTO() {}

	public PtReservationDTO(int permitNo, int trainerNo, int memberNo, Date applyDate, String permitYn, Date permitDate,
			int classNo, List<AttachmentDTO> attachmentList) {
		super();
		this.permitNo = permitNo;
		this.trainerNo = trainerNo;
		this.memberNo = memberNo;
		this.applyDate = applyDate;
		this.permitYn = permitYn;
		this.permitDate = permitDate;
		this.classNo = classNo;
		this.attachmentList = attachmentList;
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

	public Date getApplyDate() {
		return applyDate;
	}

	public String getPermitYn() {
		return permitYn;
	}

	public Date getPermitDate() {
		return permitDate;
	}

	public int getClassNo() {
		return classNo;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
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

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public void setPermitYn(String permitYn) {
		this.permitYn = permitYn;
	}

	public void setPermitDate(Date permitDate) {
		this.permitDate = permitDate;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "PtReservationDTO [permitNo=" + permitNo + ", trainerNo=" + trainerNo + ", memberNo=" + memberNo
				+ ", applyDate=" + applyDate + ", permitYn=" + permitYn + ", permitDate=" + permitDate + ", classNo="
				+ classNo + ", attachmentList=" + attachmentList + "]";
	}

	

}
