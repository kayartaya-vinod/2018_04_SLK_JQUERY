package com.slk.mvcapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.slk.mvcapp.dao.DaoException;

public final class DbUtil {
	private DbUtil() {
	}

	public static Connection getConnection() throws DaoException {
		try {
			String url = "jdbc:mysql://localhost:3306/mvcapp_db";
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "root";
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public static void releaseResources(Connection conn, Statement stmt, ResultSet rs) throws DaoException {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
