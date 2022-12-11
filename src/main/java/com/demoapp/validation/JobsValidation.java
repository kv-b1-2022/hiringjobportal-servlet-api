package com.demoapp.validation;

import com.demoapp.model.Application;

public class JobsValidation {
	
	public static void applyJobValidation(Application application) throws Exception {
		
		String userMailId = application.getMailId();
		int applicationId = application.getJobid();
	
		if( userMailId == null || userMailId.trim() == "") {
			throw new Exception ("invalid login creadenctial");
		}
		if(userMailId.contains("@gmail.com")) {
			throw new Exception ("invalid login creadenctial");
		}
		
	}

}
