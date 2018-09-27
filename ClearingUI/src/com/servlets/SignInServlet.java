package com.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

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
		
		String username = request.getParameter("username");
		String option = request.getParameter("options");
		String password = request.getParameter("password");
		boolean message = true;
		String notice = null; 
		//PrintWriter writer = response.getWriter();
		
		SignInPage signindao = new SignInPageImpl();
		if (option.equals("0") ) {
			if(username.equals("cns065918@gmail.com") && password.equals("admin@123")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("dashAdmin.jsp");
				dispatcher.forward(request, response);
			} 
			else {
				message  = false;
				notice = "wrongCred";
				//String message = "You have entered wrong credentials, Please try again";
				request.setAttribute("alert", message);
				request.setAttribute("type", notice);
				RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			int rowsUpdated = signindao.login(username, password);
			  if (rowsUpdated>0) {
					//writer.println("correct");
					//writer.println(option);
					RequestDispatcher dispatcher = request.getRequestDispatcher("dashMember.jsp");
					dispatcher.forward(request, response);
			  }  
			  else {
				message  = false;
				notice = "wrongCred";
				//String message = "You have entered wrong credentials, Please try again";
				request.setAttribute("alert", message);
				request.setAttribute("type", notice);
				RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
				dispatcher.forward(request, response);
			  }	
		}
	}

}
