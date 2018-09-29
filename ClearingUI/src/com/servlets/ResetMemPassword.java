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
import com.dao.ResetPassword;
import com.dao.SignUpPage;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.ResetPasswordImpl;
import com.dao_impl.SignUpPageImpl;
import com.pojo.Member;

/**
 * Servlet implementation class ResetMemPassword
 */
@WebServlet("/resetmemberpassword")
public class ResetMemPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetMemPassword() {
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
		
		String tpass = request.getParameter("temppass");
		String pass = request.getParameter("pass");
		
		System.out.println(tpass+" "+pass); 
		CommonFunctionalities commfunc = new CommonFunctionalitiesImpl(); 
		ResetPassword rp = new ResetPasswordImpl();
		
		String memMail = commfunc.getMemberEmailForPassReset(tpass);
		int rowsUpdated = rp.updatePassword(pass,memMail);
		int deleted = rp.delPasswordFromTemplist(memMail);
		
		System.out.println(memMail+" "+rowsUpdated+" "+deleted); 

		if(rowsUpdated>0 ) {
			//writer.println("correct");
			message  = false;
			notice = "Passchanged";
			request.setAttribute("alert", message);
			request.setAttribute("type", notice);
			RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
			dispatcher.forward(request, response);
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
			//writer.println("wrong");
		}		
	}

}
