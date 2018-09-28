package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.Member;
import com.pojo.Security;
import com.pojo.Trade;

/**
 * Servlet implementation class FetchMarketData
 */
@WebServlet("/fetchmarket")
public class FetchMarketData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchMarketData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		CommonFunctionalities commFunc = new CommonFunctionalitiesImpl();
			
		List<Security> securities = commFunc.viewAllSecurities();
		double fundborrow = commFunc.getFundBorrow();
		
		request.setAttribute("securities", securities);
		request.setAttribute("fundborrow", fundborrow);
		
		System.out.println("rate = "+fundborrow);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateMarket.jsp");
		dispatcher.forward(request, response);
		
	}

}
