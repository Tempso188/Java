package loginSystem;
import java.sql.*;

public class sqlConnection {
	public static Connection getConnection() throws Exception{
		String dbRoot = "jdbc:mysql://";
		String hostname = "localhost:8080/";
		String dbName = "login";
		String dbUrl = dbRoot+hostname+dbName;
		
		String hostBenutzername = "root";
		String hostPasswort = "";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbUrl, hostBenutzername, hostPasswort);
		
		return con;
	}

}
