package user.domain;

public class cQ4 {
	/*
	 * Correspond to the crimes table
	 */
	
	//crimeID INT PRIMARY KEY
	//crimeType VARCHAR(50)
	//crimeLocation VARCHAR(50)
	//policeID INT
	//criminalID INT
	
	
	private String crimeLocation;
	private int totalArrests;
	
	public cQ4(){
		
	}
	
	public cQ4(String crimeLocation, int totalArrests){
		this.setCrimeLocation(crimeLocation);
		this.setTotalArrests(totalArrests);
	}

	public String getCrimeLocation() {
		return crimeLocation;
	}

	public void setCrimeLocation(String crimeLocation) {
		this.crimeLocation = crimeLocation;
	}

	public int getTotalArrests() {
		return totalArrests;
	}

	public void setTotalArrests(int totalArrests) {
		this.totalArrests = totalArrests;
	}
	
	
	
	

}
