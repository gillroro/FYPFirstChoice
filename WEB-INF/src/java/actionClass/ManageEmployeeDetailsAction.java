package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class ManageEmployeeDetailsAction extends ActionSupport implements Preparable, SessionAware{

	private static final long serialVersionUID = 1L;
	private List<Employee> employees = new ArrayList<Employee>();
	private Connection connection;
	private PreparedStatement getEmployee;	
	private ResultSet results;
	private Employee manager;
	private Employee employee;
	
	private Map<String, Object> session;

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		if(session.containsKey("manager")){
			setManager((Employee) session.get("manager"));
		}
		if(session.containsKey("employee")){
			setEmployee((Employee)session.get("employee"));
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setSession(Map map) {
		session = (SessionMap) map;
	}

	public String execute() throws ClassNotFoundException, SQLException {
		getAllEmployees();
		if(employees != null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}

	public List<Employee> getEmployees() {
		
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public List<Employee> getAllEmployees() {
		try{
			connection = ConnectionCreation.getConnection();
			getEmployee = connection.prepareStatement("SELECT * FROM employee");
			results = getEmployee.executeQuery();
			while(results.next()){
				Employee employee = new Employee();
				employee.setFirstName(results.getString("first_name"));
				employee.setSurname(results.getString("surname"));
				employee.setUsername(results.getString("username"));
				employee.setPassword(results.getString("password"));
				employee.setAddress(results.getString("address"));
				employee.setSalary(results.getInt("salary"));
				employee.setUserType(results.getString("user_type"));
				employee.setManager(results.getInt("manager"));
				employees.add(employee);

			}
			for(int i=0; i<employees.size(); i++){
				System.out.print(employees.get(i));
			}
			results.close();
			connection.close();
			getEmployee.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return employees;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}



}
