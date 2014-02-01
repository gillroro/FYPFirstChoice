package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ManageEmployeeDetailsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	private Connection connection;
	private PreparedStatement getEmployee;	
	private Employee employee;
	private ResultSet results;
	
	public String execute() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
		getEmployee = connection.prepareStatement("SELECT * FROM employee");
		results = getEmployee.executeQuery();
		while(results.next()){
			employee = new Employee();
			employee.setFirstName(results.getString(1));
			employee.setSurname(results.getString(2));
			employee.setUsername(results.getString(3));
			employee.setPassword(results.getString(4));
			employee.setAddress(results.getString(5));
			employee.setSalary(results.getInt(6));
			employee.setUserType(results.getString(7));
			employee.setManagerID(results.getInt(8));
			employees.add(employee);
			connection.close();
			getEmployee.close();
			return SUCCESS;
		}
		return "failure";
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
