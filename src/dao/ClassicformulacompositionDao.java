package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import po.*;
import util.*;

public class ClassicformulacompositionDao {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	/*添加经方组成*/
	public void addClassicformulacomposition(Classicformulacomposition cfc) {
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "insert into classicformulacomposition(cfid,tcmid,dosage,usage1)values(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,cfc.getCfid());
			pstm.setInt(2,cfc.getTcmid());
			pstm.setString(3,cfc.getDosage());
			pstm.setString(4,cfc.getUsage());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}	
	}
	
	/*修改经方组成*/
	public void updateClassicformulacomposition(Classicformulacomposition cfc){
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "update classicformulacomposition set cfid=?,tcmid=?,dosage=?,usage1=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,cfc.getCfid());
			pstm.setInt(2,cfc.getTcmid());
			pstm.setString(3,cfc.getDosage());
			pstm.setString(4,cfc.getUsage());
			pstm.setInt(5, cfc.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public List<Classicformulacomposition> getClassicformulacompositionList(){
		DbUtil dbUtil = null;
		List<Classicformulacomposition> cfcList = new ArrayList<Classicformulacomposition>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Classicformulacomposition cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
				cfcList.add(cfc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfcList;
	}
	
	
	
	/*根据经方id查询经方组成*/
	public List<Classicformulacomposition> getClassicformulacompositionListByCfId(int cfid){
		DbUtil dbUtil = null;
		List<Classicformulacomposition> cfcList = new ArrayList<Classicformulacomposition>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition where cfid=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cfid);
			rs = pstm.executeQuery();
			while(rs.next()){
				Classicformulacomposition cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
				cfcList.add(cfc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfcList;
	}
	
	/*根据经方组成id查询某一经方组成*/
	public Classicformulacomposition getClassicformulacomposition(String name){
		DbUtil dbUtil = null;
		Classicformulacomposition cfc = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition where name =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			if(rs.next()){
				cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfc;
	}
	
	public Classicformulacomposition getClassicformulacomposition(int id){
		DbUtil dbUtil = null;
		Classicformulacomposition cfc = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfc;
	}
	
	public Classicformulacomposition queryByTcmid(int tcmid){
		DbUtil dbUtil = null;
		Classicformulacomposition cfc = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition where tcmid =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, tcmid);
			rs = pstm.executeQuery();
			if(rs.next()){
				cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfc;
	}
	
	public Classicformulacomposition queryExist(int tcmid,int cfid){
		DbUtil dbUtil = null;
		Classicformulacomposition cfc = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from classicformulacomposition where tcmid=? and cfid=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, tcmid);
			pstm.setInt(2, cfid);
			rs = pstm.executeQuery();
			if(rs.next()){
				cfc = new Classicformulacomposition();
				cfc.setId(rs.getInt("id"));
				cfc.setCfid(rs.getInt("cfid"));
				cfc.setTcmid(rs.getInt("tcmid"));
				cfc.setDosage(rs.getString("dosage"));
				cfc.setUsage(rs.getString("usage1"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return cfc;
	}
	
	/*删除某一条经方组�?*/
	public void deleteClassicformulacomposition(int id){
		
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from classicformulacomposition where id =?";
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

}
