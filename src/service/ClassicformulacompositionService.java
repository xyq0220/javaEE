package service;
import java.util.List;

import dao.ClassicformulacompositionDao;
import po.Classicformulacomposition;

public class ClassicformulacompositionService {
	private ClassicformulacompositionDao cfcDao = new ClassicformulacompositionDao();
	
	public List<Classicformulacomposition> query(){
		List<Classicformulacomposition> cfcList = cfcDao.getClassicformulacompositionList();
		return cfcList;
	}
	
	public List<Classicformulacomposition> queryList(int cfid){
		List<Classicformulacomposition> cfcList = cfcDao.getClassicformulacompositionListByCfId(cfid);
		return cfcList;
	}
	
	public Classicformulacomposition queryById(int id) {
		Classicformulacomposition cfc  = cfcDao.getClassicformulacomposition(id);
		return cfc;
	}
	
	public void addClassicformulacomposition(Classicformulacomposition cfc) {
		if(cfc != null) {
			boolean isExist = true;
			Classicformulacomposition c = cfcDao.queryExist(cfc.getTcmid(),cfc.getCfid());
			if(c==null) {
				isExist = false;
			}
			if(!isExist) {
				cfcDao.addClassicformulacomposition(cfc);
			}	
		}
	}
	
	public void updateClassicformulacomposition(Classicformulacomposition cfc) {
		if(cfc != null) {
			boolean isExist = true;
			Classicformulacomposition c = cfcDao.getClassicformulacomposition(cfc.getId());
			if(c==null) {
				isExist = false;
			}
			if(!isExist) {
				System.out.println(3);
				cfcDao.updateClassicformulacomposition(cfc);
			}
		}
	}
}
