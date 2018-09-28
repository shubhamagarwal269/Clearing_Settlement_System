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
 * Servlet implementation class UpdateMarketData
 */
@WebServlet("/updatemarketdata")
public class UpdateMarketData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMarketData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminDashboard admin = new AdminDashboardImpl();
		
		if (request.getParameter("isinA") != null) {
			int isin = Integer.parseInt(request.getParameter("isinA"));
			double updatedmarketprice = Double.parseDouble(request.getParameter("newmarketprice"));
			int updatedmktprice = admin.updateMarketPrice(isin, updatedmarketprice);
		} 
		else if(request.getParameter("isinB") != null){
			int isin = Integer.parseInt(request.getParameter("isinB"));
			double newborrowrate = Double.parseDouble(request.getParameter("newborrowrate"));
			
			int updatedborrowrate = admin.updateBorrowingRate(isin, newborrowrate);
		}
		else {
			double newfundborrow = Double.parseDouble(request.getParameter("newfundborrow"));
			
			int updatedfundborrowrate = admin.updateFundBorrowingRate(newfundborrow);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("fetchmarket");
		dispatcher.forward(request, response);
		
	}
}
