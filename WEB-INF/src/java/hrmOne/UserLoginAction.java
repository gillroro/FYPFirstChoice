package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement checkDuplicate;
	private ResultSet results;
	private String username;
	private String password;
	private String comment;
	private String userType;
	//private WebSession ws;
	private Employee employee = new Employee();
	
	

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


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
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

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
		checkDuplicate = connection.prepareStatement("SELECT username, user_type FROM employee WHERE username=? AND password =?");
		checkDuplicate.setString(1, getUsername());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if (results.next()) {
			if(results.getString("user_type").equalsIgnoreCase("manager")){
				connection.close();
				checkDuplicate.close();
				WebSession.put("CurrentUser", employee);
				return "manager";
			}
			else{
			connection.close();
			checkDuplicate.close();
			WebSession.put("CurrentUser", employee);
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
		WebSession.remove("CurrentUser");
		WebSession.clear();
		return "success";
	}
//	
//	public void validate(){
//		if(username == null || username.equals("")){
//			addFieldError(username, "Username is required");
//		}
//		if(password == null || password.equals("")){
//			addFieldError(password, "Password is required");
//		}
//	}



}
