package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.LogManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoapp.service.JobsControllerService;

//import com.demoapp.dao.JobsDAO;

/**
 * Servlet implementation class JobsControllers
 */

public class JobsControllersDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static Logger log = LogManager.getLogger(JobsControllersDispatcher.class);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobsControllersDispatcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		System.out.println(url);
		String result = null;
		
		PrintWriter out = response.getWriter();
		try {
			switch (url) {
			case "/app/api/applyJobs":
				result = JobsControllerService.applyJobs(request);
				System.out.println(result);
				break;
			case "/app/api/viewMyJobs":
				result = JobsControllerService.viewMyApplication();
				break;
			default:
				break;
			}
		} catch (Exception e) {

		}
		System.out.println(result);
		out.println(result);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
