package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDashboard;
import com.dao_impl.AdminDashboardImpl;

/**
 * Servlet implementation class AddRandomTrade
 */
@WebServlet("/addnewrandomtrade")
public class AddRandomTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRandomTrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String temp = "set";
		temp = request.getParameter("noOfTrade");
		if (temp.equals("")) {
			temp="0";
		} 
		int noOfTrade  = Integer.parseInt(temp);
		int batchNum = Integer.parseInt(request.getParameter("batch"));
		boolean newBatch = false;
		if(batchNum==1)
			newBatch = true;
		AdminDashboard adminDao = new AdminDashboardImpl();
		adminDao.addRandomTrade(noOfTrade,newBatch);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("fetch");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
