package employee;

public class Employee {

	String emp_name;
	int salary;

	public Employee(String emp_name, int salary) {
		this.emp_name = emp_name;
		this.salary = salary;
	}

	public String emp_name() {
		return emp_name;
	}

	public int salary() {
		return salary;
	}
}
