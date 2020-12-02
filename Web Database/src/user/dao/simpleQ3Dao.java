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
import user.domain.sQ1;
import user.domain.sQ2;
import user.domain.sQ3;

public class simpleQ3Dao {
	private static final String SELECT = "SELECT distinct crimeType, count(distinct crimeType) as Total " + 
                                         "from crimes "+
                                         "group by crimeType;";
	
	
	
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
				System.out.println("count the number total of crimeTypes: " + resultSet.getInt("Total"));
				String crimeType = resultSet.getString("crimeType");
				int Total = resultSet.getInt("Total");
	    		list.add(new sQ3(crimeType,Total));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	

}
