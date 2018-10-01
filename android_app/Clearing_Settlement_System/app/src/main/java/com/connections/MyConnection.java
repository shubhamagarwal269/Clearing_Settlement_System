package com.connections;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	private static Connection con;

	static public Connection openConnection() {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		Connection connection = null;
		String ConnectionURL = null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			ConnectionURL = "jdbc:jtds:sqlserver://sql5007.site4now.net;database=DB_A40FBC_cns065918;user=DB_A40FBC_cns065918_admin;password=Admin_1234";
//			ConnectionURL = "jdbc:sqlserver://localhost:1433;databaseName=ClearingSettlement;user=sa;password=sa123";
			connection = DriverManager.getConnection(ConnectionURL);
		} catch (SQLException se) {
			Log.e("error here 1 : ", se.getMessage());
		} catch (ClassNotFoundException e) {
			Log.e("error here 2 : ", e.getMessage());
		} catch (Exception e) {
			Log.e("error here 3 : ", e.getMessage());
		}
		return connection;
	}
}
