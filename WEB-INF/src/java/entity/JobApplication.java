package entity;

import java.io.File;

public class JobApplication {
	
	private String username;
	private String linkedin;
	private String jobName;
	private String file;
	private File fileDownload;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public File getFileDownload() {
		return fileDownload;
	}
	public void setFileDownload(File fileDownload) {
		this.fileDownload = fileDownload;
	}

}
