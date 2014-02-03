package hrmOne;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class JobBoardAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private List<Job> jobs = new ArrayList<Job>();;
	private String job_name;
	private String description;
	private String department;
	private Employee employee;
	private Job job;
	private Connection connection;
	private PreparedStatement addJob;
	private PreparedStatement getJobs;
	private PreparedStatement getJobByDepartment;
	private ResultSet results;

	public String forward(){
		return NONE;
	}

	public String execute() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
		addJob = connection.prepareStatement("INSERT INTO Job(job_name, description, department) VALUES(?,?,?)");
		addJob.setString(1, getJob_name());
		addJob.setString(2, getDescription());
		addJob.setString(3, getDepartment());
		addJob.executeUpdate();

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

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public List<Job> getAllJobs(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			getJobs = connection.prepareStatement("SELECT * FROM JOB");
			results = getJobs.executeQuery();

			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("job_name"));
				job.setJobDesc(results.getString("description"));
				job.setDepartment(results.getString("department"));
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

	public List<Job> getJobByDepartment(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			getJobByDepartment = connection.prepareStatement("SELECT * FROM JOB WHERE department=?");
			getJobByDepartment.setString(1, getDepartment());
			results = getJobByDepartment.executeQuery();

			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("job_name"));
				job.setJobDesc(results.getString("description"));
				job.setDepartment(results.getString("department"));
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




}
