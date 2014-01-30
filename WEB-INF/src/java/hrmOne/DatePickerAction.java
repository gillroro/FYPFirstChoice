package hrmOne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;

public class DatePickerAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Date date1;
	private Date date2;
	private Date date3;	
	 SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
	 static Properties properties = new Properties();
		static
		{
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
		}
	
	public Date getDate1() throws ParseException {
		
		return format2.parse(format2.format(date1));
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}


	public Date getDate2() throws ParseException {
		return format2.parse(format2.format(date2));
	}


	public void setDate2(Date date2) {
		this.date2 = date2;
	}


	public Date getDate3() throws ParseException {
		return format2.parse(format2.format(date3));
	}


	public void setDate3(Date date3) {
		this.date3 = date3;
	}


	public String execute() throws Exception{
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
			message.setSubject("Holiday Request Details");
			message.setText("The employee Sarah has completed her holiday requests.\nPlease review these.\n" 
						+ date1+ "\n" + date2 + "\n"  + date3);
			
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

}
