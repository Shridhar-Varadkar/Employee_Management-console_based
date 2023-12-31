package employee;

import database_Emp.Emp_CRUD;
import java.util.Scanner;

public class UserEmp {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.println("--- Welcome to Employee Management System ---");
		sc = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("Press 1 to SHOW");
			System.out.println("Press 2 to INSERT");
			System.out.println("Press 3 to UPDATE");
			System.out.println("Press 4 to DELETE");
			System.out.println("Press 5 to EXIT");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("---SHOW-----");
				Emp_CRUD.show();
				break;
			case 2:
				System.out.println("---INSERT-----");
				System.out.println("---INSERT Follwoing Details-----");
				System.out.print("Enter Employee name -->");
				String emp_name = sc.next();

				System.out.print("Enter Employee salary -->");
				int salary = sc.nextInt();

				Employee emp = new Employee(emp_name, salary);
				boolean inserted = Emp_CRUD.insert(emp);
				if (inserted) {
					System.out.println("data inserted");
				} else {
					System.out.println("data not inserted");
				}
				break;
			case 3:
				System.out.println("---UPDATE-----");
				Scanner sc2 = new Scanner(System.in);
				System.out.print("Enter User id to Update -->");
				int id = sc2.nextInt();
				boolean is_updated = Emp_CRUD.update(id);
				if (is_updated) {
					System.out.println("data updated");
				} else {
					System.out.println("data updatation failed");
				}

				break;
			case 4:
				System.out.println("---DELETE-----");
				Scanner sc3 = new Scanner(System.in);
				System.out.print("Enter User id to Delete -->");
				int id2 = sc3.nextInt();
				boolean is_deleted = Emp_CRUD.delete(id2);
				if (is_deleted) {
					System.out.println("data deleted");
				} else {
					System.out.println("data deleteion failed");
				}

				break;
			case 5:
				System.out.println("---EXIT-----");
				break;
			}
		}
	}
}
