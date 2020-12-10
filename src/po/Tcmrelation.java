package po;

public class Tcmrelation {
	private int id;
	private String chuchu;
	private String content;
	private int tcmid;
	
	public Tcmrelation() {
		// TODO Auto-generated constructor stub
	}

	public Tcmrelation(int id,String chuchu,String content,int tcmid) {
		this.id=id;
		this.chuchu=chuchu;
		this.content=content;
		this.tcmid=tcmid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChuchu() {
		return chuchu;
	}

	public void setChuchu(String chuchu) {
		this.chuchu = chuchu;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTcmid() {
		return tcmid;
	}

	public void setTcmid(int tcmid) {
		this.tcmid = tcmid;
	}
	
}
