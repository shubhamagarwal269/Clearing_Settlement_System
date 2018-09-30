package com.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.GenerateMemberReport;
import com.dao_impl.GenerateMemberReportImpl;
import com.pojo.MemberReport;

/**
 * Servlet implementation class AdminViewObligation
 */
@WebServlet("/viewObligation")
public class AdminViewObligationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewObligationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		GenerateMemberReport dao = new GenerateMemberReportImpl();
		List<MemberReport> list = dao.viewAllMembersReports();
		List<BigDecimal> fundBalance1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance1.add(new BigDecimal(list.get(i).getCurrentBalance().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation1.add(new BigDecimal(list.get(i).getObligation().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage1.add(new BigDecimal(list.get(i).getShortage().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement.add(new BigDecimal(list.get(i).getSettlementCost().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance", fundBalance1);
		request.setAttribute("fundObligation", fundObligation1);
		
		request.setAttribute("fundShortage", fundShortage1);
		request.setAttribute("fundSettlement", fundSettlement);
		
		request.setAttribute("reps", list);
		
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminViewObligation.jsp");
		dispatcher.forward(request, response);
			
		
	}

	

}
