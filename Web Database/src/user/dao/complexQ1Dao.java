package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class complexQ1Dao {
	//private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	//private String jdbcUsername = "root";
	//private String jdbcPassword = "madRID4598";
	
	private static final String SELECT = "select count(p.gender) as Total " + 
                                         "from policeRegister p "+
			                             "join crimes c "+
                                         "on p.policeID = c.policeID "+
			                             "join criminal cr "+
                                         "on c.criminalID = cr.criminalID "+
			                             "where cr.gender = 'male';";
	
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false"
			                  ,"root","madRID4598");
			
			
			//String sql = "select * from tb_user";
			PreparedStatement preparestatement = connect.prepareStatement(SELECT); 
			ResultSet resultSet = preparestatement.executeQuery();
			
			while(resultSet.next()){
				System.out.println("Total Number of Police that targeted Males: " + resultSet.getString("Total"));
	    		list.add(resultSet.getString("Total"));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}

	

}
