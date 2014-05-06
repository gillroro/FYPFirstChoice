package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}
	public String execute() throws SQLException{
		connection = ConnectionCreation.getConnection();
		approveHolidays= connection.prepareStatement("UPDATE holiday SET approved=? WHERE employeeName=?");
		approveHolidays.setString(1, "Approved");
		approveHolidays.setString(2, getEmployeeName());
		int test = approveHolidays.executeUpdate();
		connection.close();
		approveHolidays.close();
		if(test>=1){
			Session mailSession = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new 
							PasswordAuthentication("firstchoicefinalyearproject@gmail.com", "finalyearproject");
				}});
			Message message = new MimeMessage(mailSession);
			try {
				message.setFrom(new InternetAddress("firstchoicefinalyearproject@gmail.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("finalyearprojectfirstchoice14@gmail.com"));
				message.setSubject("Holiday Request Details");
				message.setText("The Holiday Requests for " +employeeName + "have been approved.");
				Transport.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
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
