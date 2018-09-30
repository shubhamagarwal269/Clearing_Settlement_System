package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/adminHome")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CommonFunctionalities dao = new CommonFunctionalitiesImpl();
	
		int trades = dao.totalTrades();
		int members = dao.totalClearingMembers();
		String FundShort = dao.maxFundShortage();
		String SecShort = dao.maxSecurityShortage();
		req.setAttribute("trade", trades);
		req.setAttribute("member", members);
		req.setAttribute("Funds", FundShort);
		req.setAttribute("Security", SecShort);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("dashAdmin.jsp");
		dispatcher.forward(req, resp);
}
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CommonFunctionalities dao = new CommonFunctionalitiesImpl();
	
		int trades = dao.totalTrades();
		int members = dao.totalClearingMembers();
		String FundShort = dao.maxFundShortage();
		String SecShort = dao.maxSecurityShortage();
		request.setAttribute("trade", trades);
		request.setAttribute("member", members);
		request.setAttribute("Funds", FundShort);
		request.setAttribute("Security", SecShort);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dashAdmin.jsp");
		dispatcher.forward(request, response);
	}

}
