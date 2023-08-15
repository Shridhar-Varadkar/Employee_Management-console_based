package database_Emp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import employee.Employee;

public class Emp_CRUD {

	private static Scanner sc;
	////////// Show Method /////////

	public static void show() {
		Connection connection = DB_Connection.connectToDb();
		ResultSet result = null;
		// fetch data from table
		String query = "Select *from emp;";

		try {
			Statement s = connection.createStatement();
			result = s.executeQuery(query);

			while (result.next()) {
				int id = result.getInt(1);
				String name = result.getString(2);
				int salary = result.getInt(3);
				System.out.println(id + "--" + name + "--" + salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/////////////// Insert Method ////////////////

	public static boolean insert(Employee emp) {
		boolean is_inserted = false;
		Connection connection = DB_Connection.connectToDb();
		String query = "insert into emp(name,salary) values(?,?);";
		try {
			PreparedStatement ps1 = connection.prepareStatement(query);
			ps1.setString(1, emp.emp_name());
			ps1.setInt(2, emp.salary());

			ps1.executeUpdate();
			is_inserted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is_inserted;
	}

	////////////// Update Method ////////////////

	public static boolean update(int id) {
		boolean is_updated = false;
		Connection connection = DB_Connection.connectToDb();
		String query = "select * from emp where id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				System.out.println("ID exist");
				System.out.println("---- Enter New Data --");
				sc = new Scanner(System.in);
				System.out.print("Enter Employee name -->");
				String emp_name = sc.next();

				System.out.print("Enter Salary -->");
				int salary = sc.nextInt();

				String update_query = "update emp set name=?,salary=? where id=?;";
				PreparedStatement ps2 = connection.prepareStatement(update_query);
				ps2.setString(1, emp_name);
				ps2.setInt(2, salary);
				ps2.setInt(3, id);
				ps2.executeUpdate();
				is_updated = true;
			} else {
				System.out.println("ID does not exist");
			}

			is_updated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is_updated;

	}

	////////////// Delete Method ////////////////

	public static boolean delete(int id) {
		boolean is_deleted = false;
		Connection connection = DB_Connection.connectToDb();
		String query = "select * from emp where id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
				System.out.println("ID exist");
				String delete_query = "delete from emp where id=?;";
				PreparedStatement ps3 = connection.prepareStatement(delete_query);
				ps3.setInt(1, id);
				ps3.executeUpdate();
				is_deleted = true;
			} else {
				System.out.println("ID does not exist");
			}

			is_deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is_deleted;
	}
}
