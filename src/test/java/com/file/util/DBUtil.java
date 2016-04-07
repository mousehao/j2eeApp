package com.file.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by huawei on 2016/4/7.
 */
public class DBUtil {
	public static void executeSql(String sql){
		Connection conn=null;
		Statement statement=null;
		try {
			conn=SqlConnections.getConnection();
			statement=conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
