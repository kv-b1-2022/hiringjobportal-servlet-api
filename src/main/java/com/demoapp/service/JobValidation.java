package com.demoapp.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import com.demoapp.model.Application;
import com.demoapp.model.JobProfile;


import com.demoapp.dao.ApplicationDAO;
import com.demoapp.dao.JobsDAO;

public class JobValidation {

	public int addJob(HttpServletRequest request) throws Exception {
		JobValidation obj1 = new JobValidation();
		System.out.println("1).Enter the jobId");
		int jobId = 25;
		System.out.println("2).Enter your  branch");
		String branch ="IT";
		System.out.println("3).Enter your comapny name");
		String companyName = "finsurge";
		System.out.println("4).Enter your roll");
		String roll = "SD";
		System.out.println("5).Enter your vacancy ");
		int vacancy = 9;
		System.out.println("5).Enter your location");
		String place ="nagercoil";
		System.out.println("6).Enter lost entry date");
		String date = "2022-04-21";
		System.out.println("7).Enter the skils details");
		String Skills = "python";
		System.out.println("8).Enter the salery");
		int salery = 500000;
		String mailId = "rev@revature.com";

		JobProfile obj = new JobProfile(jobId, companyName, branch, roll, vacancy, place, date, Skills, salery,mailId);
		int result = JobsDAO.jobinsert(obj);
		return result;
	}

	public int deleteJob(int JobId) throws Exception {
		int result = 0;
		result = JobsDAO.jobDelete(JobId);
		return result;

	}

	public int updateJob() throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdate();
		return result;
	}


	public ArrayList<JobProfile> jobSerching(JobProfile jobProfile) throws Exception {

		ArrayList<JobProfile> jobFiles = JobsDAO.jobSearchigSkills(jobProfile);
		return jobFiles;
	}

	
	

	public int updateJobSkills(JobProfile details) throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdateSkills(details);
		return result;
	}

	public int updateJobSalary(JobProfile details) throws Exception {
		int result = 0;
		result = JobsDAO.jobUpdateSalery(details);
		return result;
	}

}
