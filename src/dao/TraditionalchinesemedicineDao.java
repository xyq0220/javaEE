package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import po.*;
import util.DbUtil;

public class TraditionalchinesemedicineDao {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	public void addTraditionalchinesemedicine(Traditionalchinesemedicine tcm){

		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "insert into traditionalchinesemedicine(number,name,alias,type,bjyw,zhuzhi,xingwei,chandi,dosage,taboo,processing,note)values(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,tcm.getNumber());
			pstm.setString(2,tcm.getName());
			pstm.setString(3,tcm.getAlias());
			pstm.setInt(4, tcm.getType());
			pstm.setString(5,tcm.getBjyw());
			pstm.setString(6,tcm.getZhuzhi());
			pstm.setString(7,tcm.getXingwei());
			pstm.setString(8,tcm.getChandi());
			pstm.setString(9,tcm.getDosage());
			pstm.setString(10,tcm.getTaboo());
			pstm.setString(11, tcm.getProcessing());
			pstm.setString(12, tcm.getNote());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	public void updateTraditionalchinesemedicine(Traditionalchinesemedicine tcm){

		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "update traditionalchinesemedicine set number=?,name=?,alias=?,type=?,bjyw=?,zhuzhi=?,xingwei=?,chandi=?,dosage=?,taboo=?,processing=?,note=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,tcm.getNumber());
			pstm.setString(2,tcm.getName());
			pstm.setString(3,tcm.getAlias());
			pstm.setInt(4,tcm.getType());
			pstm.setString(5, tcm.getBjyw());
			pstm.setString(6, tcm.getZhuzhi());
			pstm.setString(7, tcm.getXingwei());
			pstm.setString(8, tcm.getChandi());
			pstm.setString(9, tcm.getDosage());
			pstm.setString(10, tcm.getTaboo());
			pstm.setString(11, tcm.getProcessing());
			pstm.setString(12, tcm.getNote());
			pstm.setInt(13, tcm.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public List<Traditionalchinesemedicine> getTraditionalchinesemedicinesList(){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine order by number";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> query(int l,int r){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine order by number limit ?,?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, l);
			pstm.setInt(2, r);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}
	
	public int queryNum(){
		DbUtil dbUtil = null;
		int count=0;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select count(*) from traditionalchinesemedicine";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return count;
	}
	
	public List<Traditionalchinesemedicine> queryByName(String name){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where name like ? or alias like ? order by number";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}	

	public List<Traditionalchinesemedicine> queryByName(String name,int l,int r){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where name like ? or alias like ? order by number limit ?,?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			pstm.setInt(3, l);
			pstm.setInt(4, r);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}
	
	public int queryNumByName(String name){
		DbUtil dbUtil = null;
		int count=0;
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select count(*) from traditionalchinesemedicine where name like ? or alias like ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			rs = pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return count;
	}	
	
	public List<Traditionalchinesemedicine> queryByType(int type){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where type=? order by number";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, type);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> queryByType(int type,int l,int r){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where type=? order by number limit ?,?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, type);
			pstm.setInt(2, l);
			pstm.setInt(3, r);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}
	
	public int queryNumByType(int type){
		DbUtil dbUtil = null;
		int count=0;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select count(*) from traditionalchinesemedicine where type=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, type);
			rs = pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return count;
	}
	
	public List<Traditionalchinesemedicine> queryByNameAndType(String name,int type){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where name like ? or alias like ? and type=? order by number";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			pstm.setInt(3, type);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}	
	
	public List<Traditionalchinesemedicine> queryByNameAndType(String name,int type,int l,int r){
		DbUtil dbUtil = null;
		List<Traditionalchinesemedicine> tcmList = new ArrayList<Traditionalchinesemedicine>();
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where name like ? or alias like ? and type=? order by number limit ?,?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			pstm.setInt(3, type);
			pstm.setInt(4, l);
			pstm.setInt(5, r);
			rs = pstm.executeQuery();
			while(rs.next()){
				Traditionalchinesemedicine tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
				tcmList.add(tcm);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcmList;
	}	
	
	public int queryNumByNameAndType(String name,int type){
		DbUtil dbUtil = null;
		int count=0;
		name="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select count(*) from traditionalchinesemedicine where name like ? or alias like ? and type=? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, name);
			pstm.setInt(3, type);
			rs = pstm.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return count;
	}
	
	public Traditionalchinesemedicine getTraditionalchinesemedicine(int id){
		DbUtil dbUtil = null;
		Traditionalchinesemedicine tcm = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				tcm = new Traditionalchinesemedicine();
				tcm.setId(id);
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei(rs.getString("xingwei"));
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcm;
	}
	
	public Traditionalchinesemedicine getTraditionalchinesemedicine(String name){
		DbUtil dbUtil = null;
		Traditionalchinesemedicine tcm = null ;
		String alias="%"+name+"%";
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from traditionalchinesemedicine where name = ? or alias like ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, alias);
			rs = pstm.executeQuery();
			if(rs.next()){
				tcm = new Traditionalchinesemedicine();
				tcm.setId(rs.getInt("id"));
				tcm.setNumber(rs.getInt("number"));
				tcm.setName(rs.getString("name"));
				tcm.setAlias(rs.getString("alias"));
				tcm.setType(rs.getInt("type"));
				tcm.setBjyw(rs.getString("bjyw"));
				tcm.setZhuzhi(rs.getString("zhuzhi"));
				tcm.setXingwei("xingwei");
				tcm.setChandi(rs.getString("chandi"));
				tcm.setDosage(rs.getString("dosage"));
				tcm.setTaboo(rs.getString("taboo"));
				tcm.setProcessing(rs.getString("processing"));
				tcm.setNote(rs.getString("note"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return tcm;
	}
	
	public void deleteTraditionalchinesemedicine(int id){
		
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from traditionalchinesemedicine where id =?";
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
