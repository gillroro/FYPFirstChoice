package actionClass;

import java.sql.Connection;
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
import entity.Skill;

public class SkillsAction extends ActionSupport implements Preparable, SessionAware{

	private static final long serialVersionUID = 1L;
	private String skillName,proof,description, name;
	private List<Skill> skills = new ArrayList<Skill>();
	private Connection connection;
	private PreparedStatement addSkills,getSkills,addProof,addSkillToEmployee;
	private ResultSet results;
	private Map<String, Object> session;
	private Skill skill;
	private Employee employee;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSession(Map arg0) {
		session = arg0;

	}

	@Override
	public void prepare() throws Exception {
		session = WebSession.getWebSessionInstance();
		if(session.containsKey("skill")){
			skill = (Skill) session.get("skill");
		}
		if(session.containsKey("employee")){
			employee = (Employee) session.get("employee");
		}

	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Skill> getSkills() {
		return skills;
	}

	public List<Skill> getAllSkills() {
		try{

			connection = ConnectionCreation.getConnection();
			getSkills = connection.prepareStatement("SELECT * FROM Skill");
			results = getSkills.executeQuery();
			while(results.next()){	
				Skill skill = new Skill();	
				skill.setName(results.getString("Name"));
				skill.setDescription(results.getString("Description"));
				skills.add(skill);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return skills;
	}

	public String display(){
		getAllSkills();
		if(skills!=null){
			return SUCCESS;
		}
		else {
			return "failure";
		}
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public String execute(){
		try {
			Skill skill = new Skill();
			connection = ConnectionCreation.getConnection();
			addSkills = connection.prepareStatement("INSERT INTO Skill(name, description) VALUES(?,?)");
			addSkills.setString(1, getSkillName());
			addSkills.setString(2, getDescription());
			addSkills.executeUpdate();
			skill.setName(skillName);
			skill.setDescription(description);
			session.put("skill", skill);
			connection.close();
			addSkills.close();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public String addProof(){
		try {
			connection = ConnectionCreation.getConnection();
			addProof = connection.prepareStatement("INSERT INTO skill_proof(employee_name, proof) VALUES(?,?)");
			addProof.setString(1, employee.getFirstName());
			addProof.setString(2,getProof());
			addProof.executeUpdate();
			addSkillToEmployee = connection.prepareStatement("INSERT INTO employee_skill(SkillName,EmployeeName) VALUES(?,?)");
			addSkillToEmployee.setString(1,employee.getFirstName());
			addSkillToEmployee.setString(2,skill.getName());
			addSkillToEmployee.executeUpdate();
			connection.close();
			addProof.close();
			addSkillToEmployee.close();
			return SUCCESS;
		} catch (SQLException e) {	
			e.printStackTrace();
			return "failure";
		}
	}

	public String forward(){
		return NONE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
