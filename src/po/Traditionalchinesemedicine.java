package po;

public class Traditionalchinesemedicine {
	private int id;
	private int number;
	private String name;
	private String alias;
	private int type;
	private String bjyw;
	private String zhuzhi;
	private String xingwei;
	private String chandi;
	private String dosage;
	private String taboo;
	private String processing;
	private String note;
	
	public Traditionalchinesemedicine() {
		// TODO Auto-generated constructor stub
	}
	
	public Traditionalchinesemedicine(int id,int number,String name,String alias,int type,String bjyw,String zhuzhi,String xingwei,String chandi,String dosage,String taboo,String processing,String note) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.number=number;
		this.name=name;
		this.alias=alias;
		this.type=type;
		this.bjyw=bjyw;
		this.zhuzhi=zhuzhi;
		this.xingwei=xingwei;
		this.chandi=chandi;
		this.dosage=dosage;
		this.taboo=taboo;
		this.processing=processing;
		this.note=note;
	}

	public String getProcessing() {
		return processing;
	}

	public void setProcessing(String processing) {
		this.processing = processing;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public int getType() {
		return type;
	}
	
	public String getTypeToString() {
		if(type==1) return "上经";
		if(type==2) return "中经";
		if(type==3) return "下经";
		return "增补";
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBjyw() {
		return bjyw;
	}

	public void setBjyw(String bjyw) {
		this.bjyw = bjyw;
	}

	public String getZhuzhi() {
		return zhuzhi;
	}

	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}

	public String getXingwei() {
		return xingwei;
	}

	public void setXingwei(String xingwei) {
		this.xingwei = xingwei;
	}

	public String getChandi() {
		return chandi;
	}

	public void setChandi(String chandi) {
		this.chandi = chandi;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getTaboo() {
		return taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}	
	
	

}
