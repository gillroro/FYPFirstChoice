package actionClass;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
import entity.Employee;

public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private Connection connection;
	private PreparedStatement uploadCv;	
	private String username;
	private File document;
	private WebSession ws;
	private Employee employee = new Employee();
	

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
		employee = (Employee) ws.get("CurrentUser");
		System.out.print(employee.getUsername());
		uploadCv.setString(1, "sarah");
		uploadCv.setBlob(2, blob);
		uploadCv.executeUpdate();
		ws.put("CurrentUser", employee);
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

	
	
}


