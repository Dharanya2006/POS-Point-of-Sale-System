package com.wipro.pos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection getDBConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Oracle JDBC Driver not found", e);
        }
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "dharanya";
        String pass = "242006";
        Connection con = DriverManager.getConnection(url, user, pass);
        con.setAutoCommit(false);
        return con;
    }
}