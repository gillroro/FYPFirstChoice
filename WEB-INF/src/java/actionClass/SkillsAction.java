package actionClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import database.ConnectionCreation;
import entity.Skill;

public class SkillsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String skillName;
	private String description;
	private List<Skill> skills = new ArrayList<Skill>();
	private Connection connection;
	private PreparedStatement addSkills;
	private PreparedStatement getSkills;
	private PreparedStatement addProof;
	private PreparedStatement addSkillToEmployee;
	private ResultSet results;
	private String proof;
	
	


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
	
			connection = ConnectionCreation.getConnection();
			addSkills = connection.prepareStatement("INSERT INTO Skill(name, description) VALUES(?,?)");
			addSkills.setString(1, getSkillName());
			addSkills.setString(2, getDescription());
			addSkills.executeUpdate();
			connection.close();addSkills.close();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		
	}
	
	public String addProof(){
		try {
		connection = ConnectionCreation.getConnection();
		addProof = connection.prepareStatement("INSERT INTO skill_proof(employee_id, proof) VALUES(?,?)");
		addProof.setInt(1, 1);
		addProof.setString(2,getProof());
		addProof.executeUpdate();
		addSkillToEmployee = connection.prepareStatement("INSERT INTO employee_skill(SkillId,EmployeeId) VALUES(?,?)");
		addSkillToEmployee.setInt(1,1);
		addSkillToEmployee.setInt(2, 1);
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




}
