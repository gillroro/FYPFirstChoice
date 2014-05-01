package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
/*
 * This class is responsible for the approval of holiday requests that are submitted by the management in the company.
 * management can approve the holiday request, changing its status in the database from Awaiting to Approved.
 */
public class HolidayApprovalAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement approveHolidays;
	private String employeeName;
	
	public String execute() throws SQLException{
		connection = ConnectionCreation.getConnection();
		approveHolidays= connection.prepareStatement("UPDATE holiday SET approved=? WHERE employeeName=?");
		approveHolidays.setString(1, "Approved");
		approveHolidays.setString(2, getEmployeeName());
		int test = approveHolidays.executeUpdate();
		connection.close();
		approveHolidays.close();
		if(test>=1){
			return SUCCESS;	
		}
		else {
			return "failure";
		}
	}
	public String forward(){
		return NONE;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
}
