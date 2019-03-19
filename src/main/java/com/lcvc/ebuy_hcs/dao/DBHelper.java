package com.lcvc.ebuy_hcs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * 数据库通用类
 */
public final class DBHelper {
	// 获取数据库Connection对象
	public static Connection getConnection() {
		String driver="com.mysql.jdbc.Driver";//驱动类
		String url="jdbc:mysql://localhost:3306/ebuy1?characterEncoding=utf-8";//数据库连接地址
		String username="user";//数据库连接所需账户名
		String password="123456";//数据库连接所需密码
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 定义关闭数据库方法
	public static void closeConn(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 定义关闭数据库方法
	public static void closeConn( PreparedStatement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// 定义关闭PreparedStatement方法
	public static void closePreparedStatement(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// 定义关闭PreparedStatement方法
	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
}
