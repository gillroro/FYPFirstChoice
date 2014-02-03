package hrmOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SkillsAction extends ActionSupport {

	private String skillName;
	private String description;
	private List<Skill> skills;
	private Connection connection;
	private PreparedStatement addSkills;
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
