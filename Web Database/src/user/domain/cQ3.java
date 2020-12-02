package user.domain;

public class cQ3 {
	/*
	 * Correspond to the crimes table
	 */
	
	//crimeID INT PRIMARY KEY
	//crimeType VARCHAR(50)
	//crimeLocation VARCHAR(50)
	//policeID INT
	//criminalID INT
	
	
	private String criminalName;
	private int criminalID;
	
	public cQ3(){
		
	}
	
	public cQ3(String criminalName, int criminalID){
		this.criminalName = criminalName;
		this.criminalID = criminalID;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getCriminalID() {
		return criminalID;
	}

	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}
	
	
	
	

}
