package br.conshare.db.connecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection connection = null;
	
	private static final String url = "jdbc:postgresql://localhost:5432/db_conshare";
	private static final String user = "postgres";
	private static final String password = "8853fe-8990*#";
	
	public static Connection getConnection () {
		
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	
	
	public static void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void closePreparedstatement (PreparedStatement preparedStatement) {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public static void closeConnection (Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		closeResultSet(resultSet);
		closePreparedstatement(preparedStatement);
		closeConnection(connection);
		
		
	}



	public static void close(PreparedStatement preparedStatement, Connection connection) {
		
		closePreparedstatement(preparedStatement);
		closeConnection(connection);
	
		
	}
	


}
