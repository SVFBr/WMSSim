package com.ssi.schaefer.yanbal.util.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class SendByConn {

	public static Connection getConnection(String wamasHostIp) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@" + wamasHostIp + ":1521:PEEM";
		String userName = "pwx_app";
		String password = "pwx";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = (Connection) DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
