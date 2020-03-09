package de.joern.play.releaseassist.mock;

import de.joern.play.releaseassist.form.ReleaseTableForm;

public class MockReleaseTableBuilder {
	
	
	
	public static String buildReleaseTable(ReleaseTableForm form) {
		
		boolean doFail = form.getJiraUserName().contains("error");
		
		try {
			return internalCalls(doFail);
		}catch(Exception ex) {
			throw new RuntimeException("Failed to build release table.", ex);
		} 
	}
	
	public static String internalCalls(boolean doFail) {
		
		if(doFail) {
			throw new RuntimeException("Internal calls failed.");
		}
		return "releaseTableMockString";
	}

}
