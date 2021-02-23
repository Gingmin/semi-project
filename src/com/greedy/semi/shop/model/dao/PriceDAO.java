package com.greedy.semi.shop.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.greedy.semi.common.jdbc.JDBCTemplate.close;
import com.greedy.semi.common.config.ConfigLocation;

public class PriceDAO {

	private final Properties prop;
	
	public PriceDAO() {
		prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "product/product-mapper.xml"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	public int selectProductPrice(Connection con, String productValue) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int productPrice = 0;
		
		String query = prop.getProperty("selectProductPrice");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, productValue);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				productPrice = rset.getInt("PRODUCT_PRICE");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return productPrice;
	}

}
