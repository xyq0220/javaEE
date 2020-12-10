package service;
import java.util.*;

import dao.TraditionalchinesemedicineDao;
import po.Traditionalchinesemedicine;
public class TraditionalchinesemedicineService {
	TraditionalchinesemedicineDao tcmDao=new TraditionalchinesemedicineDao();
	
	public List<Traditionalchinesemedicine> query(){
		List<Traditionalchinesemedicine> tcmList = tcmDao.getTraditionalchinesemedicinesList();
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> queryByName(String name){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByName(name);
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> queryByType(String type){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByType(Integer.parseInt(type));
		return tcmList;
	}

	public List<Traditionalchinesemedicine> queryByNameAndType(String name,String type){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByNameAndType(name,Integer.parseInt(type));
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> query(int l,int r){
		List<Traditionalchinesemedicine> tcmList = tcmDao.query(l,r);
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> queryByName(String name,int l,int r){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByName(name,l,r);
		return tcmList;
	}
	
	public List<Traditionalchinesemedicine> queryByType(String type,int l,int r){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByType(Integer.parseInt(type),l,r);
		return tcmList;
	}

	public List<Traditionalchinesemedicine> queryByNameAndType(String name,String type,int l,int r){
		List<Traditionalchinesemedicine> tcmList = tcmDao.queryByNameAndType(name,Integer.parseInt(type),l,r);
		return tcmList;
	}
	
	public Traditionalchinesemedicine queryById(int id){
		Traditionalchinesemedicine tcm = tcmDao.getTraditionalchinesemedicine(id);
		return tcm;
	}
	
	public Traditionalchinesemedicine queryOne(String name){
		Traditionalchinesemedicine tcm = tcmDao.getTraditionalchinesemedicine(name);
		return tcm;
	}
	
	public int queryNum() {
		int tot=tcmDao.queryNum();
		return tot;
	}
	
	public int queryNumByName(String name) {
		int tot=tcmDao.queryNumByName(name);
		return tot;
	}
	
	public int queryNumByType(String type) {
		int tot=tcmDao.queryNumByType(Integer.parseInt(type));
		return tot;
	}	
	
	public int queryNumByNameAndType(String name,String type) {
		int tot=tcmDao.queryNumByNameAndType(name,Integer.parseInt(type));
		return tot;
	}
	
	public void add(Traditionalchinesemedicine tcm) {
		if(tcm!=null && tcm.getName()!=null) {
			boolean isExist = true;
			Traditionalchinesemedicine s = tcmDao.getTraditionalchinesemedicine(tcm.getName());
			if(s==null) {
				isExist = false;
			}
			if(!isExist) {
				tcmDao.addTraditionalchinesemedicine(tcm);
			}
		}
	}

}
