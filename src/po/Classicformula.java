package po;

public class Classicformula {
	private int id;
	private String name;
	private String usage;
	private String comment;
	
	public Classicformula() {
		
	}
	
	public Classicformula(int id,String name,String usage,String comment) {
		this.setId(id);
		this.setName(name);
		this.setUsage(usage);
		this.setComment(comment);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}





}
