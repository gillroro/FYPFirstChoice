package actionClass;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import util.WebSession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import database.ConnectionCreation;
import entity.Employee;
import entity.Project;
/*
 * This class has been designed to deal with all aspects of the project side of the company. Managers can add, view and delete projects
 * from the application. They can also assign employees to projects. Employees can just provide details of what projects they have completed
 * or that are still incomplete on the appraisal form.
 */
public class ProjectAction extends ActionSupport implements Preparable,SessionAware{

	private static final long serialVersionUID = 1L;
	private String projectName,employeeName,department, firstName;
	private Date startDate,endDate;
	private Connection connection;
	private PreparedStatement addProject,getProjects,deleteProject,getEmployees, addMemberToProject;
	private ResultSet results;
	private List<Project> projects = new ArrayList<Project>();
	private List<Employee> members = new ArrayList<Employee>();
	private Map<String, Object> session;
	private Project project;
	private Employee employee;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map arg0) {
		session = arg0;
	}

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		if(session.containsKey("project")){
			project = (Project)session.get("project");
		}
		if(session.containsKey("employee")){
			setEmployee((Employee) session.get("employee"));
		}

	}

	public String createProject(){
		try {
			project = new Project();
			connection = ConnectionCreation.getConnection();
			addProject = connection.prepareStatement("INSERT INTO project(projectName, startDate, endDate, department) VALUES (?,?,?,?)");
			addProject.setString(1, getProjectName());
			addProject.setDate(2, getStartDate());
			addProject.setDate(3, getEndDate());
			addProject.setString(4, getDepartment());
			addProject.executeUpdate();
			project.setProjectName(projectName);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
			project.setDepartment(department);
			session.put("project", project);
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
				if(session.containsKey("project")){
					session.remove("project");
				}
			}
		}
		connection.close();
		deleteProject.close();
		return SUCCESS;
	}

	public String assignEmployeeToProject(){
		getAllEmployees();
		getAllProjects();
		return SUCCESS;
	}

	public String assignmentComplete(){
		try {
			connection = ConnectionCreation.getConnection();
			addMemberToProject = connection.prepareStatement("INSERT INTO project_member(projectName, firstName, status) VALUES (?,?,?)" );
			addMemberToProject.setString(1, projectName);
			addMemberToProject.setString(2, firstName);
			addMemberToProject.setString(3, "Incomplete");
			addMemberToProject.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	//Getters and Setters
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
