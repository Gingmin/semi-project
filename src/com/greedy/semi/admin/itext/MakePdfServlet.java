package com.greedy.semi.admin.itext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.semi.admin.model.dto.ReceiptDTO;
import com.greedy.semi.admin.model.service.AdminService;
import com.greedy.semi.common.paging.Pagenation;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.PageInfoDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorker;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

@WebServlet("/admin/calculatorMoney/mkPdf")
public class MakePdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberNo = request.getParameter("memberNo");
		String name = request.getParameter("name");
		String searchDate1 = request.getParameter("searchDate1");
		String searchDate2 = request.getParameter("searchDate2");

		String pdfCssPath = getServletContext().getRealPath("/");
		
		AdminService adminService = new AdminService();
		/* 리스트 재조회 */
		String currentPage = request.getParameter("currentPage");
	      int pageNo = 1;
	      
	      if(currentPage != null && !"".equals(currentPage)) {
	         pageNo = Integer.parseInt(currentPage);
	      }
	      
	      if(pageNo <= 0) {
	         pageNo = 1;
	      }
	      
	      int totalCount = adminService.searchCalculateSearchCount(memberNo, name, searchDate1, searchDate2);
	      
	      int limit = 10;
	      int buttonAmount = 5;
	      
	      PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
	      
	      System.out.println(pageInfo);
	      
	      List<ReceiptDTO> payList = adminService.searchCalculateSearchList(memberNo, name, pageInfo, searchDate1, searchDate2);
	      
		/* 재조회 끝 */
		
		/* 반복문을 돌리기 위해 AdminCalculator에서 사용했던 totalcount를 재사용 -- 불필요*/
		//int totalCount = adminService.searchCalculateSearchCount(memberNo, name, searchDate1, searchDate2);
		
		/* 정산리스트 */
		List<ReceiptDTO> calInfo = new ArrayList<>();
		calInfo = adminService.selectCalInfo(memberNo, name, searchDate1, searchDate2);
		
		/* 트레이너 계좌 정보 */
		MemberDTO trainerInfo = adminService.selectTrainerInfo(memberNo);
		
		/* 합계 */
		int allPrice = 0;
		for(int k = 0; k < calInfo.size(); k++) {
			allPrice += calInfo.get(k).getTotalPrice();
		}
		
		/*html을 string으로 변환 ------- 실패 출력문은 잘 변환되어 나오는데 pdf에서는 빈 화면으로 만들어진다. -- 폰트를 css에 추가해주지 않아서 생긴 오류다. */
		String html = "";
		int i;
		FileInputStream htmlFile = new FileInputStream(pdfCssPath + "/resources/pdf/calculatorForm.html");
		StringBuffer buffer = new StringBuffer();
		byte[] b = new byte[4096];
		while((i = htmlFile.read(b)) != -1) {
			buffer.append(new String(b, 0, i));
		}
		html = buffer.toString();
		//System.out.println(html);
		
		/*
		StringBuilder htmlsb = new StringBuilder();
		htmlsb.append("<html><head></head><body>")
		    .append("<h1 style=\"text-decoration: underline;\" align=\"center\">정산서</h1>")
		    .append("<div class=\"table_area\">")
		    .append("<table class=\"table_type1\" border=\"1px\"><tr><td rowspan=\"3\" class=\"td_detail1\"><div class=\"text_detail1\">2012년 5월 29일</div>")
		    .append("<div class=\"text_detail2\">(주)수원코딩왕</div></td><td class=\"td_detail2\">등록번호</td><td colspan=\"3\" class=\"td_detail1\">000-000-0000</td></tr>")
		    .append("<tr><td class=\"td_detail2\">상호</td><td class=\"td_detail3\">제이씨</td><td>성명</td><td class=\"td_detail3\">김민기</td></tr><tr>")
		    .append("<td class=\"td_detail2\">주소</td><td colspan=\"3\">경기도 수원시 코딩동</td></tr><tr><td rowspan=\"2\" clas=\"td_detail1\"><div>이와 같이 계산합니다</div></td>")
		    .append("<td class=\"td_detail2\">업태</td><td class=\"td_detail3\">도소매</td><td>종목</td><td class=\"td_detail3\">무역</td></tr><tr>")
		    .append("<td class=\"td_detail2\">전화</td><td class=\"td_detail3\">02-1234-4567</td><td>팩스</td><td class=\"td_detail3\">02-123-123</td></tr></table>")
		    .append("<div class=\"checkbox_area\"><label><input type=\"checkbox\" name=\"\" value=\"청구내역\"/>청구내역</label></div>")
		    .append("<table class=\"table_type2\" border=\"1px\"><tr><th class=\"th_detail1\">합계금액</th><th class=\"th_detail2\"><span class=\"th_text1\">일금</span>")
		    .append("<span class=\"th_text2\">이천사십만 원정</span></th><th class=\"th_detail1\"><span class=\"th_text1\">W</span><span class=\"th_text2\">24,000,000</span></th>")
		    .append("</tr></table>")
		    .append("<div class=\"table_text\">(단위 : 원)</div><table class=\"table_type3\" border=\"1px\"><tr class=\"table_tr_detail\"><td class=\"td_detail1\">날짜</td>")
		    .append("<td class=\"td_detail1\">품목</td><td class=\"td_detail1\">규격</td><td class=\"td_detail2\">수량</td><td class=\"td_detail2\">단위</td><td class=\"td_detail1\">단가</td>")
		    .append("<td class=\"td_detail1\">합계</td><td class=\"td_detail1\">잔액</td></tr><tr class=\"table_tr_detail\"><td>05월 23일</td><td>칠레키위</td><td>27과</td><td>120</td>")
		    .append("<td>박스</td><td>50,000</td><td>6,000,000</td><td>6,000,000</td></tr><tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		    .append("<tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		    .append("<tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr><tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		    .append("<tr class=\"table_tr_detail\"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>")
		    .append("<tr class=\"table_tr_detail type\"><td class=\"td_detail1\">합계</td><td class=\"td_detail1\"></td><td class=\"td_detail1\"></td><td class=\"td_detail2\">350</td><td class=\"td_detail2\">박스</td>")
		    .append("<td class=\"td_detail1\"></td><td class=\"td_detail1\"></td><td class=\"td_detail1\">20,400,000</td></tr></table>")
		    .append("<table class=\"table_type4\" border=\"1px\"><tr class=\"table_tr_detail\"><td class=\"td_detail1\">거래은행</td><td class=\"td_detail2\">외환은행</td><td class=\"td_detail1\">예금주</td>")
		    .append("<td class=\"td_detail2\">제이씨</td></tr><tr class=\"table_tr_detail\"><td class=\"td_detail1\">계좌번호</td><td class=\"td_detail2\">000-000-0000</td><td class=\"td_detail1\">청구일시</td>")
		    .append("<td class=\"td_detail2\">2021년 2월 28일</td></tr></table></div></body></html>");
		String html = htmlsb.toString();
		*/
		
		/*String html = "<html>"
				    + "<head></head>"
				    + "<body>"
				    + "<h1>마마마마</h1>"
				    + "</body>"
				    + "</html>";
		*/
		
		/* 현재시간 */
		Date nowDate = new Date(System.currentTimeMillis());
		SimpleDateFormat eightFormat = new SimpleDateFormat("yyyyMMdd");
		
		html += "<div class=\"table_area\">"
			  + "<table class=\"table_type1\">"
			  + "<tr>"
			  + "<td rowspan=\"3\" class=\"td_detail1\">"
			  + "<div class=\"text_detail1\">" + eightFormat.format(nowDate) + "</div>"
			  + "<div></div>"
			  + "<div class=\"text_detail2\">(주)HELLOPT    貴中</div>"
			  + "</td>"
			  + "<td class=\"td_detail2\">이메일</td>"
			  + "<td colspan=\"3\" class=\"td_detail1\">" + trainerInfo.getEmail() + "</td>"
			  + "</tr>"
			  + "<tr>"
			  + "<td class=\"td_detail2\">회원번호</td>"
			  + "<td class=\"td_detail3\">" + trainerInfo.getNo() + "</td>"
			  + "<td>성명</td>"
	          + "<td class=\"td_detail3\">" + trainerInfo.getName() + "</td>"
	          + "</tr><tr>"
	          + "<td class=\"td_detail2\">가입일</td>"
	          + "<td colspan=\"3\">" + trainerInfo.getEnrollDate() + "</td>"
	          + "</tr><tr><td rowspan=\"2\" class=\"td_detail1\">"
	          + "<div>下記와 같이 계산합니다</div>"
	          + "</td>"
	          + "<td class=\"td_detail2\">업태</td>"
	          + "<td class=\"td_detail3\">도소매</td>"
	          + "<td>종목</td><td class=\"td_detail3\">전자상거래</td>"
	          + "</tr>"
	          + "<tr>"
	          + "<td class=\"td_detail2\">전화</td>"
	          + "<td class=\"td_detail3\">" + trainerInfo.getPhone() + "</td>"
	          + "<td>팩스</td>"
	          + "<td class=\"td_detail3\">02-123-123</td>"
	          + "</tr>"
	          + "</table>";
		
		html += "<div class=\"checkbox_area\">청구내역</div>"
			  + "<table class=\"table_type2\"><tr><th class=\"th_detail1\">합계금액</th><th class=\"th_detail2\">"
              + "<span class=\"th_text1\">일금</span><span class=\"th_text2\">"
              + ""
              + "</span></th><th class=\"th_detail1\"><span class=\"th_text1\">W</span>"
              + "<span class=\"th_text2\">"
              + allPrice
              + "</span></th></tr></table>"
              + "<div class=\"table_text\">(단위 : 원)</div>"
              + "<table class=\"table_type3\"><tr class=\"table_tr_detail\">"
              + "<td class=\"td_detail1\">날짜</td><td class=\"td_detail1\">품목</td><td class=\"td_detail2\">수량</td><td class=\"td_detail1\">단가</td>"
              + "<td class=\"td_detail1\">합계</td></tr>";
		/* 분류에 따라 단가와 수량 구하기 */
		for(int j = 0; j < calInfo.size(); j++) {
			
			int unitPrice = 0;
			int amount = 0;
			switch(calInfo.get(j).getReceiptCategoryDTO().getRecName()) {
				case "녹화영상정산금액": unitPrice = 5; amount = calInfo.get(j).getTotalPrice() / unitPrice; break;
				case "실시간수업정산금액": unitPrice = 10; amount = calInfo.get(j).getTotalPrice() / unitPrice; break;
				case "피티정산금액": unitPrice = 9000; amount = calInfo.get(j).getTotalPrice() / unitPrice; break;
			}
			
			html += "<tr class=\"table_tr_detail\">"
				  + "<td>" + calInfo.get(j).getReDate() + "</td>"
				  + "<td>" + calInfo.get(j).getReceiptCategoryDTO().getRecName() + "</td>"
				  + "<td>" + amount + "</td>"
				  + "<td>" + unitPrice + "</td>"
				  + "<td>" + calInfo.get(j).getTotalPrice() + "</td>"
				  + "</tr>";
		}
        
		html += "<tr class=\"table_tr_detail type\">"
			  + "<td class=\"td_detail1\">합계</td>"
			  + "<td class=\"td_detail1\"></td>"
			  + "<td class=\"td_detail1\"></td>"
			  + "<td class=\"td_detail1\"></td>"
			  + "<td class=\"td_detail1\">"
			  + allPrice + "</td></tr></table>";
		
		html += "<table class=\"table_type4\">"
			  + "<tr class=\"table_tr_detail\">"
			  + "<td class=\"td_detail1\">거래은행</td>"
			  + "<td class=\"td_detail2\">" + trainerInfo.getTrainerInfoDTO().getBankName() + "</td>"
			  + "<td class=\"td_detail1\">예금주</td>"
			  + "<td class=\"td_detail2\">" + trainerInfo.getTrainerInfoDTO().getAccountHolder() + "</td>"
			  + "</tr>"
			  + "<tr class=\"table_tr_detail\">"
			  + "<td class=\"td_detail1\">계좌번호</td>"
			  + "<td class=\"td_detail2\">" + trainerInfo.getTrainerInfoDTO().getAccountNumber() + "</td>"
		      + "<td class=\"td_detail1\">청구일시</td>"
		      + "<td class=\"td_detail2\">" + eightFormat.format(nowDate) + "</td>"
		      + "</tr>"
		      + "</table>"
		      + "</div>"
		      + "</body>"
		      + "</html>";
       
		System.out.println("+된 html : " + html);
		
		/* io */
		//String path = System.getProperty("user.home") + "/desktop/정산서.pdf";
		String path = request.getServletContext().getRealPath("/") + "/" + /*"/resources/pdf/statementOfAccounts.pdf"*/
	     System.getProperty("user.home") + "/desktop/statementOfAccounts.pdf";
		
		try {
			FileOutputStream os = new FileOutputStream(path);

			/*pdf*/
			Document document = new Document(PageSize.A4, 10, 10, 10, 10);
			/*pdfWriter*/
			PdfWriter writer = PdfWriter.getInstance(document, os);
			/* 파일 다운도르 설정 */
			response.setContentType("application/pdf");
			String fileName = URLEncoder.encode("statementOfAccounts", "UTF-8"); //파일명이 한글일 땐 인코딩 필요 -- 중요함.. 안하면 파일을 열 수 없다.
			/* document open */
			document.open();
			/* css 설정할 resolver 인스턴스 생성 */
			StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver();
			/* css 파일 설정 (css1.css 파일) */
			FileInputStream cssStream = new FileInputStream(pdfCssPath + "/resources/css/pdf/calculatorForm.css");
			//cssResolver.addCss(XMLWorkerHelper.getCSS(cssStream));
			//FileInputStream cssStream = new FileInputStream(pdfCssPath + "/resources/css/pdf/css1.css");
			cssResolver.addCss(XMLWorkerHelper.getCSS(cssStream));
			/* 폰트설정 */
			XMLWorkerFontProvider font = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
			// window 폰트 설정
			font.register("c:/windows/fonts/malgun.ttf", "MalgunGothic");
			// 폰트 인스턴스 생성
			CssAppliersImpl cssAppliers = new CssAppliersImpl(font);
			//htmlContext의 pipeline 생성. (폰트 인스턴스 생성)
			HtmlPipelineContext htmlContext = new HtmlPipelineContext(cssAppliers);
			htmlContext.setTagFactory(Tags.getHtmlTagProcessorFactory());
			/* pdf의 pipeline 생성 */
			PdfWriterPipeline pdfPipeline = new PdfWriterPipeline(document, writer);
			// Html의 pipeline을 생성 (html 태그, pdf의 pipeline설정)
			HtmlPipeline htmlPipeline = new HtmlPipeline(htmlContext, pdfPipeline);
			// css의 pipeline을 합친다
			CssResolverPipeline cssResolverPipeline = new CssResolverPipeline(cssResolver, htmlPipeline);
			// work 생성 pipeline 연결
			XMLWorker worker = new XMLWorker(cssResolverPipeline, true);
			// xml 파서 생성 (html을 pdf로 변환)
			XMLParser xmlParser = new XMLParser(true, worker, Charset.forName("UTF-8"));
			// 출력
			StringReader strReader = new StringReader(html);
			xmlParser.parse(strReader);
			/*close*/
			cssStream.close();
			/* document의 리소스 반환 */
			document.close();
			/*close */
			htmlFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*search flag*/
		String searchValue = "검색";
		/* pdf flag */
		String pdf = "pdf";

		String movePath = "/WEB-INF/views/admin/calculator.jsp";
		request.setAttribute("searchValue", searchValue);
		request.setAttribute("payList", payList);
  	    request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("memberNo", memberNo);
		request.setAttribute("name", name);
		request.setAttribute("searchDate1", searchDate1);
		request.setAttribute("searchDate2", searchDate2);
		request.setAttribute("pdf", pdf);

		request.getRequestDispatcher(movePath).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
