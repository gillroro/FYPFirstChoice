package actionClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
import entity.Job;
import entity.JobApplication;

//This class is responsible for the internal recruitment section in the company. It is responsible for the uploading and
//downloading of CV document files. The action class is also responsible for adding job to the company. A job must
//have a closing date that is in the future and employees can only apply for jobs that the closing date is after 
//today's date. To make an application an employee must upload a CV document or a LinkedIn page or both.
public class JobBoardAction extends ActionSupport implements Preparable, SessionAware {

	private static final long serialVersionUID = 1L;
	private List<Job> jobs = new ArrayList<Job>();
	private List<JobApplication> applications = new ArrayList<JobApplication>();
	private String jobName,description,department, jobDesc,firstName;
	private String linkedin, myFileFileName, myFileContentType, username, file;
	private String destPath = "C:/Users/Gillian/Documents/apache-tomcat-7.0.32/work/";//Files are being stored in this location
	private Employee employee;
	private Job job;
	private Date closing_date;
	private Connection connection;
	private PreparedStatement addJob,getJobs,getJobByDepartment,uploadCv, getApplications;
	private ResultSet results;
	SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	private Map<String, Object> session;
	private File myFile;
	private File fileDownload;
	private InputStream fileInputStream;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		employee = (Employee) session.get("employee");
	}
	@SuppressWarnings({  "rawtypes" })
	@Override
	public void setSession(Map map) {
	}

	public String forward(){
		return NONE;
	}
	//Adds jobs to the internal recruitment section of the company.
	public String execute() throws ClassNotFoundException, SQLException{
		connection = ConnectionCreation.getConnection();
		addJob = connection.prepareStatement("INSERT INTO Job(jobName, description, department, closing_date) VALUES(?,?,?,?)");
		addJob.setString(1, getJobName());
		addJob.setString(2, getDescription());
		addJob.setString(3, getDepartment());
		addJob.setDate(4, (java.sql.Date)closing_date);
		addJob.executeUpdate();
		return SUCCESS;
	}
	
	//gets all the jobs that are listed in the company and adds them to a list if the closing date is after today's date.
	public List<Job> getAllJobs(){
		try {

			connection = ConnectionCreation.getConnection();
			getJobs = connection.prepareStatement("SELECT * FROM JOB");
			results = getJobs.executeQuery();
			java.util.Date today = new java.util.Date();
			Date sqlToday = new Date(today.getTime());
			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("jobName"));
				job.setJobDesc(results.getString("description"));
				job.setDepartment(results.getString("department"));
				job.setClosing_date(results.getDate("closing_date"));
				if(sqlToday.before(job.getClosing_date())){
					jobs.add(job);
				}				
			}
			connection.close();
			getJobs.close();
			results.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return  jobs;
	}

	public String displayList(){
		getAllJobs();
		if(jobs != null){
			for(int i=0; i< jobs.size(); i++){
				System.out.println(jobs.get(i));
			}
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	//Gets the jobs by department based on partial matching of the department name.
	public List<Job> getJobByDepartment(){
		try {
			connection = ConnectionCreation.getConnection();
			getJobByDepartment = connection.prepareStatement("SELECT * FROM JOB WHERE department LIKE ?");
			getJobByDepartment.setString(1, "%"+department+"%");
			results = getJobByDepartment.executeQuery();
			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("jobName"));
				job.setJobDesc(results.getString("description"));
				job.setDepartment(results.getString("department"));
				job.setClosing_date(results.getDate("closing_date"));
				jobs.add(job);
			}
			connection.close();
			getJobs.close();
			results.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return  jobs;
	}

	public String displayDepartmentList(){
		getJobByDepartment();
		if(jobs.size() >= 0){
			for(int i=0; i< jobs.size(); i++){
				System.out.println(jobs.get(i).getJobName());
			}
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	//Returns all the job application that have been made by employees in the company.
	public List<JobApplication> getAllJobApplications(){
		try{
			connection = ConnectionCreation.getConnection();
			getApplications = connection.prepareStatement("SELECT * FROM jobapplication");
			results = getApplications.executeQuery();
			while(results.next()){
				JobApplication application = new JobApplication();
				application.setUsername(results.getString("username"));
				application.setJobName(results.getString("jobName"));
				application.setFile(results.getString("file"));
				application.setLinkedin(results.getString("linkedin"));
				applications.add(application);
			}
			connection.close();results.close();getApplications.close();
		}
		catch(Exception e){

		}
		return applications;
	}
	//Downloads the file for managers in order to check the job application.
	public String download(){
		try{
			connection = ConnectionCreation.getConnection();
			getApplications = connection.prepareStatement("SELECT * FROM jobapplication");
			results = getApplications.executeQuery();
			while(results.next()){
				String fileName= results.getString("file");
				fileDownload = new File(destPath, fileName);
				fileInputStream = new FileInputStream(fileDownload);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String displayApplications(){
		getAllJobApplications();
		return NONE;
	}
	//Makes a job application for an employee.
	public String jobApplication() throws IOException, SQLException{
		destPath = "C:/Users/Gillian/Documents/apache-tomcat-7.0.32/work/";
		File destFile = new File(destPath, myFileFileName);
		FileUtils.copyFile(myFile, destFile);
		connection = ConnectionCreation.getConnection();
		uploadCv = connection.prepareStatement("INSERT INTO jobapplication(username, file, jobName, linkedin) VALUES(?, ?, ?, ?)");	
		uploadCv.setString(1, firstName);
		uploadCv.setString(2, myFileFileName);
		uploadCv.setString(3, jobName);
		uploadCv.setString(4, getLinkedin());
		uploadCv.executeUpdate();
		uploadCv.close();
		connection.close();
		return SUCCESS;
	}
	//Getters and Setters needed for Struts
	public String getContentDisposition() {
		return "attachment;filename=\"" + fileDownload + "\"";
	}
	public String getContentType() {
		return "text/plain";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
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
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	public Date getClosing_date() throws ParseException {
		return (Date) format2.parse(format2.format(closing_date));
	}

	public void setClosing_date(Date closing_date) {
		this.closing_date = closing_date;
	}

	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public String getDescription() {
		return description;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public File getFileDownload() {
		return fileDownload;
	}
	public void setFileDownload(File fileDownload) {
		this.fileDownload = fileDownload;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public List<JobApplication> getApplications() {
		return applications;
	}
	public void setApplications(List<JobApplication> applications) {
		this.applications = applications;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
}
