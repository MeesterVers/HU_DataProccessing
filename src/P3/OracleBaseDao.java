package P3;
import java.sql.*;

public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "P2_USER";
	private static final String DB_PASS = "P21234";
	private static Connection conn;

	protected static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}

	public void closeConnection(){
		// close connection volgende opdracht
	}
} 