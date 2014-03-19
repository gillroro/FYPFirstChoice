package actionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
import entity.Employee;

public class ManageEmployeeDetailsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	private Connection connection;
	private PreparedStatement getEmployee;	

	private ResultSet results;

	public String execute() throws ClassNotFoundException, SQLException {
		getAllEmployees();
		if(employees != null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}

	public List<Employee> getEmployees() {
		
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<Employee> getAllEmployees() {
		try{
			
			connection = ConnectionCreation.getConnection();
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
				employee.setManager(results.getInt("manager"));
				employees.add(employee);

			}
			for(int i=0; i<employees.size(); i++){
				System.out.print(employees.get(i));
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



}
