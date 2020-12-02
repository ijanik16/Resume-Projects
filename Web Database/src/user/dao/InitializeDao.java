 package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 


public class InitializeDao {
	

	public void initDB() {
		Statement statement; 
		Statement popStatement;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager
			          .getConnection("jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false"
			        		  ,"root","madRID4598");
		    
		
			statement = connect.createStatement();
			statement.executeUpdate("Drop TABLE IF EXISTS crimes");
			
			String sqlstat = "CREATE TABLE IF NOT EXISTS crimes" +
					"(crimeID INT PRIMARY KEY, " +
					" crimeType VARCHAR(50), " +
					" crimeLocation VARCHAR(50), " +
					" policeID INT, " +
					" criminalID INT)";
			statement.executeUpdate(sqlstat);
			
			
			popStatement = connect.createStatement();
			String sqlins = "INSERT INTO crimes(crimeID, crimeType, crimeLocation, policeID, criminalID) VALUES "
					+ "(1111, 'theft', 'West Loop', 1414, 9999), "
					+ "(2222, 'murder', 'Michigan Avenue', 1313, 9989), "
					+ "(3333, 'public intoxication', 'Linkin Park', 1212, 9949); ";
			popStatement.executeUpdate(sqlins);
		    
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		
}
