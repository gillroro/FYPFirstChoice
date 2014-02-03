package hrmOne;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class JobBoardAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	private List<Job> jobs;
	private String jobName;
	private String description;
	private String department;
	private Employee employee;
	private Job job;
	private Connection connection;
	private PreparedStatement addJob;
	
	public String forward(){
		return NONE;
	}
	
	public String execute() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
		addJob = connection.prepareStatement("INSERT INTO Job(job_name, description, department) VALUES(?,?,?)");
		addJob.setString(1, getJobName());
		addJob.setString(2, getDescription());
		addJob.setString(3, getDepartment());
		addJob.executeUpdate();
		jobs = new ArrayList<Job>();
//		job.setDepartment(department);
//		job.setJobDesc(description);
//		job.setJobName(jobName);
//		jobs.add(job);
		return SUCCESS;
	}
	
	
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDescription() {
		return description;
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
	
	
	

}
