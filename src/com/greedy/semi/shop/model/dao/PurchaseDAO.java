package com.greedy.semi.shop.model.dao;

import static com.greedy.semi.common.jdbc.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.greedy.semi.common.config.ConfigLocation;
import com.greedy.semi.shop.model.dto.PurchaseProductDTO;

public class PurchaseDAO {

	private final Properties prop;
	
	public PurchaseDAO() {
		prop = new Properties();
		
		try {
			
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "purchase/purchase-mapper.xml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertPurchaseProduct(Connection con, PurchaseProductDTO purchaseInfo, int no) {
		
        PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertPurchaseProduct");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, purchaseInfo.getPurchaseCode());
			pstmt.setInt(2, no);
			pstmt.setString(3, purchaseInfo.getProductCode());
			pstmt.setInt(4, purchaseInfo.getPurchasePrice());
			pstmt.setInt(5, purchaseInfo.getPurchasePermitNo());
			pstmt.setString(6, purchaseInfo.getPurchaseStatus());
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public PurchaseProductDTO selectPurchaseProduct(Connection con, PurchaseProductDTO purchaseInfo, int memberNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
