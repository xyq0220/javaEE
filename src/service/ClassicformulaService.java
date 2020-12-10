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
	 * ��ӵ�ҵ���߼�����
	 * @param stu
	 */
	public void addClassicformul(Classicformula cla) {
		//1 ���ж�cla�Ƿ���ֵ
		if(cla!=null && cla.getName()!=null) {
			//2 �жϸþ������Ƿ�������ݿ���
			boolean isExist =true;
			Classicformula s=claDao.query(cla.getName());
			if(s==null) {
				isExist = false;
			}
			//3�����ڣ���add
			if(!isExist) {
				claDao.addClassicformul(cla);
			}
		}
	}
	/**
	 *     �޸ĵ�ҵ���߼�����
	 * @param stu
	 */
	public void updateClassicformul(Classicformula cla) {
		//1 ���ж�cla�Ƿ���ֵ
		if(cla!=null && cla.getName()!=null) {
			//2 �жϸþ������Ƿ�������ݿ���
			boolean isExist = true;
			Classicformula s = claDao.query(cla.getId(),cla.getName());
			if(s==null) {
				isExist = false;
			}
			//3�����ڣ���add
			if(!isExist) {
				claDao.updateClassicformul(cla);
			}
		}
	}

}
