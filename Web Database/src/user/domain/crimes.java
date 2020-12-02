package user.domain;

public class crimes {
	/*
	 * Correspond to the crimes table
	 */
	
	//crimeID INT PRIMARY KEY
	//crimeType VARCHAR(50)
	//crimeLocation VARCHAR(50)
	//policeID INT
	//criminalID INT
	
	private int crimeID;
	private String crimeType;
	private String crimeLocation;
	private int policeID;
	private int criminalID;
	
	public crimes(){
		
	}
	
	//constructor
	public crimes(int crimeID,String crimeType, String crimeLocation,int policeID, int criminalID) {
		this.crimeID = crimeID;
		this.crimeType = crimeType;
		this.crimeLocation = crimeLocation;
		this.policeID = policeID;
		this.criminalID = criminalID;
	}
	
	public crimes(String crimeType, String crimeLocation,int policeID, int criminalID) {
		super();
		this.crimeType = crimeType;
		this.crimeLocation = crimeLocation;
		this.policeID = policeID;
		this.criminalID = criminalID;
	}
	
	//set and get for crimeID
	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}
	public int getCrimeID() {
		return crimeID;
	}
	
	//set and get for crimeType
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	} 
	public String getCrimeType() {
		return crimeType;
	}
	
	//set and get for crimeLocation
	public void setCrimeLocation(String crimeLocation) {
		this.crimeLocation = crimeLocation;
	}
	public String getCrimeLocation() {
		return crimeLocation;
	}
	
	//set and get for policeID
	public void setPoliceID(int policeID) {
		this.policeID = policeID;
	}
	public int getPoliceID() {
		return policeID;
	}
	
	//set and get for criminalID
	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}
	public int getCriminalID() {
		return criminalID;
	}
	

}
