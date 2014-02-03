package hrmOne;

public class Job {
	
	private String jobName;
	private String jobDesc;
	private String department;
	private Employee employee;
	
	
	private Job(){}
	
	public String getJobName() {
		return jobName;
	}
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public String getJobDesc() {
		return jobDesc;
	}
	
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	
	

}
