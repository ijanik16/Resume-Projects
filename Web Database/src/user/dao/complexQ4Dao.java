package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.cQ4;

public class complexQ4Dao {
	
	private static final String SELECT = "select c.crimeLocation, count(cr.arrested) as totalArrests " + 
                                         "from crimes c "+
			                             "join criminal cr "+
                                         "on c.criminalID = cr.criminalID "+
			                             "where cr.arrested = 'yes' "+
                                         "group by crimeLocation; ";
	
	//-- select top crime loactaion with the number arrest
	//select c.crimeLocation, count(cr.arrested) as totalArrests
	//from crimes c
	//join criminal cr
	//on c.criminalID = cr.criminalID
	//where cr.arrested = 'yes'
	//group by crimeLocation;
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false"
			                  ,"root","madRID4598");
			
			
			PreparedStatement preparestatement = connect.prepareStatement(SELECT); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println("Crime Location: " + resultSet.getString("crimeLocation"));
				System.out.println("total arrests: " + resultSet.getString("totalArrests"));
				String crimeLocation = resultSet.getString("crimeLocation");
				int totalArrests = resultSet.getInt("totalArrests");
	    		list.add(new cQ4(crimeLocation,totalArrests));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	

}
