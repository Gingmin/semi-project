package com.greedy.semi.common.paging;

import com.greedy.semi.notice.model.dto.PageInfoDTO;

public class Pagenation {

	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		
		
		maxPage = (int) Math.ceil((double) totalCount / limit);
		
		startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;
		
		endPage = startPage + buttonAmount - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		startRow = (pageNo -1) * limit + 1;
		endRow = startRow + limit - 1;
		
		System.out.println("limit : " + limit);
		System.out.println("buttonAmount : " + buttonAmount);
		System.out.println("maxPage : " + maxPage);
		System.out.println("startPage : " + startPage);
		System.out.println("endOage : " + endPage);
		System.out.println("startRow : " + startRow);
		System.out.println("endRow : " + endRow);
		
		return new PageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}
}
