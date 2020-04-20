package db.connection.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	//S9HHYQdP81
		//7mR2jSrEgT
		//benim
		//JDIoyUFyCD
		//qVwkBstQ5U

	private final static String dbHost = "jdbc:mysql://remotemysql.com:3306/JDIoyUFyCD?useSSL=false";
	private final static String userName = "JDIoyUFyCD";
	private final static String password = "qVwkBstQ5U";
	private final static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	private static Connection connection = null;
	
	public static Connection getDbConnection() {
		
		try {
			if(connection == null) {
				
				Class.forName(jdbcDriver);
				connection = DriverManager.getConnection(dbHost, userName, password);
			}
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
