package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.SignInPage;
import com.dao_impl.SignInPageImpl;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String username = request.getParameter("username");
		String option = request.getParameter("options");
		String password = request.getParameter("password");
		
		PrintWriter writer = response.getWriter();
		
		int userType= Integer.parseInt(option);
		SignInPage signindao = new SignInPageImpl();
		
		boolean status = signindao.login(userType, username, password);
		
		if (status) {
			//writer.println("correct");
			//writer.println(option);
			RequestDispatcher dispatcher = request.getRequestDispatcher("dashAdmin.jsp");
			dispatcher.forward(request, response);
			
		} else {
			//RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			writer.println("wrong");
		}
	}

}
