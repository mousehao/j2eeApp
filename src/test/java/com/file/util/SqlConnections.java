package com.file.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by huawei on 2016/4/7.
 */
public class SqlConnections {
	public static String connStr="jdbc:mysql://localhost:3306/tempdb";
	public static String user="root";
	public static String password="root";
	public static Connection conn=null;
	private SqlConnections(){}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(connStr,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return conn;
	}


}
