/**
 * 
 */
package com.rems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author indicate0
 *
 */
public class DBUtil {
	private static String url;
	private static String driverName;
	private static String userName;
	private static String password;
	static {

		ResourceBundle rb = ResourceBundle.getBundle("bd_credentials");

		url = rb.getString("db.url");
		driverName = rb.getString("db.drivername");
		userName = rb.getString("db.username");
		password = rb.getString("db.password");

	}

	public static Connection getDBConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url, userName, password);

		return conn;
	}
}
