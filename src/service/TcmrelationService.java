package service;
import java.util.*;

import dao.TcmrelationDao;
import po.Tcmrelation;
public class TcmrelationService {
	TcmrelationDao trDao=new TcmrelationDao();
	
	public List<Tcmrelation> query(){
		List<Tcmrelation> trList = trDao.getTcmrelationsList();
		return trList;
	}
	
	public List<Tcmrelation> queryByTcmId(int tcmid){
		List<Tcmrelation> trList = trDao.getTcmrelationListByTcmId(tcmid);
		return trList;
	}
	
	public Tcmrelation queryById(int id){
		Tcmrelation tr = trDao.getTcmrelation(id);
		return tr;
	}
	
	public void add(Tcmrelation tr) {
		if(tr!=null) {
			trDao.addTcmrelation(tr);
		}
	}

}
