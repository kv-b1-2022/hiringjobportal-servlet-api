package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoapp.dao.JobsDAO;
import com.demoapp.model.JobProfile;
import com.google.gson.Gson;

/**
 * Servlet implementation class DisplayJobsBySalary
 */
@WebServlet("/DisplayJobsBySalaryServlet")
public class DisplayJobsBySalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayJobsBySalaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JobsDAO obj = new JobsDAO();
		
		PrintWriter out = response.getWriter();
		try {
			List<JobProfile> jobFile = obj.getAllDetailsSalary();
			Gson gson = new Gson();
			String userJson = gson.toJson(jobFile);
			out.println(userJson);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
