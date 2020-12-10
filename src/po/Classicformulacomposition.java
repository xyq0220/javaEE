package po;

public class Classicformulacomposition {
	private int id;
	private int cfid;
	private int tcmid;
	private String dosage;
	private String usage;
	
	public Classicformulacomposition() {
		
	}
	
	public Classicformulacomposition(int id,int cfid,int tcmid,String dosage,String usage) {
		this.id = id;
		this.cfid = cfid;
		this.tcmid = tcmid;
		this.dosage = dosage;
		this.usage = usage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCfid() {
		return cfid;
	}

	public void setCfid(int cfid) {
		this.cfid = cfid;
	}

	public int getTcmid() {
		return tcmid;
	}

	public void setTcmid(int tcmid) {
		this.tcmid = tcmid;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}
}
