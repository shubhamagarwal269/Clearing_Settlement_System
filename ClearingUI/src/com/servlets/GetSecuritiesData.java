package com.servlets;
//comment1
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.GenerateMemberReport;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.GenerateMemberReportImpl;
import com.google.gson.Gson;
import com.pojo.Member;
import com.pojo.ObligationReport;
import com.pojo.Pair;
import com.pojo.Security;
import com.pojo.Trade;

/**
 * Servlet implementation class AddTrade
 */
@WebServlet("/getsecuritiesdata")
public class GetSecuritiesData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSecuritiesData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		    List dataList = new ArrayList();
		    List<Security> secList = new ArrayList();
		    CommonFunctionalitiesImpl commonFunc=new CommonFunctionalitiesImpl();
		    List<Member> memberList=commonFunc.viewAllMembers();
		    secList=commonFunc.viewAllSecurities();
		    GenerateMemberReport generateMemReport=new GenerateMemberReportImpl();
		    Map memMap=new HashMap<>();
		    Map secMap=new HashMap<>();
		    
		    for(int i=0;i<memberList.size();i++) {
		    	memMap.put(memberList.get(i).getMemberId(), memberList.get(i).getMemberName());
		    }
		    
		    for(int i=0;i<secList.size();i++) {
		    	secMap.put(secList.get(i).getISIN(), secList.get(i).getSecurityName());
		    }
		    
		    int flag=0;
		    for(int i=0;i<memberList.size();i++)
		    {	   
		    	Map map=new HashMap();
			    map.put("CM", memMap.get(memberList.get(i).getMemberId()));
			    map.put("Funds",generateMemReport.viewBankAcBalance(memberList.get(i).getMemberId()));
			   
			    	List<Pair<Integer, Integer>> list=commonFunc.viewDematAcBalanceByMemberId(memberList.get(i).getMemberId());
			    	for(int j=0;j<list.size();j++) {
			    		  map.put(secMap.get(list.get(j).getFirst()),list.get(j).getSecond());
//			    		  map.put("label", secList.get(j).getSecurityName());		
//			    		  map.put("value", commonFunc.getSecurityCount(secList.get(j).getISIN()));
			    	}
//			    	if(flag==0) {
//			    		map.put("label", "Citi");
//			    		map.put("value", commonFunc.getSecurityCount(secList.get(0).getISIN()));
//			    		for(int j=0;j<secList.size();j++) {
//				    		  map.put("label", secList.get(j).getSecurityName());
//				    		  System.out.println("label"+secList.get(j).getSecurityName());
//				    		  map.put("value", commonFunc.getSecurityCount(secList.get(j).getISIN()));
//				    		  System.out.println("value"+ commonFunc.getSecurityCount(secList.get(j).getISIN()));
//				    	}
//			    		flag=1;
//			    	}

			    dataList.add(map);
			    System.out.println(dataList);
			    System.out.println("dataList:-"+dataList.size());
		    }	    
		    String json = new Gson().toJson(dataList);
		   
		    write(response,json);
	}



	private void write(HttpServletResponse response, String output) throws IOException {
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(output); //this is how simple GSON works
		}
			
	}

