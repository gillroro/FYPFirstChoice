package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;

public class UserLoginAction extends ActionSupport implements Preparable, SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement checkDuplicate;
	private ResultSet results;
	private String username, userType,password,first_name, surname, address;
	private int salary;
	@SuppressWarnings("unused")
	private Employee employee,manager;
	private Map<String, Object> session;
	
	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		employee = (Employee) session.get("employee");
		manager = (Employee) session.get("manager");
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws ClassNotFoundException, SQLException  {
		employee = new Employee();
		connection = ConnectionCreation.getConnection();
		checkDuplicate = connection.prepareStatement("SELECT first_name, surname, address, username, password, salary, user_type FROM employee WHERE username=? AND password =?");
		checkDuplicate.setString(1, getUsername());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if (results.next()) {
			//set employee
			employee.setFirstName(results.getString("first_name"));
			employee.setSurname(results.getString("surname"));
			employee.setAddress(results.getString("address"));
			employee.setUsername(results.getString("username"));
			employee.setPassword(results.getString("password"));
			employee.setSalary(results.getInt("salary"));
			employee.setUserType(results.getString("user_type"));
			if(employee.getUserType().equalsIgnoreCase("manager")){
				session.put("login", "true");
				session.put("manager",employee );
				System.out.println("Manager" + employee.getFirstName());
				connection.close();
				checkDuplicate.close();
				return "manager";
			}
			else{
				session.put("login", "true");
				session.put("employee", employee);
				System.out.print("Employee" + employee.getUsername());
				connection.close();
				checkDuplicate.close();
				return "success";
			}
		}
		else {
			connection.close();
			checkDuplicate.close();
			return "failure";
		}
	}



	public String logout() {
		if(session != null){
			session.clear();
		}
		return "success";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map map) {
		session = (SessionMap) map;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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

	public void validate(){
		if(username == null || username == "" || username.trim().length() == 0|| username.equalsIgnoreCase("Username")){
			addFieldError("Username", "Invalid username");
		}
		if(password == null || password == "" || password.trim().length()==0 || password.equalsIgnoreCase("Password")){
			addFieldError("Password", "Invalid Password");
		}
	}
	
}
