package hrmOne;

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
	private List<String> attendance;
	private List<String> respect;

	private String attendanceRecord;
	private String respectRecord;


	private String from;
	private String password;
	private String to;
	private String subject;
	private String body;

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
		attendance = new ArrayList<String>();
		attendance.add("Excellent");
		attendance.add("Very Good");
		attendance.add("Average");
		attendance.add("Poor");

		respect = new ArrayList<String>();
		respect.add("Very Respectful");
		respect.add("Average Respect for others");
		respect.add("Poor Respect for Others");
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
			
			Transport.send(message);
		}
		catch(Exception e)
		{
			ret = ERROR;
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



}
