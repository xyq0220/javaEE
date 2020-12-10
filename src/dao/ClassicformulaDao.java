package dao;

import java.sql.*;
import java.util.*;

import po.Classicformula;
import util.DbUtil;


public class ClassicformulaDao{
	
	private Connection conn=null;
	private Statement stm=null;
	private ResultSet rs=null;
	private PreparedStatement pstm=null;
	
	//增
	public void addClassicformul(Classicformula cla) {
		
		DbUtil dbUtil = null;
		try {
			dbUtil = new DbUtil();
			conn=dbUtil.getConnection();
			String sql="insert into classicformula(name,usage1,comment)values(?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,cla.getName());
			pstm.setString(2,cla.getUsage());
			pstm.setString(3,cla.getComment());
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
		}
		
	}
	
	//改
	public void updateClassicformul(Classicformula cla){

		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "update classicformula set name=?,usage1=?,comment=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cla.getName());
			pstm.setString(2,cla.getUsage());
			pstm.setString(3,cla.getComment());
			pstm.setInt(4, cla.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	//查全部
	public List<Classicformula> query() {
		DbUtil dbUtil = null;
		List<Classicformula> claList = new ArrayList<Classicformula>();
		try {
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql="select * from classicformula";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				Classicformula cla=new Classicformula();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setUsage(rs.getString("usage1"));
				cla.setComment(rs.getString("comment"));
				claList.add(cla);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
		}
		return claList;
	}
	
	
	public List<Classicformula> queryList(String name) {
		DbUtil dbUtil = null;
		List<Classicformula> claList = new ArrayList<Classicformula>();
		name="%"+name+"%";
		try {
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql="select * from classicformula where name like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			while(rs.next()) {
				Classicformula cla=new Classicformula();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setUsage(rs.getString("usage1"));
				cla.setComment(rs.getString("comment"));
				claList.add(cla);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
		}
		return claList;
	}
	
	//查单条，根据id查询
	public Classicformula getClassicformula(int id){
		DbUtil dbUtil = null;
		Classicformula cla = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformula where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				cla = new Classicformula();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setUsage(rs.getString("usage1"));
				cla.setComment(rs.getString("comment"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cla;
	}
	
	
	//根据name查询
	public Classicformula query(String name){
		DbUtil dbUtil = null;
		Classicformula cla = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformula where name =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			if(rs.next()){
				cla = new Classicformula();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setUsage(rs.getString("usage1"));
				cla.setComment(rs.getString("comment"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cla;
	}
	
	//根据id，name查询
	public Classicformula query(int id,String name){
		DbUtil dbUtil = null;
		Classicformula cla = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformula where id =?cand name=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			rs = pstm.executeQuery();
			if(rs.next()){
				cla = new Classicformula();
				cla.setId(rs.getInt("id"));
				cla.setName(rs.getString("name"));
				cla.setUsage(rs.getString("usage1"));
				cla.setComment(rs.getString("comment"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cla;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//删
public void deleteClassicformula(int id){
		
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from classicformula where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
	}

public Classicformula queryById(int id) {
	// TODO Auto-generated method stub
	return null;
}







	
}