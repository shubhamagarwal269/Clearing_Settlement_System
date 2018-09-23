package com.servlets;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.Trade;

/**
 * Servlet implementation class FetchAllTradesServlet
 */
@WebServlet("/fetch")
public class FetchAllTradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAllTradesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CommonFunctionalities commFunc = new CommonFunctionalitiesImpl();
		
		List<Trade> trades = commFunc.viewAllTrades();
		request.setAttribute("trades", trades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("gensetTrades.jsp");
		dispatcher.forward(request, response);
	}

}
