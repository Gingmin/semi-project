package com.greedy.semi.notice.model.dto;

public class ReportCategoryDTO implements java.io.Serializable{

	private String reportCode;
	private String reportType;
	
	public ReportCategoryDTO() {}

	public ReportCategoryDTO(String reportCode, String reportType) {
		super();
		this.reportCode = reportCode;
		this.reportType = reportType;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	@Override
	public String toString() {
		return "ReportCategoryDTO [reportCode=" + reportCode + ", reportType=" + reportType + "]";
	}
	
	
}
