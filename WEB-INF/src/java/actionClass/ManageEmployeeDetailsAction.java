package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
/*
 * This action class is responsible for managing the details of the employee's in the Application. 
 * Managers can edit the employee details that are stored about them in the company. 
 */
public class ManageEmployeeDetailsAction extends ActionSupport implements Preparable, SessionAware{

	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	private Connection connection;
	private PreparedStatement getEmployee, updateEmployee;	
	private ResultSet results;
	private Employee manager;
	private Employee employee;
	private String username, userType,password,firstName, surname, address, managerName;
	private int salary;
	
	private Map<String, Object> session;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		if(session.containsKey("manager")){
			manager =((Employee) session.get("manager"));
		}
		if(session.containsKey("employee")){
			setEmployee((Employee)session.get("employee"));
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setSession(Map map) {
		session = (SessionMap) map;
	}

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
	//Gets all the details about all the employee's in the company
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
				employee.setManager(results.getString("manager"));
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
	//Updates the details of the employees in the database.
	public String updateDetails() throws SQLException{
		connection = ConnectionCreation.getConnection();
		updateEmployee = connection.prepareStatement("UPDATE employee SET first_name=?, surname=?, address=?, user_type=?, salary=? WHERE username=?");
		updateEmployee.setString(1, getFirstName());
		updateEmployee.setString(2, getSurname());
		updateEmployee.setString(3, getAddress());
		updateEmployee.setString(4, getUserType());
		updateEmployee.setInt(5, getSalary());
		updateEmployee.setString(6, getManagerName());
		updateEmployee.setString(6, getUsername());
		System.out.print("username" + getUsername());
		int test =updateEmployee.executeUpdate();
		updateEmployee.close();
		connection.close();
		if(test == 1){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}
	// Getter and Setter methods for the Struts2 framework
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String forward(){
		return NONE;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
}