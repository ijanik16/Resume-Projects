package user.domain;

public class sQ3 {
	
	private String crimeType;
	private int total;
	
	public sQ3(){
		
	}
	
public sQ3(String crimeType, int total){
	this.setCrimeType(crimeType);
	this.setTotal(total);
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
