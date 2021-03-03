package com.greedy.semi.member.controller;

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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.trainer.dto.ClassDTO;
import com.greedy.semi.trainer.dto.PtReservationDTO;
import com.greedy.semi.trainer.service.ClassService;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/member/mypage")
public class MemberMypageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String path = "/WEB-INF/views/member-page/mypage_member.jsp";
//		request.getRequestDispatcher(path).forward(request, response);
		
		
		int no = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
//		int no = Integer.parseInt(request.getParameter("memberNo"));
		
		ClassService classService = new ClassService();
		List<PtReservationDTO> reservationList = classService.selectReservationList(no);
		
		System.out.println(reservationList);
		
		for(PtReservationDTO reservation : reservationList) {
			System.out.println(reservation);
		}
		
		String path = "";
		if(reservationList != null) {
			path = "/WEB-INF/views/member-page/mypage_member.jsp";
			request.setAttribute("reservationList", reservationList);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "예약한 수업 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/attachment/member/original/";
			String thumbnailDirectory = rootLocation + "/resources/attachment/member/thumbnail/";
			
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
							
							
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							int width = 130;
							int height = 130;
							
							
							Thumbnails.of(fileUploadDirectory + randomFileName).size(width, height).toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							fileMap.put("thumbnailPath", "/resources/attachment/member/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
							
						}
						
					} else {
						
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"),"UTF-8"));
				
					}
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				
				
				
				int memberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
				
				System.out.println("여기 뜨지?" + memberNo);
				
				
				
				
				
				
				
				
			
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
