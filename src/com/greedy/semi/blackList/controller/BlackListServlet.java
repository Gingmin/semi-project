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
			int MaxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/attachment/report/original/";
			String thumbnailDirectory = rootLocation + "/resources/attachment/report/thumbnail";
			
			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			if(!directory1.exists() || !directory2.exists()) {
				System.out.println("원본 폴더 생성 : " + directory1.mkdir());
				System.out.println("썸네일 폴더 생성 : " + directory2.mkdir());
			}
			
			
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			DiskFileItemFactory fileFactory = new DiskFileItemFactory();
			fileFactory.setRepository(new File(fileUploadDirectory));
			fileFactory.setSizeThreshold(MaxFileSize);
			
			ServletFileUpload fileUpload = new ServletFileUpload(fileFactory);
			
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					System.out.println(item);
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
							
							Map<String, String>fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							Thumbnails.of(fileUploadDirectory + randomFileName).toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							fileMap.put("thumbnailPath", "/resources/attachment/report/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
						}
					} else {
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
					}
					
				}
				
				System.out.println("파라미터 : " + parameter);
				System.out.println("파일리스트 : " + fileList);
				
				String title = request.getParameter("title");
				String body = request.getParameter("body");
				String writer = request.getParameter("writer");
				int writerMemberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
				String searchCode = request.getParameter("searchCode");
				
				
				System.out.println(writer);
				System.out.println(writerMemberNo);
				System.out.println(title);
				System.out.println(body);
				System.out.println(searchCode);
				
				NoticeDTO reportNotice = new NoticeDTO();
				BlackListDTO reportBlack = new BlackListDTO();
				
				
				reportBlack.setMemberNo(writerMemberNo);
				reportBlack.setReportCode(searchCode);
				reportNotice.setTitle(title);
				reportNotice.setBody(body);
				reportNotice.setWriterMemberNo(writerMemberNo);
				
				reportNotice.setAttachmentDTO(new ArrayList<NTAttachmentDTO>());
				List<NTAttachmentDTO> list = reportNotice.getAttachmentDTO();
				for(int i = 0; i < fileList.size(); i ++) {
					Map<String, String>file = fileList.get(i);
					
					NTAttachmentDTO tempFileInfo = new NTAttachmentDTO();
					tempFileInfo.setOriginalName(file.get("originFileName"));
					tempFileInfo.setFileName(file.get("savedFileName"));
					tempFileInfo.setFilePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));
					
					list.add(tempFileInfo);
					
																				
				}
				
				
				
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
