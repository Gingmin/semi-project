package com.greedy.semi.admin.poi;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Poi {

	/* 엑셀 쓰기 */
	
	public Poi() {
		//String version = "xls";
		String version = "xlsx";
		
		/* workbook 생성 */
		Workbook workbook = createWorkbook(version);
		
		/* 시트 생성 */
		Sheet sheet = workbook.createSheet("calculateSheet");
		
		/* 셀 */
		Cell cell = getCell(sheet, 0, 0);
		
		/* 셀에 데이터 작성 */
		cell.setCellValue("00트레이너 0월 정산내역");
		
		cell = getCell(sheet, 0, 1);
		
		/* 셀 데이터 포맷 지정 */
		CellStyle style = workbook.createCellStyle();
		/* 날짜 포맷 */
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
		/* 정렬 포맷 */
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.TOP);
		/* 셀 색지정 */
		//style.setFillBackgroundColor(IndexedColors.BLUE_GREY.index);
		/* 폰트설정 */
		Font font = workbook.createFont();
		//font.setColor(IndexedColors.RED.index);
		cell.setCellStyle(style);
		
		/* 셀 너비 자동 지정 */
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		
		/* 함수 */
		cell.setCellFormula("SUM(A2:B2)");
		
		/* 작성 */
		String rootLocation = getServletContext.getRealPath("/");
		
		writeExcel(workbook, "" + version);
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
}






