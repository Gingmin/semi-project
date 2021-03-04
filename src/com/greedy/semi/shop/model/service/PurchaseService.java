package com.greedy.semi.shop.model.service;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import static com.greedy.semi.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.semi.common.jdbc.JDBCTemplate.commit;
import static com.greedy.semi.common.jdbc.JDBCTemplate.rollback;

import java.sql.Connection;

import com.greedy.semi.shop.model.dao.PurchaseDAO;
import com.greedy.semi.shop.model.dto.PurchaseProductDTO;

public class PurchaseService {

	public final PurchaseDAO purchaseDAO;
	
	public PurchaseService() {
		purchaseDAO = new PurchaseDAO();
		
	}

	public PurchaseProductDTO insertPurchaseInfo(PurchaseProductDTO purchaseInfo, int no) {
		
	    Connection con = getConnection();
		
	    int result = purchaseDAO.insertPurchaseProduct(con, purchaseInfo, no);
		
	    PurchaseProductDTO changedInfo = purchaseDAO.selectPurchaseProduct(con, purchaseInfo, no);
	    
	    if(result > 0) {
	    	commit(con);
	    } else {
	    	rollback(con);
	    }
	    
		close(con);
		
		return changedInfo;
		
		
	}

	
}
