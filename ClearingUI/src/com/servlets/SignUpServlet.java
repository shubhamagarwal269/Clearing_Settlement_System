package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao.SignUpPage;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.SignUpPageImpl;
import com.pojo.Member;
import com.pojo.UserDetails;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String membername = request.getParameter("membername");
		String emailid = request.getParameter("emailid");
		String bankac = request.getParameter("bankac");
		String dematac = request.getParameter("dematac");
		String password = request.getParameter("pass");
		
		SignUpPage signUpDao = new SignUpPageImpl();
		
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		String memId = commonFunc.getNextMemberId();
		
		Member mem = new Member(memId,membername,emailid,bankac,dematac);
		UserDetails user = new UserDetails(emailid,password,1);
		
		PrintWriter writer = response.getWriter();
		System.out.println("hi");
		int status = signUpDao.registerMember(mem, user);
		System.out.println("hi1");
		if(status>0) {
			//writer.println("correct");
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			//writer.println("wrong");
		}
	}

}
