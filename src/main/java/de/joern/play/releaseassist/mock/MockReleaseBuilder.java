package de.joern.play.releaseassist.mock;

import de.joern.play.releaseassist.form.ReleaseBuildForm;

public class MockReleaseBuilder {
	
	public static String buildRelease(ReleaseBuildForm form) {
		
		boolean doFail = form.getGitLabUserName().contains("error");
		
		try {
			return internalCalls(doFail);
		}catch(Exception ex) {
			throw new RuntimeException("Failed to build release.", ex);
		} 
	}
	
	public static String internalCalls(boolean doFail) {
		
		if(doFail) {
			throw new RuntimeException("Internal calls failed.");
		}
		return "releaseBuildMockString";
	}

}