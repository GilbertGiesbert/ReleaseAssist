package de.joern.play.releaseassist.mock;

import de.joern.play.releaseassist.form.ReleaseBranchForm;

public class MockReleaseBranchBuilder {
	
	public static String buildReleaseBranch(ReleaseBranchForm form) {
		
		boolean doFail = form.getGitLabUserName().contains("error");
		
		try {
			return internalCalls(doFail);
		}catch(Exception ex) {
			throw new RuntimeException("Failed to build release branch.", ex);
		} 
	}
	
	public static String internalCalls(boolean doFail) {
		
		if(doFail) {
			throw new RuntimeException("Internal calls failed.");
		}
		return "releaseBranchMockString";
	}

}