package actionClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;

public class HolidayApprovalAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Connection connection;
	private PreparedStatement approveHolidays;
	private Date date1,date2,date3;
	private String employeeName;
	
	public String execute() throws SQLException{
		System.out.println("HERE");
		System.out.println("HERE");
		connection = ConnectionCreation.getConnection();
		System.out.println("HERE");
		approveHolidays= connection.prepareStatement("UPDATE holiday SET approved=? WHERE employeeName=?");
		System.out.println("HERE");
		approveHolidays.setString(1, "Approved");
		approveHolidays.setString(2, getEmployeeName());
		int test = approveHolidays.executeUpdate();
		connection.close();
		approveHolidays.close();
		if(test==1){
			return SUCCESS;	
		}
		else {
			return "failure";
		}
	}
	public String forward(){
		return NONE;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
}
