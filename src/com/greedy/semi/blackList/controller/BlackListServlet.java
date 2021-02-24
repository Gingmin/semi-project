package com.greedy.semi.blackList.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.notice.model.dto.BlackListDTO;
import com.greedy.semi.notice.model.dto.NTAttachmentDTO;
import com.greedy.semi.notice.model.dto.NoticeDTO;
import com.greedy.semi.notice.model.service.NoticeService;

import net.coobird.thumbnailator.Thumbnails;




@WebServlet("/black/list")
public class BlackListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/blacklist/blackList.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/attachment/report/original/";
			String thumbnailDirectory = rootLocation + "/resources/attachment/report/thumbnail/";
			
			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			if(!directory1.exists() || !directory2.exists()) {
				System.out.println("원본 저장 폴더 생성 : " + directory1.mkdirs());
				System.out.println("썸네일 저장 폴더 생성 : " + directory2.mkdirs());
			}
		
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					System.out.println("블랙리스트 서블릿 아이템 : " + item);
				}
				
				for(int i = 0; i < fileItems.size(); i++) {
					
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						if(item.getSize() > 0) {
							String fieldName = item.getFieldName();
							String originFileName = item.getName();
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							
							String randomFileName = UUID.randomUUID().toString().replace("-","") + ext;
							
							File storeFile = new File(fileUploadDirectory + randomFileName);
							
							item.write(storeFile);
							
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							int width = 150;
							int height = 120;
							
							Thumbnails.of(fileUploadDirectory + randomFileName).size(width, height).toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							fileMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
						}
						
					} else {
						
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
					}
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
				
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				String writer = request.getParameter("writer");
				int writerMemberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
				String searchCode = request.getParameter("searchCode");
				
				
				System.out.println("블랙리스트 서블릿 글쓴이 : " + writer);
				System.out.println("블랙리스트 서블릿 글쓴이 번호 : " + writerMemberNo);
				System.out.println("블랙리스트 서블릿 제목: " + title);
				System.out.println("블랙리스트 서블릿 바디 : " + body);
				System.out.println("블랙리스트 서블릿 써치 코드 : " + searchCode);
				
				NoticeDTO reportNotice = new NoticeDTO();
				BlackListDTO reportBlack = new BlackListDTO();
				
				reportNotice.setAttachmentDTO(new ArrayList<NTAttachmentDTO>());
				List<NTAttachmentDTO> list = reportNotice.getAttachmentDTO();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String>file = fileList.get(i);
					
					NTAttachmentDTO tempFileInfo = new NTAttachmentDTO();
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setFileName(file.get("savedFileName"));
					tempFileInfo.setFilePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					
					list.add(tempFileInfo);
					
				}
				
				reportBlack.setMemberNo(writerMemberNo);
				reportBlack.setReportCode(searchCode);
				reportNotice.setTitle(title);
				reportNotice.setBody(body);
				reportNotice.setWriterMemberNo(writerMemberNo);
				
				
				int result = new NoticeService().insertReport(reportNotice, reportBlack);
				
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "insertReport");
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "신고 내역 접수 실패");
				}
				
				request.getRequestDispatcher(path).forward(request, response);
				
				
				
				
				
				
			
			} catch (Exception e) {
				e.printStackTrace();
				
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					File deletedFile = new File(fileUploadDirectory + file.get("savedFileName"));
					boolean isDeleted = deletedFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				if(cnt == fileList.size()) {
					System.out.println("업로드에 실패한 사진 모두 삭제 완료 !");
				} else {
					System.out.println("사진 삭제 실페!");
				}
			}
		
		}
	}

}
