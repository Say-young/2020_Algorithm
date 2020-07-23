import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connectionfile {
	/**
	 * This file was created to help other files to access MySQL DB easily.
	 * @return connection object
	 */
	
	public static Connection getConn() {
		
		Connection myConn = null;
		PreparedStatement pStmt = null;
		Statement myState = null;
		ResultSet myResSet = null;
		String sql = "";
		
		//String userID = "testuser";
		//String userPW = "testpw";
		//String dbName = "final";
		
		/**
		 * Load the JDBC driver
		 */
		String userID = "dbuser";
		String userPW = "dbpwd";
		String dbName = "dbprj";
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?&serverTimezone=UTC";
		
		try {
			/**
			 * Create a Connection object
			 */
			myConn = DriverManager.getConnection(url, userID, userPW);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myConn;
	}
}
