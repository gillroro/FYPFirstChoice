package actionClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
import entity.Employee;
import entity.Project;

public class ProjectAction extends ActionSupport {

	
	private static final long serialVersionUID = 1L;
	
	private String projectName;
	private Date startDate;
	private Date endDate;
	private String department;
	private Connection connection;
	private PreparedStatement addProject;
	private PreparedStatement getProjects;
	private ResultSet results;
	private WebSession ws;
	private Employee employee;
	private Project project;
	private List<Project> projects = new ArrayList<Project>();
	private List<Employee> members = new ArrayList<Employee>();
	SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	
	public String createProject(){
		try {
			connection = ConnectionCreation.getConnection();
			addProject = connection.prepareStatement("INSERT INTO project(projectName, startDate, endDate, department) VALUES (?,?,?,?)");
			addProject.setString(1, getProjectName());
			addProject.setDate(2, getStartDate());
			addProject.setDate(3, getEndDate());
			addProject.setString(4, getDepartment());
			addProject.executeUpdate();
			connection.close();
			addProject.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String deleteProject(){
		
		return SUCCESS;
		
		
	}
	
	public String assignEmployeeToProject(){
		return SUCCESS;
	}
	
	public List<Project> getAllProjects(){
		try {
			connection = ConnectionCreation.getConnection();
			getProjects = connection.prepareStatement("SELECT * FROM PROJECT");
			results = getProjects.executeQuery();
			while(results.next()){
				Project project = new Project();
				project.setProjectName(results.getString("projectName"));
				project.setStartDate(results.getDate("startDate"));
				project.setEndDate(results.getDate("endDate"));
				project.setDepartment(results.getString("department"));
				projects.add(project);

			}
			connection.close();
			getProjects.close();
			results.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return projects;
	}
	
	public String displayAllProjects(){
		getAllProjects();
		if(projects != null){
			return SUCCESS;
		}
		else{ 
			return "failure";
		}
	}
	
	public String forward(){
		return NONE;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Employee> getMembers() {
		return members;
	}

	public void setMembers(List<Employee> members) {
		this.members = members;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	
	

}
