package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import user.domain.User;
import user.domain.cQ3;
import user.domain.crimes;

public class complexQ3Dao {
	//private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	//private String jdbcUsername = "root";
	//private String jdbcPassword = "madRID4598";
	
	private static final String SELECT = "select cr.criminalName, cr.criminalID " + 
                                         "from criminal cr "+
			                             "join crimes c "+
                                         "on cr.criminalID = c.criminalID "+
			                             "where cr.age < '20' and c.crimeLocation = 'West Chicago'; ";
	
	//select cr.criminalName, cr.criminalID
	//from criminal cr 
	//join crimes c
	//on cr.criminalID = c.criminalID
	//where cr.age < '20' and c.crimeLocation = 'West Chicago';
	
	
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
				System.out.println("Criminal Name: " + resultSet.getString("criminalName"));
				System.out.println("Criminal ID: " + resultSet.getString("criminalID"));
	    		//list.add(resultSet.getString("criminalName") + ", " + resultSet.getString("criminalID"));
				//list.add(resultSet.getString("criminalName"));
	    		//list.add(resultSet.getString("criminalID"));
				String criminalName = resultSet.getString("criminalName");
				int criminalID = resultSet.getInt("criminalID");
	    		list.add(new cQ3(criminalName,criminalID));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	

}
