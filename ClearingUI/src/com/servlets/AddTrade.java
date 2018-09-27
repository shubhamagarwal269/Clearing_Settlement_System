package com.servlets;
//comment1
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.pojo.Member;
import com.pojo.Security;
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
		
		List<Security> securities = commFunc.viewAllSecurities();
		List<Member> members = commFunc.viewAllMembers();
		
		int tradeId = commFunc.getNextTradeId();
		String security = request.getParameter("security");
		int quantity  = Integer.parseInt(request.getParameter("quantity"));
		double price = Double.parseDouble(request.getParameter("price"));
		String buyerMember = request.getParameter("buyer");
		String sellerMember = request.getParameter("seller");
		int batchNum = Integer.parseInt(request.getParameter("batch"));
		boolean newBatch = false;
		if(batchNum==1)
			newBatch = true;
		
		int isin = 0;
		if(security.equals("Walmart"))
			isin = 0;
		else if(security.equals("Apple"))
			isin = 1;
		else if(security.equals("GE"))
			isin = 2;
		else if(security.equals("LinkedIn"))
			isin = 3;
		else if(security.equals("Facebook"))
			isin = 4;
		
		int buyerId = commFunc.getMemberId(buyerMember);
		int sellerId = commFunc.getMemberId(sellerMember);
		
		Trade trade = new Trade(tradeId,isin,quantity,price,buyerId,sellerId,batchNum);
		
		//PrintWriter writer = response.getWriter();
		//writer.println(isin+" "+quantity+" "+price+" "+buyerId+" "+sellerId);
		
		int added = admin.addNewTrade(trade, newBatch);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("fetch");
		dispatcher.forward(request, response);
	
	}

}
