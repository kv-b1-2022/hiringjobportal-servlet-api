package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.demoapp.service.userService;

import com.demoapp.model.UserDetails;

/**
 * Servlet implementation class registerServelet
 */
@WebServlet("/RegisterServelet")
public class RegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		UserDetails user = new UserDetails();
		String mailId = request.getParameter("mailId");
		user.setUserMailId(mailId);
		String password = request.getParameter("pass");
		user.setUserPass(password);
		PrintWriter out = response.getWriter();
		userService service = new userService();
		String result = null;
		try {

			int a = service.registerService(mailId, password);
			System.out.println(a);
			if (a == 0) {

				result = "success";

			} else {
				throw new Exception("unsuccess");

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		}
		out.println(result);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
