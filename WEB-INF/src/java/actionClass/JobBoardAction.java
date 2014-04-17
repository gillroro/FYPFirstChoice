package actionClass;

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

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
import entity.Job;

public class JobBoardAction extends ActionSupport implements Preparable, SessionAware {


	private static final long serialVersionUID = 1L;
	private List<Job> jobs = new ArrayList<Job>();;
	private String job_name,description,department;
	private Employee employee;
	private Job job;
	private Date closing_date;
	private Connection connection;
	private PreparedStatement addJob,getJobs,getJobByDepartment;
	private ResultSet results;
	SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	
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

	public String forward(){
		return NONE;
	}

	public String execute() throws ClassNotFoundException, SQLException{
		
		connection = ConnectionCreation.getConnection();
		addJob = connection.prepareStatement("INSERT INTO Job(job_name, description, department, closing_date) VALUES(?,?,?,?)");
		addJob.setString(1, getJob_name());
		addJob.setString(2, getDescription());
		addJob.setString(3, getDepartment());
		addJob.setDate(4, (java.sql.Date)closing_date);
		addJob.executeUpdate();
		job.setDepartment(department);
		job.setJobDesc(description);
		job.setJobName(job_name);
		session.put("Job", job);
		return SUCCESS;
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
			
			connection = ConnectionCreation.getConnection();
			getJobs = connection.prepareStatement("SELECT * FROM JOB");
			results = getJobs.executeQuery();
			java.util.Date today = new java.util.Date();
			Date sqlToday = new Date(today.getTime());
			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("job_name"));
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

	public List<Job> getJobByDepartment(){
		try {
			connection = ConnectionCreation.getConnection();
			getJobByDepartment = connection.prepareStatement("SELECT * FROM JOB WHERE department LIKE ?");
			getJobByDepartment.setString(1, "%"+department+"%");
			results = getJobByDepartment.executeQuery();
			while(results.next()){
				Job job = new Job();
				job.setJobName(results.getString("job_name"));
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
		if(jobs != null){
			for(int i=0; i< jobs.size(); i++){
				System.out.println(jobs.get(i).getJobName());
			}
			return SUCCESS;
		}
		else{
			return "failure";
		}
	}
	
	public String displayApplications(){
		return NONE;
	}
	
	public String jobApplication(){
		System.out.println();
		return NONE;
	}
}
