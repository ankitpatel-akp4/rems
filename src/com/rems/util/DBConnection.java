/**
 * 
 */
package com.rems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author indicate0
 *
 */
public class DBConnection {
	public static Connection getDBConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/rems";
		String userName = "root";
		String password = "ankit0";
		conn = DriverManager.getConnection(url, userName, password);

		return conn;
	}
}
