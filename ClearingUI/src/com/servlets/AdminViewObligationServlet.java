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
		List<BigDecimal> fundBalance5 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance5.add(new BigDecimal(list.get(i).getCurrentBalance().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation5 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation5.add(new BigDecimal(list.get(i).getObligation().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage5 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage5.add(new BigDecimal(list.get(i).getShortage().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement5 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement5.add(new BigDecimal(list.get(i).getSettlementCost().get(5)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance5", fundBalance5);
		request.setAttribute("fundObligation5", fundObligation5);
		
		request.setAttribute("fundShortage5", fundShortage5);
		request.setAttribute("fundSettlement5", fundSettlement5);
		
		List<BigDecimal> fundBalance4 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance4.add(new BigDecimal(list.get(i).getCurrentBalance().get(4)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation4 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation4.add(new BigDecimal(list.get(i).getObligation().get(4)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage4 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage4.add(new BigDecimal(list.get(i).getShortage().get(4)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement4 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement4.add(new BigDecimal(list.get(i).getSettlementCost().get(4)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance4", fundBalance4);
		request.setAttribute("fundObligation4", fundObligation4);
		
		request.setAttribute("fundShortage4", fundShortage4);
		request.setAttribute("fundSettlement4", fundSettlement4);
		
		List<BigDecimal> fundBalance3 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance3.add(new BigDecimal(list.get(i).getCurrentBalance().get(3)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation3 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation3.add(new BigDecimal(list.get(i).getObligation().get(3)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage3 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage3.add(new BigDecimal(list.get(i).getShortage().get(3)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement3 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement3.add(new BigDecimal(list.get(i).getSettlementCost().get(3)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance3", fundBalance3);
		request.setAttribute("fundObligation3", fundObligation3);
		
		request.setAttribute("fundShortage3", fundShortage3);
		request.setAttribute("fundSettlement3", fundSettlement3);
		
		List<BigDecimal> fundBalance2 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance2.add(new BigDecimal(list.get(i).getCurrentBalance().get(2)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation2 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation2.add(new BigDecimal(list.get(i).getObligation().get(2)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage2 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage2.add(new BigDecimal(list.get(i).getShortage().get(2)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement2 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement2.add(new BigDecimal(list.get(i).getSettlementCost().get(2)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance2", fundBalance2);
		request.setAttribute("fundObligation2", fundObligation2);
		
		request.setAttribute("fundShortage2", fundShortage2);
		request.setAttribute("fundSettlement2", fundSettlement2);
		
		List<BigDecimal> fundBalance1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundBalance1.add(new BigDecimal(list.get(i).getCurrentBalance().get(1)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundObligation1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundObligation1.add(new BigDecimal(list.get(i).getObligation().get(1)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundShortage1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundShortage1.add(new BigDecimal(list.get(i).getShortage().get(1)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		List<BigDecimal> fundSettlement1 = new ArrayList<>(); 
		for(int i=0;i<list.size();i++)
		{ 
			fundSettlement1.add(new BigDecimal(list.get(i).getSettlementCost().get(1)).setScale(2, BigDecimal.ROUND_HALF_EVEN));	 
		}
		
		request.setAttribute("fundBalance1", fundBalance1);
		request.setAttribute("fundObligation1", fundObligation1);
		
		request.setAttribute("fundShortage1", fundShortage1);
		request.setAttribute("fundSettlement1", fundSettlement1);
		
		request.setAttribute("reps", list);
		
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminViewObligation.jsp");
		dispatcher.forward(request, response);
			
		
	}

	

}
