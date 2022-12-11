package com.demoapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demoapp.service.userService;
import com.demoapp.validation.UserValidation;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");

		String mailId = request.getParameter("mailId");
		String password = request.getParameter("pass");

		PrintWriter out = response.getWriter();
		String result = null;

		userService service = new userService();
		UserValidation validate = new UserValidation();

		try {

			int a = service.loginService(mailId, password);
			System.out.println(a);
			if (a == 1) {

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
