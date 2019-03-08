package com.blue.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 与数据库建立连接
 * @author Administrator
 *
 */
public class Util {
	
	public Connection getConn(){
		Connection conn=null;
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			new com.mysql.jdbc.Driver();
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dome","root","1234");
			 									//"jdbc:mysql://localhost:3306/dome","root","1234"
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}	
	

}
