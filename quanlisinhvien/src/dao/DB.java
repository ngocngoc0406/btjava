package dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection ConnectDB() {
		Connection conn= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-AMODOF8\\NGOC:1433;user=sa;password=123456;databaseName=BankManagement;encrypt=true;trustServerCertificate=true;");
			
		} catch (Exception e2) {
			e2.printStackTrace();
			
		}
	return conn;
	}
	public static void main(String[] args) {
	System.out.println(DB.ConnectDB());
	}
}

