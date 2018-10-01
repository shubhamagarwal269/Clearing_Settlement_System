package com.example.ubuntu.clearing_settlement_system;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {
    private static final String LOG = "DEBUG";
    private static String ip = "192.168.0.104";
    private static String port = "1433";
    private static String db = "Testing";
    private static String un = "sa";
    private static String password = "";
    public static Connection connect() {
        Connection conn = null;
        try {
             String ConnURL = "jdbc:sqlserver://" + ip +":"+port+";"
                    + "databaseName=" + db;
            conn = DriverManager.getConnection(ConnURL,un,password);
            System.out.println("Connection made successgully!!");
        } catch (SQLException e) {
            System.out.println("not successful");
            Log.d(LOG, e.getMessage());
        }
        return conn;
    }
}
