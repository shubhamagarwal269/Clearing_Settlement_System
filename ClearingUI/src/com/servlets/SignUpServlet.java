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
		
		String notice= null;
		boolean message = true;
		
		String membername = request.getParameter("membername");
		String emailid = request.getParameter("emailid");
		int bankac = Integer.parseInt(request.getParameter("bankac"));
		int dematac = Integer.parseInt(request.getParameter("dematac"));
		String password = request.getParameter("pass");
		
		SignUpPage signUpDao = new SignUpPageImpl();
		
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		int memId = commonFunc.getNextMemberId();
		
		Member mem = new Member(memId,membername,password,emailid,bankac,dematac);
		
		PrintWriter writer = response.getWriter();
		int rowsUpdated = signUpDao.registerMember(mem);

		if(rowsUpdated>0) {
			//writer.println("correct");
			message  = false;
			notice = "memRegistered";
			request.setAttribute("alert", message);
			request.setAttribute("type", notice);
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			//writer.println("wrong");
		}
	}

}
