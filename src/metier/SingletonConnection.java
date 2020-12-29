package metier;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:8081/prods", "root", "");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
}
