package com.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.PopulateDatabase;
import com.pojo.Security;

public class PopulateDatabseImpl implements PopulateDatabase {

	@Override
	public int populateSecurityTable() {
		
		int rowsAdded = 0;
		String INITIATESECTABLE = "insert into security values(?,?,?,?)";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INITIATESECTABLE);
			List<Security> secList = new ArrayList<>();
			secList.add(new Security(0, "Apple", 101.10, 7.0));
			secList.add(new Security(1, "Facebook", 45.40, 8.0));
			secList.add(new Security(2, "GE", 76.50, 7.0));
			secList.add(new Security(3, "LinkedIn", 45.50, 11.0));
			secList.add(new Security(4, "Walmart", 155.00, 6.0));
			
			for(int i=0;i<secList.size();i++) {
				ps.setInt(1, (secList.get(i)).getISIN());
				ps.setString(2, (secList.get(i)).getSecurityName());
				ps.setDouble(3, (secList.get(i)).getMarketPrice());
				ps.setDouble(4, (secList.get(i)).getBorrowingRate());
				rowsAdded += ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

}
