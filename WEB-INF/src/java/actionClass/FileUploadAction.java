package actionClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
//Allows the employees to upload files when needed in the application for applying for a job.
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
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destPath;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		employee = (Employee) session.get("employee");
	}
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	public void setSession(Map map) {
	//	session = (SessionMap) map;
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

	public String execute() throws IOException, SQLException {	
		destPath = "C:/Users/Gillian/Documents/apache-tomcat-7.0.32/work/";
		File destFile = new File(destPath, myFileFileName);
		FileUtils.copyFile(myFile, destFile);
		System.out.println("FILE" +myFile.getName() + destFile.getName() + myFileFileName);
		connection = ConnectionCreation.getConnection();

		uploadCv = connection.prepareStatement("INSERT INTO jobapplication(username, file, jobName) VALUES(?, ?, ?)");	

		FileInputStream is = new FileInputStream(destFile);
		byte[] data = new byte[is.available()];
		is.read(data);
		is.close();
		Blob blob = connection.createBlob();
		blob.setBytes(1, data);
		System.out.print(employee.getUsername());
		uploadCv.setString(1, employee.getFirstName());
		uploadCv.setString(2, myFileFileName);
		uploadCv.setString(3, jobName);
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

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}	
}


