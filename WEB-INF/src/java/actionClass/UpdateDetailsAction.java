package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;


public class UpdateDetailsAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String firstName, surname, username, password, address, userType;
	private int salary, manager;
	private Connection connection;
	private PreparedStatement updateEmployee;

	public String execute() throws SQLException{
		connection = ConnectionCreation.getConnection();
		updateEmployee = connection.prepareStatement("UPDATE employee SET first_name=?, surname=?, address=?, user_type=?, salary=?, manager=? WHERE username=?");
		updateEmployee.setString(1, getFirstName());
		updateEmployee.setString(2, getSurname());
		updateEmployee.setString(3, getAddress());
		updateEmployee.setString(4, getUserType());
		updateEmployee.setInt(5, getSalary());
		updateEmployee.setInt(6, getManager());
		updateEmployee.setString(7, getUsername());
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}


}
