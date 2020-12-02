package user.domain;

public class criminal {

	private int criminalID;
	private String criminalName;
	private int age;
	private String gender;
	private String arrested;
	
public criminal(){
		
	}
	
	//constructor
	public criminal(int criminalID,String criminalName, int age, String gender, String arrested) {
		this.criminalID = criminalID;
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.arrested = arrested;
	}
	
	public criminal(String criminalName, int age, String gender, String arrested) {
		super();
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.arrested = arrested;
	}
	

	
	//set and get for crimeType
	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	} 
	public String getCriminalName() {
		return criminalName;
	}
	
	//set and get for crimeLocation
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	//set and get for policeID
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	
	public void setArrested(String arrested) {
		this.arrested = arrested;
	}
	public String getArrested() {
		return arrested;
	}
	
	
	//set and get for criminalID
	public void setCriminalID(int criminalID) {
		this.criminalID = criminalID;
	}
	public int getCriminalID() {
		return criminalID;
	}

}
