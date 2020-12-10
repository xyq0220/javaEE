package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import po.*;
import util.DbUtil;

public class TcmrelationDao {
	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rs = null;
	private PreparedStatement pstm = null;
	
	public void addTcmrelation(Tcmrelation tr){

		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "insert into tcmrelation(chuchu,content,tcmid)values(?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, tr.getChuchu());
			pstm.setString(2, tr.getContent());
			pstm.setInt(3, tr.getTcmid());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	public void updateTcmrelation(Tcmrelation tr){

		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn = dbUtil.getConnection();
			String sql = "update tcmrelation set chuchu=?,content=?,tcmid=? where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,tr.getChuchu());
			pstm.setString(2,tr.getContent());
			pstm.setInt(3,tr.getTcmid());
			pstm.setInt(4,tr.getId());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}				
	}
	
	public List<Tcmrelation> getTcmrelationsList(){
		DbUtil dbUtil = null;
		List<Tcmrelation> trList = new ArrayList<Tcmrelation>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from tcmrelation";
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()){
				Tcmrelation tr = new Tcmrelation();
				tr.setId(rs.getInt("id"));
				tr.setChuchu(rs.getString("chuchu"));
				tr.setContent(rs.getString("content"));
				tr.setTcmid(rs.getInt("tcmid"));
				trList.add(tr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closeStatement(stm);
			dbUtil.closeConnection(conn);
			
		}		
		return trList;
	}
	
	public List<Tcmrelation> getTcmrelationListByTcmId(int tcmid){
		DbUtil dbUtil = null;
		List<Tcmrelation> trList = new ArrayList<Tcmrelation>();
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from tcmrelation where tcmid = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, tcmid);
			rs = pstm.executeQuery();
			while(rs.next()){
				Tcmrelation tr = new Tcmrelation();
				tr.setId(rs.getInt("id"));
				tr.setChuchu(rs.getString("chuchu"));
				tr.setContent(rs.getString("content"));
				tr.setTcmid(rs.getInt("tcmid"));
				trList.add(tr);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return trList;
	}
	
	public Tcmrelation getTcmrelation(int id){
		DbUtil dbUtil = null;
		Tcmrelation tr = null ;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "select * from tcmrelation where id =?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				tr = new Tcmrelation();
				tr.setId(id);
				tr.setChuchu(rs.getString("chuchu"));
				tr.setContent(rs.getString("content"));
				tr.setTcmid(rs.getInt("tcmid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstm);
			dbUtil.closeConnection(conn);
			
		}		
		return tr;
	}
	
	public void deleteTcmrelation(int id){
		
		DbUtil dbUtil = null;
		try{
			dbUtil = new DbUtil();
			conn  = dbUtil.getConnection();
			String sql = "delete from tcmrelation where id =?";
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
