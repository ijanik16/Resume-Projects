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
import user.domain.crimes;

public class complexQ2Dao {
	//private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	//private String jdbcUsername = "root";
	//private String jdbcPassword = "madRID4598";
	
	private static final String SELECT = "select count(p.gender) as Total " + 
                                         "from policeRegister p "+
			                             "join crimes c "+
                                         "on p.policeID = c.policeID "+
			                             "join criminal cr "+
                                         "on c.criminalID = cr.criminalID "+
			                             "where cr.gender = 'female';";
	/*protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void complexOne() {
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				System.out.println("Total Number of Police that targeted Females: " + rs.getString("Total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}*/
	
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
				System.out.println("Total Number of Police that targeted Females: " + resultSet.getString("Total"));
	    		list.add(resultSet.getString("Total"));
			 }
			 
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	
	/*
	public List<Object> select() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Object> crime = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				System.out.println(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crime;
	}*/
	

}
