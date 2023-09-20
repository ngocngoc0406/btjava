package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.Student;

public class DAOStudent {
	Statement stmt;
	Connection con;
	public DAOStudent() {
		  Connection con= DB.ConnectDB();
		  try {
			stmt= con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
//	              
	}
	public void insertToStudent(Student x) {
		String sql = "insert into student values (N'" +x.getId()+ "', N'"+x.getName()+"', N'"+x.getY_class()+"',"+x.getGba()+" )" ;
		try {
			System.out.println(sql);
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public ResultSet selectAll(String tableName) {
		ResultSet rs = null;
		String sql = "select * from " + tableName;
		try {
			
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public void deleteStudentByID(String id) {
		String sql = "delete from student where ID like "+id;
		try {
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateNameStudentByID(String id, String name) {
		String sql = "update student set name = \'"+name+"\' where id = \'" +id+"\'";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	ResultSet getStudentByID(String id, String tableName) {
		ResultSet rs = null;
		
		String sql = "select * from "+ tableName + " where ID like \'"+id+"\'";
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	ResultSet getStudentByLop(String lop, String tableName) {
		ResultSet rs = null;
		
		String sql = "select * from "+ tableName + " where ID like \'"+lop+"\'";
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
}
