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

public class simpleQ2Dao {
	private static final String SELECT = "SELECT MAX(age) as OldestCriminalAge " + 
                                         "from criminal; ";
	
	
	
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
				System.out.println("top criminal Age: " + resultSet.getString("OldestCriminalAge"));
				int OldestCriminalAge = resultSet.getInt("OldestCriminalAge");
	    		list.add(new sQ2(OldestCriminalAge));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	

}
