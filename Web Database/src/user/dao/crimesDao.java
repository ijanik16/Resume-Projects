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

 


public class crimesDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "madRID4598";

	private static final String INSERT_CRIMES_SQL = "INSERT INTO crimes" + "  (crimeID,crimeType,crimeLocation,policeID,criminalID) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_CRIMES_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_CRIMES = "select * from crimes";
	private static final String DELETE_CRIMES_SQL = "delete from crimes where crimeID = ?;";
	private static final String UPDATE_CRIMES_SQL = "update crimes set crimeType = ?,crimeLocation= ?, policeID =?, criminalID =? where crimeID = ?;";
	
	public crimesDao() {
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
	
	public void insertCrime(crimes crime) throws SQLException {
		System.out.println(INSERT_CRIMES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CRIMES_SQL)) {
			preparedStatement.setInt(1, crime.getCrimeID());
			preparedStatement.setString(2, crime.getCrimeType());
			preparedStatement.setString(3, crime.getCrimeLocation());
			preparedStatement.setInt(4, crime.getPoliceID());
			preparedStatement.setInt(5, crime.getCriminalID());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<crimes> selectAllCrimes() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<crimes> crime = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CRIMES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int crimeID = rs.getInt("crimeID");
				String crimeType = rs.getString("crimeType");
				String crimeLocation = rs.getString("crimeLocation");
				int policeID = rs.getInt("policeID");
				int criminalID = rs.getInt("criminalID");
				crime.add(new crimes(crimeID, crimeType, crimeLocation, policeID, criminalID));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crime;
	}
	
	
	//crimeType = ?,crimeLocation= ?, policeID =?, criminalID =? where crimeID = ?
	public boolean updateCrime(crimes crime) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CRIMES_SQL);) {
			statement.setString(1, crime.getCrimeType());
			statement.setString(2, crime.getCrimeLocation());
			statement.setInt(3, crime.getPoliceID());
			statement.setInt(4, crime.getCriminalID());
			statement.setInt(5, crime.getCrimeID());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteCrime(int crimeID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CRIMES_SQL);) {
			statement.setInt(1, crimeID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public crimes selectCrime(int crimeID) {
		crimes crime = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CRIMES_BY_ID);) {
			preparedStatement.setInt(1, crimeID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String crimeType = rs.getString("crimeType");
				String crimeLocation = rs.getString("crimeLocation");
				int policeID = Integer.parseInt(rs.getString("policeID"));
				int criminalID = Integer.parseInt(rs.getString("criminalID"));
				crime = new crimes(crimeID, crimeType, crimeLocation, policeID, criminalID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return crime;
	}
	

		
}
