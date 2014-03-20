package actionClass;

import java.sql.Connection;
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

import database.ConnectionCreation;
import entity.Appraisal;
import entity.Employee;

public class AppraisalAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<String> attendance= new ArrayList<String>();
	private List<String> respect= new ArrayList<String>();
	private List<Appraisal> appraisals = new ArrayList<Appraisal>();
	private String attendanceRecord;
	private String respectRecord;
	private List<Employee> managers= new ArrayList<Employee>();
	private List<Employee> employees= new ArrayList<Employee>();
	private String manager;
	//Email
	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;
	//appraisal
	private String accomplishments;
	private String barriers;
	private String improvements;
	private String performance;
	//database
	private Connection connection;
	private PreparedStatement addAppraisal;
	private PreparedStatement getManagers;
	private PreparedStatement getEmployees;
	private PreparedStatement getAppraisals;
	private ResultSet results;
	private String managerEmail;

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
	
		getAllManagers();
		
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

			connection = ConnectionCreation.getConnection();
			addAppraisal = connection.prepareStatement("INSERT INTO Appraisal(accomplishments, barriers, improvements, performance, attendance, respect) VALUES(?,?,?,?,?,?)");
			addAppraisal.setString(1, getAccomplishments());
			addAppraisal.setString(2, getBarriers());
			addAppraisal.setString(3, getImprovements());
			addAppraisal.setString(4, getPerformance());
			addAppraisal.setString(5, getAttendanceRecord());
			addAppraisal.setString(6, getRespectRecord());
			addAppraisal.executeUpdate();
			
			if(manager.equalsIgnoreCase("Gillian")){
				 managerEmail = "gillroro@gmail.com";
			}

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("firstchoicefinalyearproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(managerEmail));
			message.setSubject("Appraisal Details");
			message.setText("The employee Sarah has completed her appraisal.\nPlease review this.\n" + new Date());
			Transport.send(message);
		}
		catch(Exception e)
		{
			ret = "failure";
			e.printStackTrace();
		}
		return ret;
	}




	public List<Employee> getAllManagers(){
		try {
			connection =ConnectionCreation.getConnection();
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
	
	public List<Employee> getAllEmployees(){
		try {		
			connection =ConnectionCreation.getConnection();
			getEmployees = connection.prepareStatement("SELECT * FROM EMPLOYEE");
			results = getEmployees.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setAddress(results.getString("address"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setUserType(results.getString("user_type"));
				if(employee.getUserType().equalsIgnoreCase("employee")){
					employees.add(employee);		
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Appraisal> getAllAppraisals(){
		try{
			connection = ConnectionCreation.getConnection();
			getAppraisals = connection.prepareStatement("SELECT * FROM APPRAISAL");
			results = getAppraisals.executeQuery();
			while(results.next()){
				Appraisal appraisal = new Appraisal();
				appraisal.setAccomplishments(results.getString("accomplishments"));
				appraisal.setBarriers(results.getString("barriers"));
				appraisal.setImprovements(results.getString("improvements"));
				appraisal.setPerformance(results.getString("performance"));
				appraisal.setAttendanceRecord(results.getString("attendance"));
				appraisal.setRespectRecord(results.getString("respect"));
				appraisals.add(appraisal);	
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return appraisals;
	}
	
	public String manageAppraisals(){
		getAllEmployees();
		for(int i=0; i< employees.size();i++){
			
		}
		getAllAppraisals();
		return NONE;
	}

	public List<Appraisal> getAppraisals() {
		return appraisals;
	}
	public void setAppraisals(List<Appraisal> appraisals) {
		this.appraisals = appraisals;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}
	
	public String display()
	{
		return NONE;
	}
	
	
}
