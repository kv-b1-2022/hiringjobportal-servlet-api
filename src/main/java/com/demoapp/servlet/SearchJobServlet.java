package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoapp.service.JobValidation;

import com.demoapp.model.JobProfile;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchJobServlet
 */
@WebServlet("/SearchJobServlet")
public class SearchJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchJobServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String skill = "java";
		JobValidation job = new JobValidation();
		JobProfile jobProfile = new JobProfile();
		jobProfile.setSkills(skill);
		PrintWriter out =null;

		try {
			out = response.getWriter();
			ArrayList<JobProfile> jobFiles = job.jobSerching(jobProfile);
			Gson gson = new Gson();
			String userJson = gson.toJson(jobFiles);
			out.println(userJson);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		doGet(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
