package de.joern.play.releaseassist.form;

public class ReleaseBuildForm {
	
	private String gitLabUserName;
	
	private String gitLabPassword;

	public String getGitLabUserName() {
		return gitLabUserName;
	}

	public void setGitLabUserName(String gitLabUserName) {
		this.gitLabUserName = gitLabUserName;
	}

	public String getGitLabPassword() {
		return gitLabPassword;
	}

	public void setGitLabPassword(String gitLabPassword) {
		this.gitLabPassword = gitLabPassword;
	}
}