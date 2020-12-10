package util;

import java.sql.*;

/**
 * 
 * @author xiazq
 *
 */
public class DbUtil {
	
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://172.17.1.41:3306/javaeedb?useUnicode=true&characterEncoding=UTF-8";
	private String dbUser = "javaee";
	private String dbPwd = "1234";
	
	public DbUtil() {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection con){
		try{
			if(con!=null) {
			con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void closeStatement(Statement stm){
		try{
			if(stm!=null) {
			stm.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement pstm){
		try{
			if(pstm!=null) {
			pstm.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs){
		try{
			if(rs!=null) {
			rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(Connection con,Statement stmt,ResultSet rs){
		try{
			if(rs!=null) {
			rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(stmt!=null) {
			stmt.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			if(con!=null) {
			con.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
