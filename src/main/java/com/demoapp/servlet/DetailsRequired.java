package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoapp.dao.UserDAO;
import com.demoapp.model.UserDetails;

/**
 * Servlet implementation class DetailsRequired
 */
@WebServlet("/DetailsRequired")
public class DetailsRequired extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsRequired() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String mailId = request.getParameter("mailId");
		String password = request.getParameter("password");
		String userName = request.getParameter("name");
		String DOB = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String branch = request.getParameter("branch");
		String course = request.getParameter("course");
		String collegeName = request.getParameter("collegeName");
		String number = request.getParameter("phoneNumber");
		
		long phoneNumber = Long.parseLong(number);
		PrintWriter out = response.getWriter();
		UserDetails details = new UserDetails();
		details.setUserName(userName);
		details.setDOB(DOB);
		details.setCollegeName(collegeName);
		details.setCource(course);
		details.setBranch(branch);
		details.setUserMailId(mailId);
		details.setUserPass(password);
		
		try {
			int n = UserDAO.insert(details, gender, phoneNumber);
			if (n >= 1) {
				//response.sendRedirect("displaySearchingJobs.html");
//								Gson gson = new Gson();
//								String userJson = gson.toJson("success");
								String result = "success";
								out.println(result);
								//response.sendRedirect("user/detalisRequired/detailsrequired.html");

							} else {
								String result ="unsuccess";
								// response.sendRedirect("userRegistration.html?name="+"block");
								System.out.println(result);
							}

						
						
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
