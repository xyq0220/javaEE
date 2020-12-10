package service;

import java.util.List;

import dao.ClassicformulaDao;
import po.Classicformula;


public class ClassicformulaService {
	private ClassicformulaDao claDao = new ClassicformulaDao();
	
	
	//public List<Classicformula> query(){
//		List claList = claDao.query();
//		return claList;
//	}
	
	
	public List<Classicformula> query(){
		List<Classicformula> claList = (List<Classicformula>) claDao.query();
		return claList;
	}
	
	public List<Classicformula> queryList(String name){
		List<Classicformula> claList = (List<Classicformula>) claDao.queryList(name);
		return claList;
	}
	
	public Classicformula queryById(int id) {
		Classicformula cla = claDao.getClassicformula(id);
		return cla;
	}
	
	public Classicformula queryByName(String name) {
		Classicformula cla = claDao.query(name);
		return cla;
	}
	/**
	 * 添加的业务逻辑处理
	 * @param stu
	 */
	public void addClassicformul(Classicformula cla) {
		//1 先判断cla是否有值
		if(cla!=null && cla.getName()!=null) {
			//2 判断该经方名是否存在数据库中
			boolean isExist =true;
			Classicformula s=claDao.query(cla.getName());
			if(s==null) {
				isExist = false;
			}
			//3不存在，才add
			if(!isExist) {
				claDao.addClassicformul(cla);
			}
		}
	}
	/**
	 *     修改的业务逻辑处理
	 * @param stu
	 */
	public void updateClassicformul(Classicformula cla) {
		//1 先判断cla是否有值
		if(cla!=null && cla.getName()!=null) {
			//2 判断该经方名是否存在数据库中
			boolean isExist = true;
			Classicformula s = claDao.query(cla.getId(),cla.getName());
			if(s==null) {
				isExist = false;
			}
			//3不存在，才add
			if(!isExist) {
				claDao.updateClassicformul(cla);
			}
		}
	}

}
