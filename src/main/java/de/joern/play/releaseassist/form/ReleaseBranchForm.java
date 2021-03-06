package de.joern.play.releaseassist.form;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ReleaseBranchForm {
	
	private String releaseBranchName;
	
	private String gitLabUserName;
	
	private String gitLabPassword;
	
	private String revertList;
	
	private String initDocumentationReleasePageUrl;
	
	private String initDocumentationUserName;
	
	private String initDocumentationPassword;

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

	public String getRevertList() {
		return revertList;
	}

	public void setRevertList(String revertList) {
		this.revertList = revertList;
	}

	public String getInitDocumentationReleasePageUrl() {
		return initDocumentationReleasePageUrl;
	}

	public void setInitDocumentationReleasePageUrl(String initDocumentationReleasePageUrl) {
		this.initDocumentationReleasePageUrl = initDocumentationReleasePageUrl;
	}

	public String getInitDocumentationUserName() {
		return initDocumentationUserName;
	}

	public void setInitDocumentationUserName(String initDocumentationUserName) {
		this.initDocumentationUserName = initDocumentationUserName;
	}

	public String getInitDocumentationPassword() {
		return initDocumentationPassword;
	}

	public void setInitDocumentationPassword(String initDocumentationPassword) {
		this.initDocumentationPassword = initDocumentationPassword;
	}

	public String getReleaseBranchName() {
		return releaseBranchName;
	}

	public void setReleaseBranchName(String releaseBranchName) {
		this.releaseBranchName = releaseBranchName;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}