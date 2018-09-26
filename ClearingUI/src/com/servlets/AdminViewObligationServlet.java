package com.servlets;

import java.io.IOException;
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
		
		request.setAttribute("reps", list);
		System.out.println("list size:-"+list.size());
		for(int i=0; i<list.size(); i++) {
		    System.out.println(list.get(i));
		}
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminViewObligation.jsp");
		dispatcher.forward(request, response);
			
		
	}

	

}
