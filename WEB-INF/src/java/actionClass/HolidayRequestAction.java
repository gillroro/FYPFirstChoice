package actionClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import util.WebSession;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import database.ConnectionCreation;
import entity.Employee;
import entity.Holiday;

//This action class allows an employee to request time off from the company. It will then send the manager an email with the requests
//to allow them to approve them
public class HolidayRequestAction extends ActionSupport implements Preparable, SessionAware{

	private static final long serialVersionUID = 1L;
	private Date date1,date2,date3;
	private Connection connection;
	private PreparedStatement addHolidays,getHolidays;
	private ResultSet results;
	private List<Holiday> holidays = new ArrayList<Holiday>();
	private Employee employee;
	private String employeeName;
	java.util.Date today = new java.util.Date();
	Date sqlToday = new Date(today.getTime());

	SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	static Properties properties = new Properties();
	static
	{
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
	}
	private Map<String, Object> session;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		employee = (Employee) session.get("employee");
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map map) {
		session = (SessionMap) map;
	}
	//Adds the employee's holiday requests to the database
	public String execute() throws Exception{
		Holiday holiday = new Holiday();
		String ret = SUCCESS;
		try{
			System.out.println(date1);
			System.out.println(date2);
			System.out.println(date3);
			connection = ConnectionCreation.getConnection();
			addHolidays = connection.prepareStatement("INSERT INTO holiday(date1, date2, date3,employeeName, approved) VALUES(?, ?, ?,?,?)");
			addHolidays.setDate(1, (java.sql.Date) date1);
			addHolidays.setDate(2, (java.sql.Date) date2);
			addHolidays.setDate(3, (java.sql.Date) date3);
			addHolidays.setString(4, employee.getFirstName());
			addHolidays.setString(5, "Awaiting");
			addHolidays.executeUpdate();
			holiday.setDate1(date1);
			holiday.setDate1(date2);
			holiday.setDate3(date3);
			holiday.setEmployee(employee);
			session.put("holiday", holiday);
			Session mailSession = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new 
							PasswordAuthentication("firstchoicefinalyearproject@gmail.com", "finalyearproject");
				}});
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("firstchoicefinalyearproject@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("finalyearprojectfirstchoice14@gmail.com"));
			message.setSubject("Holiday Request Details");
			message.setText(employee.getManager() + "\nThe employee "+ employee.getFirstName() +" has completed her holiday requests.\nPlease review these.\n" 
					+ date1+ "\n" + date2 + "\n"  + date3);
			Transport.send(message);
		}
		catch(Exception e){
			ret = "failure";
			e.printStackTrace();
		}
		connection.close();
		addHolidays.close();
		return ret;
	}

	public String display() {
		return NONE;
	}

	public List<Holiday> getAllHolidays(){
		try {
			connection = ConnectionCreation.getConnection();
			getHolidays = connection.prepareStatement("SELECT * FROM HOLIDAY");
			results = getHolidays.executeQuery();
			while(results.next()){
				Holiday holiday = new Holiday();
				holiday.setDate1(results.getDate("date1"));
				holiday.setDate2(results.getDate("date2"));
				holiday.setDate3(results.getDate("date3"));
				holiday.setEmployeeName(results.getString("employeeName"));
				holiday.setEmployee(employee);
				holiday.setApproved(results.getString("approved"));
				if(holiday.getApproved().equalsIgnoreCase("Awaiting")){
					holidays.add(holiday);
				}
			}
			connection.close();
			getHolidays.close();
			results.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  holidays;
	}

	public String displayHolidays(){
		getAllHolidays();
		if(holidays!=null){
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDate1() throws ParseException {
		return (Date) format2.parse(format2.format(date1));
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() throws ParseException {
		return (Date) format2.parse(format2.format(date2));
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getDate3() throws ParseException {
		return (Date) format2.parse(format2.format(date3));
	}
	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	public List<Holiday> getHolidays() {
		return holidays;
	}
	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	//	public void validate(){
	//		if(date1 == null && date2 ==null && date3 == null){
	//			setFieldErrors(null);
	//		}
	//		if(date1 == null || date1.equals("") || date1.before(sqlToday)){
	//			addFieldError("date1", "A valid date is required");
	//		}
	//		if(date2 == null || date2.equals("") || date2.before(sqlToday) || date2.before(date1)){
	//			addFieldError("date2", "A valid date is required");
	//		}
	//		if(date3 == null || date3.equals("") || date3.before(sqlToday) || date3.before(date1) ||  date3.before(date2)){
	//			addFieldError("date3", "A valid date is required");
	//		}
	//	}


}
