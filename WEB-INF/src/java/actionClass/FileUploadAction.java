package actionClass;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;

public class FileUploadAction extends ActionSupport implements Preparable, SessionAware {

	private static final long serialVersionUID = 1L;
	private File fileUpload;
	private String fileUploadContentType, jobName;
	private String fileUploadFileName;
	private Connection connection;
	private PreparedStatement uploadCv;	
	private String username;
	private File document;
	private Employee employee;
	
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
	
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String execute() throws Exception{
		
		connection = ConnectionCreation.getConnection();
		uploadCv = connection.prepareStatement("INSERT INTO CV(Username, file) VALUES(?, ?)");	
		
		FileInputStream is = new FileInputStream(getFileUpload());
		byte[] data = new byte[is.available()];
		is.read(data);
		is.close();
		Blob blob = connection.createBlob();
		blob.setBytes(1, data);
		System.out.print(employee.getUsername());
		uploadCv.setString(1, employee.getFirstName());
		uploadCv.setBlob(2, blob);
		uploadCv.executeUpdate();
		session.put("cv", employee);
		uploadCv.close();
		connection.close();
		return SUCCESS;

	}

	public String display() {
		return NONE;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getDocument() {
		return document;
	}

	public void setDocument(File document) {
		this.document = document;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	
	
}


