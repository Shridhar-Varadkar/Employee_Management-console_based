package database_Emp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

	static Connection connection;

	public static Connection connectToDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String username = "root";
			String password = "root";
			String db_info = "jdbc:mysql://localhost:3306/employee_db";
			connection = DriverManager.getConnection(db_info, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}
