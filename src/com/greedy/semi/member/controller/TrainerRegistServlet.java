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

import com.greedy.semi.common.movecontroll.ControlMethod;
import com.greedy.semi.member.model.dto.CareerDTO;
import com.greedy.semi.member.model.dto.LcAttachmentDTO;
import com.greedy.semi.member.model.dto.LicenseDTO;
import com.greedy.semi.member.model.dto.MemberDTO;
import com.greedy.semi.member.model.dto.TrainerInfoDTO;
import com.greedy.semi.member.model.service.MemberService;

import net.coobird.thumbnailator.Thumbnails;


@WebServlet("/trainer/regist")
public class TrainerRegistServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String movePath = "regist/registTrainerForm.jsp";
		ControlMethod.moveForward(movePath, request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/attachment/license/original/";
			String thumbnailDirectory = rootLocation + "/resources/attachment/license/thumbnail/";
			
			File directory1 = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			if(!directory1.exists() || !directory2.exists()) {
				directory1.mkdirs();
				directory2.mkdirs();
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
							String originalFileName = item.getName();
							
							int dot = originalFileName.lastIndexOf(".");
							String ext = originalFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							File storeFile = new File(fileUploadDirectory + randomFileName);
							
							item.write(storeFile);
							
							Map<String, String> fileMap = new HashMap<>();
							fileMap.put("fieldName", fieldName);
							fileMap.put("originalFileName", originalFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							int width = 120;
							int height = 100;
							
							Thumbnails.of(fileUploadDirectory + randomFileName)
							 	.size(width, height)
							 	.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							fileMap.put("thumbnailPath", "/resources/attachment/license/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
						}
						
					} else {
						
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
					
				}
				
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);

				/* member */
//				String email = request.getParameter("email2");
//				String pwd = request.getParameter("password");
//				String name = request.getParameter("name");
//				String phone = request.getParameter("phone").replace("-", "");
				/* trainerInfo */
//				String account = request.getParameter("account").replace("-", "");
//				String bankname = request.getParameter("bankname");
//				String holder = request.getParameter("holder");
				/* career */
//				String placeWork = request.getParameter("placeWork");
//				java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
//				java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
//				String empStatus = request.getParameter("empStatus");
				/* license */
//				String licenseCode = request.getParameter("licenseCode");
//				String licenseName = request.getParameter("licenseName");
//				String grade = request.getParameter("grade");
//				String institution = request.getParameter("institution");
//				java.sql.Date issueDate = java.sql.Date.valueOf(request.getParameter("issueDate"));
//				java.sql.Date expDate = java.sql.Date.valueOf(request.getParameter("expDate"));
				/* 회원 테이블 */
				MemberDTO requestMember = new MemberDTO();
				requestMember.setEmail(parameter.get("email2"));
				requestMember.setPwd(parameter.get("password"));
				requestMember.setName(parameter.get("name"));
				requestMember.setPhone(parameter.get("phone"));
				System.out.println("memberDTO 오류");
				/* 트레이너 추가정보 */
				TrainerInfoDTO trainer = new TrainerInfoDTO();
				trainer.setAccountNumber(parameter.get("account"));
				trainer.setBankName(parameter.get("bankname"));
				trainer.setAccountHolder(parameter.get("holder"));
				System.out.println("trainerDTO 오류");
				/* 경력 */
				CareerDTO career = new CareerDTO();
				career.setPlaceWork(parameter.get("placeWork"));
				System.out.println("여기까지완료");
				career.setStartDate(java.sql.Date.valueOf(parameter.get("startDate")));
				
				/* endDate값이 있을 때만 */
				if(parameter.get("endDate").length() > 6) {
					System.out.println("endDate 값있음");
					career.setEndDate(java.sql.Date.valueOf(parameter.get("endDate")));
				} 
				
				career.setEmpStatus(parameter.get("empStatus"));
				System.out.println("career 오류");
				/* 자격증 */
				LicenseDTO license = new LicenseDTO();
				license.setCode(parameter.get("licenseCode"));
				license.setName(parameter.get("licenseName"));
				license.setGrade(parameter.get("grade"));
				license.setInstitution(parameter.get("institution"));
				license.setIssueDate(java.sql.Date.valueOf(parameter.get("issueDate")));
				System.out.println("issueDate");
				/* expDate값이 있을 때만 */
				if(parameter.get("expDate").length() > 6) {
					System.out.println("expDate 값있음");
					license.setExpDate(java.sql.Date.valueOf(parameter.get("expDate")));
				} 
				System.out.println("license 에러");
				
				/* 첨부파일정보 */
				license.setAttachmentList(new ArrayList<LcAttachmentDTO>());
				List<LcAttachmentDTO> list = license.getAttachmentList();
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					LcAttachmentDTO tempFileInfo = new LcAttachmentDTO();
					tempFileInfo.setOriginalName(file.get("originalFileName"));
					tempFileInfo.setFileName(file.get("savedFileName"));
					tempFileInfo.setFilePath(file.get("savePath"));
					tempFileInfo.setThumbnailPath(file.get("thumbnailPath"));

					list.add(tempFileInfo);
				}
				/* 값 한번에 보내기 위해 map에 담기 */
				Map<String, Object> requestInfo = new HashMap<>();
				requestInfo.put("requestMember", requestMember);
				requestInfo.put("trainer", trainer);
				requestInfo.put("career", career);
				requestInfo.put("license", license);
				
				int result = new MemberService().registTrainer(requestInfo);
				
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/common/success.jsp";
					request.setAttribute("successCode", "insertMember");
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "회원가입 실패");
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
					
					if(cnt == fileList.size()) {
						System.out.println("업로드에 실패한 사진 모두 삭제 완료");
					} else {
						System.out.println("사진 삭제 실패!");
					}
				}
			}
			
		}
		
	}

}
