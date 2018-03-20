package Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBConnector {
	// Constants used to get access to the database

	private static final String driver = "jdbc:sqlserver://77.68.231.82:1435";
	private static final String databaseName = ";databaseName=microProject";

	private static String userName = ";user=sa";
	private static String password = ";password=1234Hund";

	private DatabaseMetaData dma;
	private static Connection con;

	// an instance of the class is generated
	private static DBConnector instance = null;
	
	public static void main(String[] args) {
		DBConnector.getInstance();
	}

	// the constructor is private to ensure that only one object of this class is
	// created
	DBConnector() {
		String url = driver + databaseName + userName + password;

		try {
			// load of driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver class loaded ok");

		} catch (Exception e) {
			System.out.println("Cannot find the driver");
			System.out.println(e.getMessage());
		}
		try {
			// connection to the database
			con = DriverManager.getConnection(url);
			con.setAutoCommit(true);
			dma = con.getMetaData(); // get meta data
			System.out.println("Connection Established");
			System.out.println("Driver " + dma.getDriverName());
			System.out.println("Database product name " + dma.getDatabaseProductName());
		} // end try
		catch (Exception e) {
			System.out.println("Problems with the connection to the database:");
			System.out.println(e.getMessage());
			System.out.println(url);
		} // end catch
	}// end constructor

	// closeDb: closes the connection to the database
	public static void closeConnection() {
		try {
			con.close();
			instance = null;
			System.out.println("The connection is closed");
		} catch (Exception e) {
			System.out.println("Error trying to close the database " + e.getMessage());
		}
	}// end closeDB

	// getDBcon: returns the singleton instance of the DB connection
	public Connection getDBcon() {
		return con;
	}

	// getDBcon: returns the singleton instance of the DB connection
	public static boolean instanceIsNull() {
		return (instance == null);
	}

	// this method is used to get the instance of the connection
	public static DBConnector getInstance() {
		if (instance == null) {
			instance = new DBConnector();
		}
		return instance;
	}

}// end DbConnection
