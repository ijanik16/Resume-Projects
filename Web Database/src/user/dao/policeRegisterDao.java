 package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import user.domain.policeRegister;

 


public class policeRegisterDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/chicago_crime?serverTimezone=UTC&useLegacyDatetimeCode=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "madRID4598";

	private static final String INSERT_POLICEREGISTER_SQL = "INSERT INTO policeRegister" + "  (policeID,age,gender,policeRank) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_POLICEREGISTER_BY_ID = "select policeID,age,gender,policeRank from policeRegister where policeID =?";
	private static final String SELECT_ALL_POLICEREGISTER = "select * from policeRegister";
	private static final String DELETE_POLICEREGISTER_SQL = "delete from policeRegister where policeID = ?;";
	private static final String UPDATE_POLICEREGISTER_SQL = "update policeRegister set age = ?,gender= ?, policeRank =?, where policeID = ?;";
	
	public policeRegisterDao() {
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
	
	public void insertPoliceRegister(policeRegister register) throws SQLException {
		System.out.println(INSERT_POLICEREGISTER_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_POLICEREGISTER_SQL)) {
			preparedStatement.setInt(1, register.getPoliceID());
			preparedStatement.setInt(2, register.getAge());
			preparedStatement.setString(3, register.getGender());
			preparedStatement.setString(4, register.getPoliceRank());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<policeRegister> selectAllPoliceRegister() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<policeRegister> register = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POLICEREGISTER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer age = rs.getInt("age");
				String gender = rs.getString("gender");
				String policeRank = rs.getString("policeRank");
				Integer policeID = rs.getInt("policeID");
				register.add(new policeRegister(policeID, age, gender, policeRank));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return register;
	}
	
	
	//crimeType = ?,crimeLocation= ?, policeID =?, criminalID =? where crimeID = ?
	public boolean updatePoliceRegister(policeRegister register) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_POLICEREGISTER_SQL);) {
			statement.setInt(1,register.getAge());
			statement.setString(2, register.getGender());
			statement.setInt(3, register.getPoliceID());
			statement.setString(4, register.getPoliceRank());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deletePoliceRegister(int policeID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_POLICEREGISTER_SQL);) {
			statement.setInt(1, policeID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public policeRegister selectpoliceRegister(int policeID) {
		policeRegister police = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POLICEREGISTER_BY_ID);) {
			preparedStatement.setInt(1, policeID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int age = Integer.parseInt(rs.getString("age"));
				String gender = rs.getString("gender");
				String policeRank = rs.getString("policeRank");
				police = new policeRegister(age, gender, policeRank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return police;
	}

		
}
