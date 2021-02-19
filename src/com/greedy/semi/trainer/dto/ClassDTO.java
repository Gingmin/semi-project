package com.greedy.semi.trainer.dto;

import java.io.Serializable;
import java.util.List;

import com.greedy.semi.member.model.dto.MemberDTO;

public class ClassDTO implements Serializable {
	
	private int No;
	private int trainerNo;
	private MemberDTO memberNo;
	private int attachmentNo;
	private String name;
	private String type;
	private String category;
	private String intro;
	private String introduce;
	private String createdDate;
	private String status;
	private String approval;
	
	private List<AttachmentDTO> attachmentList;
	
	public ClassDTO() {}

	public ClassDTO(int no, int trainerNo, MemberDTO memberNo, int attachmentNo, List<AttachmentDTO> attachmentList,
			String name, String type, String category, String intro, String introduce, String createdDate,
			String status, String approval) {
		super();
		No = no;
		this.trainerNo = trainerNo;
		this.memberNo = memberNo;
		this.attachmentNo = attachmentNo;
		this.attachmentList = attachmentList;
		this.name = name;
		this.type = type;
		this.category = category;
		this.intro = intro;
		this.introduce = introduce;
		this.createdDate = createdDate;
		this.status = status;
		this.approval = approval;
	}

	public int getNo() {
		return No;
	}

	public int getTrainerNo() {
		return trainerNo;
	}

	public MemberDTO getMemberNo() {
		return memberNo;
	}

	public int getAttachmentNo() {
		return attachmentNo;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getCategory() {
		return category;
	}

	public String getIntro() {
		return intro;
	}

	public String getIntroduce() {
		return introduce;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getStatus() {
		return status;
	}

	public String getApproval() {
		return approval;
	}

	public void setNo(int no) {
		No = no;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public void setMemberNo(MemberDTO memberNo) {
		this.memberNo = memberNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	@Override
	public String toString() {
		return "ClassDTO [No=" + No + ", trainerNo=" + trainerNo + ", memberNo=" + memberNo + ", attachmentNo="
				+ attachmentNo + ", name=" + name + ", type=" + type + ", category=" + category + ", intro=" + intro
				+ ", introduce=" + introduce + ", createdDate=" + createdDate + ", status=" + status + ", approval="
				+ approval + "]";
	}
	
	
}
