package com.greedy.semi.shop.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.greedy.semi.shop.model.dao.PriceDAO;
import com.greedy.semi.shop.model.dto.PriceDTO;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

public class PriceService {

	public final PriceDAO priceDAO;
	
	public PriceService () {
		priceDAO = new PriceDAO();
	}
	
	public int selectProductPrice(String productValue){
		
		Connection con = getConnection();
		
	    int productPrice = priceDAO.selectProductPrice(con, productValue);
		
		close(con);
	
		return productPrice;
		
	}
}
