package de.joern.play.releaseassist.form;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReleaseTableForm {
	
	private String jiraUserName;
	
	private String jiraPassword;
	
	private String lastReleaseBranchName;
	

	public String getJiraUserName() {
		return jiraUserName;
	}

	public void setJiraUserName(String jiraUserName) {
		this.jiraUserName = jiraUserName;
	}

	public String getJiraPassword() {
		return jiraPassword;
	}

	public void setJiraPassword(String jiraPassword) {
		this.jiraPassword = jiraPassword;
	}

	public String getLastReleaseBranchName() {
		return lastReleaseBranchName;
	}

	public void setLastReleaseBranchName(String lastReleaseBranchName) {
		this.lastReleaseBranchName = lastReleaseBranchName;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}