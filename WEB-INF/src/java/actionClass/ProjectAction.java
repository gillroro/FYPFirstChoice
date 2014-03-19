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
	private PreparedStatement deleteProject;
	private PreparedStatement getEmployees;
	private ResultSet results;
	private WebSession ws;
	private Employee employee;
	private Project project;
	private List<Project> projects = new ArrayList<Project>();
	private List<Employee> members = new ArrayList<Employee>();
	private List<String> membersName = new ArrayList<String>();
	private List<String> projectNames = new ArrayList<String>();
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
	
	public String deleteProject() throws SQLException{
		getAllProjects();
		for(int i=0; i< projects.size(); i++){
			if(projects.get(i).getProjectName().equalsIgnoreCase(projectName)){
				connection = ConnectionCreation.getConnection();
				deleteProject = connection.prepareStatement("DELETE FROM PROJECT WHERE projectName= ?");
				deleteProject.setString(1, projectName);
				deleteProject.executeUpdate();
			}
		}
		connection.close();
		deleteProject.close();
		
		return SUCCESS;
		
		
	}
	
	public String assignEmployeeToProject(){
		getAllEmployeeNames();
		getAllProjectNames();
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
	
	public List<Employee> getAllEmployees(){
		try {
			
			connection =ConnectionCreation.getConnection();
			getEmployees = connection.prepareStatement("SELECT * FROM EMPLOYEE");
			results = getEmployees.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setAddress(results.getString("address"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setUserType(results.getString("user_type"));

				if(employee.getUserType().equalsIgnoreCase("employee")){
					members.add(employee);
					
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return members;
		
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
	
	public List<String> getAllEmployeeNames(){
		getAllEmployees();
		for (int i=0; i<members.size(); i++){
			String name = members.get(i).getFirstName() +" "+ members.get(i).getSurname();
			membersName.add(name);
		}
		return membersName;
	}
	
	public List<String> getAllProjectNames(){
		getAllProjects();
		for (int i=0; i<projects.size(); i++){
			String name = projects.get(i).getProjectName();
			projectNames.add(name);
		}
		return projectNames;
	}

	public List<String> getMembersName() {
		return membersName;
	}

	public void setMembersName(List<String> membersName) {
		this.membersName = membersName;
	}

	public List<String> getProjectNames() {
		return projectNames;
	}

	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}
	
	
	
	

}
