package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

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
	private ResultSet results;


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
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
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
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp","root", "root");
			addSkills = connection.prepareStatement("INSERT INTO Skill(name, description) VALUES(?,?)");
			addSkills.setString(1, getSkillName());
			addSkills.setString(2, getDescription());
			addSkills.executeUpdate();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		
	}
	
	
	
	public String forward(){
		return NONE;
	}




}
