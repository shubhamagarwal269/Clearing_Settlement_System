package com.connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection con;
	static public Connection openConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver Loaded Successfully");
			//con = DriverManager.getConnection("jdbc:sqlserver://sql5007.site4now.net;databaseName=DB_A40FBC_cns065918", "DB_A40FBC_cns065918_admin","Admin_1234");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ClearingSettlement", "sa","Mssql@81326");
			System.out.println("Connection Done Successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
