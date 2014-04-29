package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.struts2.interceptor.SessionAware;
import util.WebSession;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import database.ConnectionCreation;
import entity.*;

public class AppraisalAction extends ActionSupport implements Preparable, SessionAware{
	private static final long serialVersionUID = 1L;
	private List<String> attendance= new ArrayList<String>();
	private List<String> respect= new ArrayList<String>();
	private List<Appraisal> appraisals = new ArrayList<Appraisal>();
	private List<Project> projects = new ArrayList<Project>();
	private String attendanceRecord,respectRecord,manager,managerEmail, firstName, projectName;
	private List<Employee> managers= new ArrayList<Employee>();
	private List<Employee> employees= new ArrayList<Employee>();
	private Employee employee;
	//Email
	private String from,password,to,subject,body;
	//appraisal
	private String accomplishments,barriers,improvements,performance, completed, uncompleted, projectDetails;
	private Appraisal appraisal;
	private boolean yes,no;
	//database
	private Connection connection;
	private PreparedStatement addAppraisal,getManagers,getEmployees,getAppraisals, getEmployeeProjects, addBonus,changeStatus;
	private ResultSet results;
	private Project project;
	//session
	private Map<String, Object> session;

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

	@SuppressWarnings("rawtypes")
	@Override
	public void setSession(Map arg0) {

	}

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		employee = (Employee) session.get("employee");
	}

	public String execute() 
	{
		getEmployeeProjects();
		appraisal = new Appraisal();
		String ret = SUCCESS;
		try
		{
			Session mailSession = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new 
							PasswordAuthentication("firstchoicefinalyearproject@gmail.com", "finalyearproject");
				}});

			connection = ConnectionCreation.getConnection();
			addAppraisal = connection.prepareStatement("INSERT INTO Appraisal(firstName,accomplishments, barriers, improvements, performance, attendance, respect, projectDetails) VALUES(?,?,?,?,?,?,?,?)");
			addAppraisal.setString(1, employee.getFirstName());
			addAppraisal.setString(2, getAccomplishments());
			addAppraisal.setString(3, getBarriers());
			addAppraisal.setString(4, getImprovements());
			addAppraisal.setString(5, getPerformance());
			addAppraisal.setString(6, getAttendanceRecord());
			addAppraisal.setString(7, getRespectRecord());
			if(projects.size() > 0){
				if(isYes()){
					addAppraisal.setString(8, "Completion" +getCompleted());
					appraisal.setProjectDetails("Completion" +completed);
					changeStatus = connection.prepareStatement("UPDATE project_member SET status=? WHERE projectName=?");
					changeStatus.setString(1, "Complete");
					changeStatus.setString(2, projectName );
					changeStatus.executeUpdate();
				}
				else if(isNo()){
					
					addAppraisal.setString(8, "Incompletion" +getUncompleted());
					appraisal.setProjectDetails("Incompletion" +uncompleted);
				}
				else{
					System.out.print("ERROR");
				}
			}
			else{
				addAppraisal.setString(8, "All Projects Completed");
			}
			addAppraisal.executeUpdate();
			appraisal.setAccomplishments(accomplishments);
			appraisal.setAttendanceRecord(attendanceRecord);
			appraisal.setBarriers(barriers);
			appraisal.setEmployee(employee);
			appraisal.setImprovements(improvements);
			appraisal.setPerformance(performance);
			appraisal.setRespectRecord(respectRecord);
			session.put("appraisal", appraisal);
			if(firstName.equalsIgnoreCase("Gillian")){
				managerEmail = "finalyearprojectfirstchoice14@gmail.com"; //password = finalyearproject to check that emails are being sent correctly
			}
			else {
				managerEmail = "finalyearprojectfirstchoice14@gmail.com"; //password = finalyearproject to check that emails are being sent correctly
			}

			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("firstchoicefinalyearproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(managerEmail));
			message.setSubject("Appraisal Details");
			message.setText("The employee " +  employee.getFirstName()+" has completed her appraisal.\nPlease review this.\n" + new Date());
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
			getAppraisals = connection.prepareStatement("SELECT * FROM APPRAISAL WHERE firstName=?");
			getAppraisals.setString(1, firstName);
			results = getAppraisals.executeQuery();
			while(results.next()){
				Appraisal appraisal = new Appraisal();
				appraisal.setEmployeeName(results.getString("firstName"));
				appraisal.setAccomplishments(results.getString("accomplishments"));
				appraisal.setBarriers(results.getString("barriers"));
				appraisal.setImprovements(results.getString("improvements"));
				appraisal.setPerformance(results.getString("performance"));
				appraisal.setAttendanceRecord(results.getString("attendance"));
				appraisal.setRespectRecord(results.getString("respect"));
				appraisal.setProjectDetails(results.getString("projectDetails"));
				appraisals.add(appraisal);	
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return appraisals;
	}

	public List<Project> getEmployeeProjects(){
		try {
			connection = ConnectionCreation.getConnection();
			getEmployeeProjects = connection.prepareStatement("SELECT * FROM project_member WHERE firstName=?");
			getEmployeeProjects.setString(1, employee.getFirstName());
			results = getEmployeeProjects.executeQuery();
			while(results.next()){
				Project project = new Project();
				project.setProjectName(results.getString("projectName"));
				project.setEmployee(employee);
				if(results.getString("status").equalsIgnoreCase("complete")){
					project.setStatus("Complete");
				}
				else{
					project.setStatus("Incomplete");
				}
				if(project.getStatus().equalsIgnoreCase("Incomplete")){
					projects.add(project);
				}

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return projects;
	}

	public void displayEmployeeProjects(){
		getEmployeeProjects();
		if(projects != null){
			System.out.println(projects.size());
		}
		else {
			System.out.println("empty");
		}
	}
	public String manageAppraisals(){
		getAllEmployees();
		getAllAppraisals();
		return NONE;
	}

	public String giveBonus(){
		try{
			connection = ConnectionCreation.getConnection();
			addBonus = connection.prepareStatement("UPDATE employee SET bonus=? WHERE first_name=?");
			addBonus.setInt(1,(25000/100)*15);
			addBonus.setString(2, firstName);
			System.out.print(firstName);
			addBonus.executeUpdate();
			connection.close();
			addBonus.close();
			return SUCCESS;
		}
		catch(Exception e){
			e.printStackTrace();
			return "failure";
		}
	}
	public String rejectBonus(){
		return SUCCESS;
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
	public String display(){
		getAllAppraisals();
		displayEmployeeProjects();
		return NONE;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean isYes() {
		return yes;
	}
	public void setYes(boolean yes) {
		this.yes = yes;
	}
	public boolean isNo() {
		return no;
	}
	public void setNo(boolean no) {
		this.no = no;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	public String getUncompleted() {
		return uncompleted;
	}
	public void setUncompleted(String uncompleted) {
		this.uncompleted = uncompleted;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}