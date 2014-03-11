package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class AppraisalAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private List<String> attendance= new ArrayList<String>();
	private List<String> respect= new ArrayList<String>();
	private String attendanceRecord;
	private String respectRecord;
	private List<Employee> managers= new ArrayList<Employee>();
	private List<String> managerName= new ArrayList<String>();
	private String manager;
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;
	private String accomplishments;
	private String barriers;
	private String improvements;
	private String performance;
	private Connection connection;
	private PreparedStatement addAppraisal;
	private PreparedStatement getManagers;
	private ResultSet results;

	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}


	public AppraisalAction(){
		attendance.add("Excellent");
		attendance.add("Very Good");
		attendance.add("Average");
		attendance.add("Poor");

		respect.add("Very Respectful");
		respect.add("Average Respect for others");
		respect.add("Poor Respect for Others");
	
		getAllManagerNames();
		
	}


	public String execute() 
	{
		
		String ret = SUCCESS;
		try
		{
			Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new 
							PasswordAuthentication("firstchoicefinalyearproject@gmail.com", "55UK6gt1");
				}});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("firstchoicefinalyearproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gillroro@gmail.com"));
			message.setSubject("Appraisal Details");
			message.setText("The employee Sarah has completed her appraisal.\nPlease review this.\n" + new Date());
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			addAppraisal = connection.prepareStatement("INSERT INTO Appraisal(accomplishments, barriers, improvements, performance) VALUES(?,?,?,?)");
			addAppraisal.setString(1, getAccomplishments());
			addAppraisal.setString(2, getBarriers());
			addAppraisal.setString(3, getImprovements());
			addAppraisal.setString(4, getPerformance());
			addAppraisal.setString(5, getAttendanceRecord());
			addAppraisal.setString(6, getRespectRecord());
			addAppraisal.executeUpdate();
			Transport.send(message);
		}
		catch(Exception e)
		{
			ret = "failure";
			e.printStackTrace();
		}
		return ret;
	}
	public String display() {
		return NONE;
	}

	public List<String> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<String> attendance) {
		this.attendance = attendance;
	}

	public List<String> getRespect() {
		return respect;
	}

	public void setRespect(List<String> respect) {
		this.respect = respect;
	}

	public String getAttendanceRecord() {
		return attendanceRecord;
	}

	public void setAttendanceRecord(String attendanceRecord) {
		this.attendanceRecord = attendanceRecord;
	}

	public String getRespectRecord() {
		return respectRecord;
	}

	public void setRespectRecord(String respectRecord) {
		this.respectRecord = respectRecord;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}

	public List<Employee> getManagers() {
		return managers;
	}


	public void setManagers(List<Employee> managers) {
		this.managers = managers;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getAccomplishments() {
		return accomplishments;
	}


	public void setAccomplishments(String accomplishments) {
		this.accomplishments = accomplishments;
	}


	public String getBarriers() {
		return barriers;
	}


	public void setBarriers(String barriers) {
		this.barriers = barriers;
	}


	public String getImprovements() {
		return improvements;
	}


	public void setImprovements(String improvements) {
		this.improvements = improvements;
	}


	public String getPerformance() {
		return performance;
	}


	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	public List<Employee> getAllManagers(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			getManagers = connection.prepareStatement("SELECT * FROM EMPLOYEE");
			results = getManagers.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setAddress(results.getString("address"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setUserType(results.getString("user_type"));

				if(employee.getUserType().equalsIgnoreCase("manager")){
					managers.add(employee);
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return managers;
		
	}


	public List<String> getManagerName() {
		return managerName;
	}


	public void setManagerName(List<String> managerName) {
		this.managerName = managerName;
	}
	
	public List<String> getAllManagerNames(){
		getAllManagers();
		for (int i=0; i<managers.size(); i++){
			String name = managers.get(i).getFirstName();
			managerName.add(name);
		}
		return managerName;
	}
	
	
	
	

	
	


}
