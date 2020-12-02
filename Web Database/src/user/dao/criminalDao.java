 package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import user.domain.criminal;

 


public class criminalDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "madRID4598";

	private static final String INSERT_CRIMINAL_SQL = "INSERT INTO criminal" + "  (criminalID,criminalName,age,gender,arrested) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_CRIMINAL_BY_ID = "select criminalID,criminalName,age,gender,arrested from criminal where criminalID =?";
	private static final String SELECT_ALL_CRIMINAL = "select * from criminal";
	private static final String DELETE_CRIMINAL_SQL = "delete from criminal where criminalID = ?;";
	private static final String UPDATE_CRIMINAL_SQL = "update criminal set criminalName = ?,age= ?, gender =?, arrested =? where criminalID = ?;";
	
	public criminalDao() {
	}

	protected Connection getConnection() {
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
	
	public void insertCriminal(criminal criminal) throws SQLException {
		System.out.println(INSERT_CRIMINAL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CRIMINAL_SQL)) {
			preparedStatement.setInt(1, criminal.getCriminalID());
			preparedStatement.setString(2, criminal.getCriminalName());
			preparedStatement.setInt(3, criminal.getAge());
			preparedStatement.setString(4, criminal.getGender());
			preparedStatement.setString(5, criminal.getArrested());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<criminal> selectAllCriminal() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<criminal> criminal = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CRIMINAL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer criminalID = rs.getInt("criminalID");
				String criminalName = rs.getString("criminalName");
				Integer age = rs.getInt("age");
				String gender = rs.getString("gender");
				String arrested = rs.getString("arrested");
				criminal.add(new criminal(criminalID, criminalName, age, gender, arrested));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criminal;
	}
	
	
	//crimeType = ?,crimeLocation= ?, policeID =?, criminalID =? where crimeID = ?
	public boolean updateCriminal(criminal criminal) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CRIMINAL_SQL);) {
			statement.setInt(1, criminal.getCriminalID());
			statement.setString(2, criminal.getCriminalName());
			statement.setInt(3, criminal.getAge());
			statement.setString(4, criminal.getGender());
			statement.setString(5, criminal.getArrested());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteCriminal(int criminalID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CRIMINAL_SQL);) {
			statement.setInt(1, criminalID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public criminal selectCriminal(int criminalID) {
		criminal criminals = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CRIMINAL_BY_ID);) {
			preparedStatement.setInt(1, criminalID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String criminalName = rs.getString("criminalName");
				int age = Integer.parseInt(rs.getString("age"));
				String gender = rs.getString("gender");
				String arrested = rs.getString("arrested");
				criminals = new criminal(criminalName, age, gender, arrested);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criminals;
	}
	

		
}
