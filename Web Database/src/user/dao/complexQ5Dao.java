package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.domain.cQ4;
import user.domain.cQ5;

public class complexQ5Dao {
	//-- select avg(age) of criminal who been arrested in west chicago
	private static final String SELECT = "select avg(cr.age) as averageAge " + 
                                         "from criminal cr "+
			                             "join crimes c "+
                                         "on cr.criminalID = c.criminalID "+
			                             "where c.crimeLocation = 'West Chicago'; ";
	
	
	
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
				System.out.println("Average criminal Age in West Chicago: " + resultSet.getString("averageAge"));
				int averageAge = resultSet.getInt("averageAge");
	    		list.add(new cQ5(averageAge));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	

}
