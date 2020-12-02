package user.domain;

public class policeRegister {
	
	private int policeID;
	private int age;
	private String gender; 
	private String policeRank; 
	
public policeRegister(){
		
	}
	
	//constructor
	public policeRegister(int policeID, int age, String gender, String policeRank) {
		this.policeID = policeID;
		this.age = age;
		this.gender = gender;
		this.policeRank = policeRank;
	}
	
	public policeRegister(int age, String gender, String policeRank) {
		super();
		this.age = age;
		this.gender = gender;
		this.policeRank = policeRank;

	}
	
	//set and get for crimeID
	public void setPoliceID(int policeID) {
		this.policeID = policeID;
	}
	public int getPoliceID() {
		return policeID;
	}
	
	//set and get for crimeType
	public void setAge(int age) {
		this.age = age;
	} 
	public int getAge() {
		return age;
	}
	
	//set and get for crimeLocation
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	
	
	//set and get for criminalID
	public void setPoliceRank(String policeRank) {
		this.policeRank = policeRank;
	}
	public String getPoliceRank() {
		return policeRank;
	}


}
