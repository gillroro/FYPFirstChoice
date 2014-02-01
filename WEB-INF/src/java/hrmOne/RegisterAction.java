package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String firstName;
	private String surname;
	private String address;
	private int salary;
	private String userType;
	private int managerID;
	private Connection connection;
	private PreparedStatement addEmployee;	
	private WebSession ws;
	private Employee employee = new Employee();
	private List<Employee> employees = new ArrayList<Employee>();
	private User user = new User();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String forward(){
		return NONE;
	}

	//business logic
	public String execute() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
		addEmployee= connection.prepareStatement("INSERT INTO employee(first_name, surname, username, password, address, salary) VALUES(?, ?, ?, ?, ?, ?)");	
		addEmployee.setString(1, getFirstName());
		addEmployee.setString(2, getSurname());
		addEmployee.setString(3, getUsername());
		addEmployee.setString(4, getPassword());
		addEmployee.setString(5, getAddress());
		addEmployee.setInt(6, getSalary());
	//	addEmployee.setInt(7, getManagerID());
		addEmployee.executeUpdate();
		employee.setFirstName(getFirstName());
		employee.setSurname(getSurname());
		employee.setUsername(getUsername());
		employee.setPassword(getPassword());
		employee.setAddress(getAddress());
		employee.setSalary(getSalary());
		employee.setManagerID(getManagerID());
		employees.add(employee);
		employee.setEmployees(employees);
		ws.put("CurrentUser", user);
		addEmployee.close();
		connection.close();
		return "success";

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	


}