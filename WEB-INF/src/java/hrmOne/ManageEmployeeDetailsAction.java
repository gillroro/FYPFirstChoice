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

	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	private Connection connection;
	private PreparedStatement getEmployee;	
	private Employee employee;
	private ResultSet results;

	public String execute() throws ClassNotFoundException, SQLException {
		getEmployees();
		if(employees.size() > 0){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}

	public List<Employee> getEmployees() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			getEmployee = connection.prepareStatement("SELECT * FROM employee");
			results = getEmployee.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setAddress(results.getString("address"));
				employee.setSalary(results.getInt("salary"));
				employee.setUserType(results.getString("user_type"));
				employee.setManagerID(results.getInt("manager_id"));
				employees.add(employee);

			}

			results.close();
			connection.close();
			getEmployee.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}



}
