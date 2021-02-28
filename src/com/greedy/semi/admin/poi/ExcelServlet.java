package com.greedy.semi.admin.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.greedy.semi.admin.model.dto.ReceiptDTO;
import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.paging.Pagenation;
import com.greedy.semi.notice.model.dto.PageInfoDTO;

@WebServlet("/admin/calculatorMoney/excel")
public class ExcelServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* 파라미터 */
		String memberNo = request.getParameter("memberNo");
		String name = request.getParameter("name");
		String searchDate1 = request.getParameter("searchDate1");
		String searchDate2 = request.getParameter("searchDate2");

		System.out.println("memberNo : " + memberNo);
		System.out.println("name : " + name);
		System.out.println("searchDate1 : " + searchDate1);
		System.out.println("searchDate2 : " + searchDate2);

		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;

		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		if(pageNo <= 0) {
			pageNo = 1;
		}

		AdminService adminService = new AdminService();
		int totalCount = adminService.searchCalculateSearchCount(memberNo, name, searchDate1, searchDate2);

		System.out.println("tatalCount : " + totalCount);

		int limit = 10;
		int buttonAmount = 5;

		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);

		System.out.println(pageInfo);
		/* 다시 뷰로 뿌려주기 위한 list(10개씩) */
		List<ReceiptDTO> payList = adminService.searchCalculateSearchList(memberNo, name, pageInfo, searchDate1, searchDate2);
		/* 엑셀에 쓰기 위한 리스트 (전채 개수) */
		List<ReceiptDTO> payList2 = adminService.searchExcelList(memberNo, name, searchDate1, searchDate2);

		for(ReceiptDTO receipt : payList) {
			System.out.println(receipt);
		}
		/* 검색 flag */
		String searchValue = "되거라";

		/* 엑셀 영역 */
		//String version = "xls";
		String version = "xlsx";

		/* workbook 생성 */
		Workbook workbook = createWorkbook(version);

		/* 시트 생성 */
		Sheet sheet = workbook.createSheet("calculateSheet");

		/* 셀 데이터 포맷 지정 */
		//CellStyle bodyStyle = workbook.createCellStyle();
		/* 날짜 포맷 */
		//bodyStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		/* 정렬 포맷 */
		//bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		//bodyStyle.setVerticalAlignment(VerticalAlignment.TOP);
		/* 셀 색지정 */
		//style.setFillBackgroundColor(IndexedColors.BLUE_GREY.index);
		/* 폰트설정 */
		//Font font = workbook.createFont();
		//font.setColor(IndexedColors.RED.index);
		//cell.setCellStyle(style);
		
		CellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setBorderTop(BorderStyle.THIN);
		titleStyle.setBorderBottom(BorderStyle.THIN);
		titleStyle.setBorderLeft(BorderStyle.THIN);
		titleStyle.setBorderRight(BorderStyle.THIN);
		titleStyle.setFillForegroundColor(HSSFColorPredefined.LIGHT_YELLOW.getIndex());
		titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);
		titleStyle.setVerticalAlignment(VerticalAlignment.TOP);
		Font titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		
		CellStyle bodyStyle = workbook.createCellStyle();
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setAlignment(HorizontalAlignment.CENTER);
		bodyStyle.setVerticalAlignment(VerticalAlignment.TOP);

		CellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setAlignment(HorizontalAlignment.CENTER);
		dateStyle.setBorderTop(BorderStyle.THIN);
		dateStyle.setBorderBottom(BorderStyle.THIN);
		dateStyle.setBorderLeft(BorderStyle.THIN);
		dateStyle.setBorderRight(BorderStyle.THIN);
		dateStyle.setAlignment(HorizontalAlignment.CENTER);
		dateStyle.setVerticalAlignment(VerticalAlignment.TOP);
		dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		
		CellStyle footStyle = workbook.createCellStyle();
		footStyle.setAlignment(HorizontalAlignment.CENTER);
		footStyle.setBorderTop(BorderStyle.THIN);
		footStyle.setBorderBottom(BorderStyle.THIN);
		footStyle.setBorderLeft(BorderStyle.THIN);
		footStyle.setBorderRight(BorderStyle.THIN);
		footStyle.setAlignment(HorizontalAlignment.CENTER);
		footStyle.setVerticalAlignment(VerticalAlignment.TOP);
		footStyle.setFillForegroundColor(HSSFColorPredefined.RED.getIndex());
		//footStyle.setFillBackgroundColor(IndexedColors.BLUE_GREY.index);
		footStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		/* 셀에 데이터 작성 */
		/* 셀 */
		Cell cell = getCell(sheet, 0, 0);
		cell.setCellValue(payList2.get(1).getMemberDTO().getName() + " 트레이너 정산내역");
		cell.setCellStyle(titleStyle);
		
		cell = getCell(sheet, 0, 1);
		cell.setCellValue("기간");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 0, 2);
		cell.setCellValue(searchDate1);
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 0, 3);
		cell.setCellValue("~");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 0, 4);
		cell.setCellValue(searchDate2);
		cell.setCellStyle(titleStyle);
		
		cell = getCell(sheet, 1, 0);
		cell.setCellValue("일자");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 1, 1);
		cell.setCellValue("트레이너번호");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 1, 2);
		cell.setCellValue("이름");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 1, 3);
		cell.setCellValue("정산내역번호");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 1, 4);
		cell.setCellValue("분류유형");
		cell.setCellStyle(titleStyle);
		cell = getCell(sheet, 1, 5);
		cell.setCellValue("금액");
		cell.setCellStyle(titleStyle);
		
		for(int i = 0; i < payList2.size(); i++) {
			for(int j = 0; j < 6; j++) {
				cell = getCell(sheet, i + 2, j);
				if(j == 0) {
					cell.setCellValue(payList2.get(i).getReDate());
					cell.setCellStyle(dateStyle);
					//cell.setNumericCellValue();
				}
				if(j == 1) {
					cell.setCellValue(payList2.get(i).getNo());
					cell.setCellStyle(bodyStyle);
					//cell.getNumericCellValue();
				}
				if(j == 2) {
					cell.setCellValue(payList2.get(i).getMemberDTO().getName());
					cell.setCellStyle(bodyStyle);
				}
				if(j == 3) {
					cell.setCellValue(payList2.get(i).getReNo());
					cell.setCellStyle(bodyStyle);
				}
				if(j == 4) {
					cell.setCellValue(payList2.get(i).getReceiptCategoryDTO().getRecName());
					cell.setCellStyle(bodyStyle);
				}
				if(j == 5) {
					cell.setCellValue(payList2.get(i).getTotalPrice());
					cell.setCellStyle(bodyStyle);
					//cell.getNumericCellValue();
				}
			}
		}
		cell = getCell(sheet, payList2.size() + 2, 5);
		cell.setCellFormula("SUM(F3:F" + (payList2.size() + 2) + ")");
		cell.setCellStyle(footStyle);

		/* 셀 너비 자동 지정 */
		//sheet.autoSizeColumn(0);
		//sheet.autoSizeColumn(1);
		//sheet.autoSizeColumn(2);
		//sheet.autoSizeColumn(4);
		//sheet.autoSizeColumn(5);
		//sheet.autoSizeColumn(6);
		for(int k = 0; k < payList2.size(); k++) {
			sheet.autoSizeColumn(k);
			sheet.setColumnWidth(k, (sheet.getColumnWidth(k)) + (short)1024);
		}
		
		/* 셀넓이 */
		//sheet.setColumnWidth(3, (sheet.getColumnWidth(3)) + 50);
		//sheet.setColumnWidth(4, (sheet.getColumnWidth(4)) + 50);
		//sheet.setColumnWidth(5, (sheet.getColumnWidth(5)) + 50);
		
		/* 함수 */
		//cell.setCellFormula("SUM(A2:B2)");

		/* 작성 */
		//String rootLocation = getServletContext().getRealPath("/");
		//String savePath = rootLocation + "/resources/excel/";
		writeExcel(workbook, System.getProperty("user.home") + "/desktop/정산내역." + version);

		/* 다시 뷰로 이동 */
		String path = "";
		if(payList != null) {
			path = "/WEB-INF/views/admin/calculator.jsp";
			request.setAttribute("searchValue", searchValue);
			request.setAttribute("payList", payList);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("memberNo", memberNo);
			request.setAttribute("name", name);
			request.setAttribute("searchDate1", searchDate1);
			request.setAttribute("searchDate2", searchDate2);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "정산 내역 검색 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

	//workbook 생성
	public Workbook createWorkbook(String version) {

		if("xls".equals(version)) {
			return new HSSFWorkbook();
		} else if("xlsx".equals(version)) {
			return new XSSFWorkbook();
		}

		throw new NoClassDefFoundError();
	}

	public Cell getCell(Sheet sheet, int rownum, int cellnum) {

		Row row = getRow(sheet, rownum);

		return getCell(row, cellnum);
	}

	/* sheet로 부터 row를 얻고 생성 */
	public Row getRow(Sheet sheet, int rownum) {

		Row row = sheet.getRow(rownum);

		if(row == null) {
			row = sheet.createRow(rownum);
		}

		return row;
	}

	/* row로부터 cell를 취득 생성 */
	public Cell getCell(Row row, int cellnum) {

		Cell cell = row.getCell(cellnum);

		if(cell == null) {
			cell = row.createCell(cellnum);
		}

		return cell;
	}

	public void writeExcel(Workbook workbook, String filepath) {

		try {

			FileOutputStream stream = new FileOutputStream(filepath);

			workbook.write(stream);

			stream.flush();
			stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
