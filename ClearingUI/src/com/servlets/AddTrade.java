package com.servlets;
//comment1
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.dao_impl.AdminDashboardImpl;
import com.dao_impl.CommonFunctionalitiesImpl;

import com.pojo.Trade;

/**
 * Servlet implementation class AddTrade
 */
@WebServlet("/addnewtrade")
public class AddTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AdminDashboard admin = new AdminDashboardImpl();
		
		CommonFunctionalities commFunc = new CommonFunctionalitiesImpl();
		
		int tradeId = commFunc.getNextTradeId();
		String security = request.getParameter("security");
		
		String temp1 = "set";
		temp1 = request.getParameter("quantity");
		if (temp1.equals("")) {
			temp1="0";
		} 
		int quantity  = Integer.parseInt(temp1);
		String temp2 = "set";
		temp2 = request.getParameter("price");
		if (temp2.equals("")) {
			temp2="0";
		} 
		double price = Double.parseDouble(temp2);
		
		String buyerMember = request.getParameter("buyer");
		String sellerMember = request.getParameter("seller");
		int batchNum = Integer.parseInt(request.getParameter("batch"));
		boolean newBatch = false;
		if(batchNum==1)
			newBatch = true;
		
		int isin = 0;
		if(security.equals("Apple"))
			isin = 0;
		else if(security.equals("Facebook"))
			isin = 1;
		else if(security.equals("GE"))
			isin = 2;
		else if(security.equals("LinkedIn"))
			isin = 3;
		else if(security.equals("Walmart"))
			isin = 4;
		
		int buyerId = commFunc.getMemberId(buyerMember);
		int sellerId = commFunc.getMemberId(sellerMember);
		
		Trade trade = new Trade(tradeId,isin,quantity,price,buyerId,sellerId,batchNum);
		
		//PrintWriter writer = response.getWriter();
		//writer.println(isin+" "+quantity+" "+price+" "+buyerId+" "+sellerId);
		
		admin.addNewTrade(trade, newBatch);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("fetch");
		dispatcher.forward(request, response);
	
	}

}
