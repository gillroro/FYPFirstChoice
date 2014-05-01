package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
/*
 * This action class allows a Manager to add new employees to the company. They must provide all the details about the new user 
 * to the company.
 */
public class RegisterAction extends ActionSupport implements Preparable{


	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String firstName, newFirstName;
	private String surname;
	private String address;
	private int salary;
	private String userType;
	private String manager;
	private Connection connection;
	private PreparedStatement addEmployee, getManagers, getAllEmployees;	
	private Employee employee;
	private Map<String, Object> session;
	private List<Employee> managers = new ArrayList<Employee>();
	private ResultSet results;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		setEmployee((Employee) session.get("employee"));
	}

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
		getAllManagers();
		for(Employee manager : managers){
			System.out.println(manager.getFirstName());
		}
		return NONE;
	}

	public List<Employee> getManagers() {
		return managers;
	}

	public void setManagers(List<Employee> managers) {
		this.managers = managers;
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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	//business logic
	public String execute() throws ClassNotFoundException, SQLException {
		Employee employee = new Employee();
		connection = ConnectionCreation.getConnection();
		addEmployee= connection.prepareStatement("INSERT INTO employee(first_name, surname, username, password, address, salary, user_type, manager) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");	
		addEmployee.setString(1, getNewFirstName());
		addEmployee.setString(2, getSurname());
		getAllEmployees = connection.prepareStatement("SELECT * FROM employee WHERE username =?");
		getAllEmployees.setString(1, getUsername());
		results = getAllEmployees.executeQuery();
		if (results.next()){
			System.out.println("Username already there");
			return "failureUsername";
			//addFieldError("username","Username must be unique");
		}
		else{
			addEmployee.setString(3, getUsername());
		}
		addEmployee.setString(4, getPassword());
		addEmployee.setString(5, getAddress());
		addEmployee.setInt(6, getSalary());
		if(userType.equalsIgnoreCase("employee") || userType.equalsIgnoreCase("manager")){
			addEmployee.setString(7, userType);
		}
		else{
			return "failure";
		}
		addEmployee.setString(8, firstName);
		addEmployee.executeUpdate();
		employee.setAddress(address);
		employee.setFirstName(newFirstName);
		employee.setPassword(password);
		employee.setSurname(surname);
		employee.setUsername(username);
		employee.setUserType(userType);
		employee.setSalary(salary);
		session.put("employee", employee);
		addEmployee.close();
		connection.close();
		return SUCCESS;

	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Employee> getAllManagers(){
		try {
			connection =ConnectionCreation.getConnection();
			getManagers = connection.prepareStatement("SELECT * FROM EMPLOYEE");
			results = getManagers.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setAddress(results.getString("address"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setUserType(results.getString("user_type"));
				if(employee.getUserType().equalsIgnoreCase("manager")){
					managers.add(employee);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return managers;	
	}

	public String getNewFirstName() {
		return newFirstName;
	}
	public void setNewFirstName(String newFirstName) {
		this.newFirstName = newFirstName;
	}
}