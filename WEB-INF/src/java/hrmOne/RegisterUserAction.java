package hrmOne;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUserAction {
	
	private Connection connection;
	private String user;
	private String password;
	private PreparedStatement addUsers;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		user = request.getParameter("name");
		password = request.getParameter("password");
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:gBook");
			addUsers = connection.prepareStatement("INSERT INTO users(UserName, Password) VALUES(?, ?)");	
			addUsers.setString(1, user);
			addUsers.setString(2, password);
			addUsers.executeUpdate();
			response.sendRedirect("lotto.html");
			
		}catch (Exception e) {}
		try {
			addUsers.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
	}
	

}
