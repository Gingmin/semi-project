package com.greedy.semi.notice.model.dto;

import java.sql.Date;
import java.util.List;

import com.greedy.semi.member.model.dto.MemberDTO;

public class NoticeDTO implements java.io.Serializable {

	private int no;
	private String title;
	private String body;
	private String categoryCode;
	private CategoryDTO category;
	private BlackListDTO blackListDTO;
	private ReportCategoryDTO reportCategoryDTO;
	private int writerMemberNo;
	private MemberDTO writer;
	private int count;
	private java.sql.Date createdDate;
	private String status;
	private List<NTAttachmentDTO> attachmentDTO;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String body, String categoryCode, CategoryDTO category,
			BlackListDTO blackListDTO, ReportCategoryDTO reportCategoryDTO, int writerMemberNo, MemberDTO writer,
			int count, Date createdDate, String status, List<NTAttachmentDTO> attachmentDTO) {
		super();
		this.no = no;
		this.title = title;
		this.body = body;
		this.categoryCode = categoryCode;
		this.category = category;
		this.blackListDTO = blackListDTO;
		this.reportCategoryDTO = reportCategoryDTO;
		this.writerMemberNo = writerMemberNo;
		this.writer = writer;
		this.count = count;
		this.createdDate = createdDate;
		this.status = status;
		this.attachmentDTO = attachmentDTO;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public BlackListDTO getBlackListDTO() {
		return blackListDTO;
	}

	public void setBlackListDTO(BlackListDTO blackListDTO) {
		this.blackListDTO = blackListDTO;
	}

	public ReportCategoryDTO getReportCategoryDTO() {
		return reportCategoryDTO;
	}

	public void setReportCategoryDTO(ReportCategoryDTO reportCategoryDTO) {
		this.reportCategoryDTO = reportCategoryDTO;
	}

	public int getWriterMemberNo() {
		return writerMemberNo;
	}

	public void setWriterMemberNo(int writerMemberNo) {
		this.writerMemberNo = writerMemberNo;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public java.sql.Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(java.sql.Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<NTAttachmentDTO> getAttachmentDTO() {
		return attachmentDTO;
	}

	public void setAttachmentDTO(List<NTAttachmentDTO> attachmentDTO) {
		this.attachmentDTO = attachmentDTO;
	}

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", body=" + body + ", categoryCode=" + categoryCode
				+ ", category=" + category + ", blackListDTO=" + blackListDTO + ", reportCategoryDTO="
				+ reportCategoryDTO + ", writerMemberNo=" + writerMemberNo + ", writer=" + writer + ", count=" + count
				+ ", createdDate=" + createdDate + ", status=" + status + ", attachmentDTO=" + attachmentDTO + "]";
	}

	

	
	
	
	
	
	
}
