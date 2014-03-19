package actionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
import entity.User;

public class ManagerLoginAction extends ActionSupport {
	
	private Connection connection;
	private PreparedStatement checkDuplicate;
	private PreparedStatement addComment;
	private ResultSet results;
	private String username;
	private String password;
	private String comment;
	private String userType;
	private ArrayList<String> comments = new ArrayList<String>();
	private WebSession ws;
	private User user = new User();


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

		
		connection = ConnectionCreation.getConnection();
		checkDuplicate = connection.prepareStatement("SELECT username, user_type FROM employee WHERE username=? AND password =?");
		checkDuplicate.setString(1, getUsername());
		checkDuplicate.setString(2, getPassword());
		results = checkDuplicate.executeQuery();
		if (results.next()) {
			//if(getUserType().equalsIgnoreCase("manager")){
			//	connection.close();
			//	checkDuplicate.close();
			//	ws.put("CurrentUser", user);
			//	return "manager";
			//}
			//else{
			connection.close();
			checkDuplicate.close();
			ws.put("CurrentUser", user);
			return "manager";
			//}
		}
		else {
			connection.close();
			checkDuplicate.close();
			return "failure";
		}
	}
}