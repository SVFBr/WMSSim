package com.ssi.schaefer.yanbal.util.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

public class DatabaseQueries  {


	public static List<HashMap<String, String>> executeQuery(String query, String wamasHostIp) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		ResultSetMetaData md = null;
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		conn = SendByConn.getConnection(wamasHostIp);
		statement = conn.prepareStatement(query);
		rs = statement.executeQuery();
		md = rs.getMetaData();
		int columns = md.getColumnCount();

		while (rs.next()) {
			HashMap<String, String> row = new HashMap<String, String>(columns);
			for (int i = 1; i <= columns; i++) {
				row.put(md.getColumnName(i), rs.getString(i));
			}
			list.add(row);
		}
		return list;
	}
}
