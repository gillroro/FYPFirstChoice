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
	private String username, userType,password;
	private Employee employee;
	private Employee manager;


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
		connection = ConnectionCreation.getConnection();
		checkDuplicate = connection.prepareStatement("SELECT username, user_type FROM employee WHERE username=? AND password =?");
		checkDuplicate.setString(1, getUsername());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if (results.next()) {
			if(results.getString("user_type").equalsIgnoreCase("manager")){
				session.put("login", "true");
				session.put("manager", manager );
				connection.close();
				checkDuplicate.close();
				return "manager";
			}
			else{
				session.put("login", "true");
				session.put("employee", employee );
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
}
