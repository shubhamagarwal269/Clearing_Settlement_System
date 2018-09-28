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
@WebServlet("/viewNetting")
public class AdminViewNettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewNettingServlet() {
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
		List<BigDecimal> fund = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ fund.add(i, new BigDecimal(list.get(i).getObligation().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
		}
		request.setAttribute("reps", list);
		request.setAttribute("fund", fund);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminViewNetting.jsp");
		dispatcher.forward(request, response);
		
	}

		

}
