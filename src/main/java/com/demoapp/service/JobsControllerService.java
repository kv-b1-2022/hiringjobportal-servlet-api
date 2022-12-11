package com.demoapp.service;

import javax.servlet.http.HttpServletRequest;

import com.demoapp.dao.ApplicationDAO;
import com.demoapp.dao.JobsDAO;
import com.demoapp.service.JobValidation;
import com.demoapp.model.Application;
import com.demoapp.validation.JobsValidation;

public class JobsControllerService {

	/**
	 * applying jobs using user mail id and job id
	 */
	public static String applyJobs(HttpServletRequest request) throws Exception {

		String result = null;
		String userMailId = request.getParameter("userMailId");
		int applicationId = Integer.parseInt(request.getParameter("jobId"));
		int option = 0;

		// creating object for model class
		Application application = new Application();

		// set value in to model class
		application.setJobid(applicationId);
		application.setMailId(userMailId);

		try {
			JobsValidation.applyJobValidation(application);
			option = JobsDAO.jobUpdateVacancy(applicationId);
			if (option == 1) {
				result = ApplicationDAO.insert();
			}
			else {
				
			}
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;

	}

	public static String viewMyApplication() {
		
		return null;
	}

}
