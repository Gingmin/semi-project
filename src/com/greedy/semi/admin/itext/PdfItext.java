package com.greedy.semi.admin.itext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;

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


public class PdfItext {

	public void mkPDF() {
	
		String html = "<html>" +
		              "<head></head>" +
				      "<body>" +
		              "<h1>안녕</h1>" +
				      "</body>" +
		              "</html>";
		/* io */
		String path = System.getProperty("user.home") + "/desktop/정산서.pdf";
		
		try {
			FileOutputStream os = new FileOutputStream(path);
			
			/*pdf*/
			Document document = new Document(PageSize.A4, 10, 10, 10, 10);
			/*pdfWriter*/
			PdfWriter writer = PdfWriter.getInstance(document, os);
			/* document open */
			document.open();
			/* css 설정할 resolver 인스턴스 생성 */
			StyleAttrCSSResolver cssResolver = new StyleAttrCSSResolver();
			/* css 파일 설정 (css1.css 파일) */
			FileInputStream cssStream = new FileInputStream("css1.css");
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
			//document의 리소스 반환
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
