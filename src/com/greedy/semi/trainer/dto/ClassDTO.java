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
	private String kind;
	private String category;
	private String intro;
	private String introduce;
	private String createdDate;
	private String status;
	private String approval;
	private int count;
	
	private List<AttachmentDTO> attachmentList;
	
	public ClassDTO() {}

	public ClassDTO(int no, int trainerNo, MemberDTO memberNo, int attachmentNo, String name, String kind,
			String category, String intro, String introduce, String createdDate, String status, String approval,
			int count, List<AttachmentDTO> attachmentList) {
		super();
		No = no;
		this.trainerNo = trainerNo;
		this.memberNo = memberNo;
		this.attachmentNo = attachmentNo;
		this.name = name;
		this.kind = kind;
		this.category = category;
		this.intro = intro;
		this.introduce = introduce;
		this.createdDate = createdDate;
		this.status = status;
		this.approval = approval;
		this.count = count;
		this.attachmentList = attachmentList;
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

	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
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

	public int getCount() {
		return count;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setKind(String kind) {
		this.kind = kind;
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

	public void setCount(int count) {
		this.count = count;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "ClassDTO [No=" + No + ", trainerNo=" + trainerNo + ", memberNo=" + memberNo + ", attachmentNo="
				+ attachmentNo + ", name=" + name + ", kind=" + kind + ", category=" + category + ", intro=" + intro
				+ ", introduce=" + introduce + ", createdDate=" + createdDate + ", status=" + status + ", approval="
				+ approval + ", count=" + count + ", attachmentList=" + attachmentList + "]";
	}

	
	
}
