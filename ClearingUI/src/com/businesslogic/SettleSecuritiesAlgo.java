package com.businesslogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.ObligationReport;
import com.pojo.Trade;

public class SettleSecuritiesAlgo {

	// Java program to fin maximum cash 
	// flow among a set of persons

	
		// totalMembersumber of persons (or vertices in the graph)
		CommonFunctionalities commFunc=new CommonFunctionalitiesImpl();
		int totalMembers=commFunc.getNextMemberId();
		
		// A utility function that returns index of minimum value in arr[]
		 int getMin(int arr[])
		{
			int minInd = 0;
			for (int i = 1; i < totalMembers; i++)
				if (arr[i] < arr[minInd])
					minInd = i;
			return minInd;
		}
		
		// A utility function that returns index of maximum value in arr[]
		int getMax(int arr[])
		{
			int maxInd = 0;
			for (int i = 1; i < totalMembers; i++)
				if (arr[i] > arr[maxInd])
					maxInd = i;
			return maxInd;
		}
		
		// A utility function to return minimum of 2 values
		 int minOf2(int x, int y)
		{
			return (x < y) ? x: y;
		}
		
		// amount[p] indicates the net amount to be credited/debited to/from person 'p'
		// If amount[p] is positive, then i'th person will amount[i]
		// If amount[p] is negative, then i'th person will give -amount[i]
		void minCashFlowRec(int amount[], List<ObligationReport> obligationReport , int sec)
		{
			// Find the indexes of minimum and maximum values in amount[] amount[mxCredit] indicates the maximum amount to be given (or credited) to any person .
			// And amount[mxDebit] indicates the maximum amount to be taken(or debited) from any person. So if there is a positive value in amount[], then there must be a negative value
			int mxCredit = getMax(amount), mxDebit = getMin(amount);
		
			// If both amounts are 0, then all amounts are settled
			if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
				return;
		
			// Find the minimum of two amounts
			int min = minOf2(-amount[mxDebit], amount[mxCredit]);
			amount[mxCredit] -= min;
			amount[mxDebit] += min;

			//Adding debiter to list
			ObligationReport obReport=new ObligationReport();
			obReport.setMemberId(mxDebit);
			obReport.setQuantity((min*-1));
			obReport.setISIN(sec);
			obligationReport.add(obReport);
			
			//Adding crediter to list
			ObligationReport obReport1=new ObligationReport();
			obReport1.setMemberId(mxCredit);
			obReport1.setISIN(sec);
			obReport1.setQuantity(min);
			obligationReport.add(obReport1);
			
			// If minimum is the maximum amount to be
			System.out.println("Person " + (mxDebit) + " pays " + min
									+ " to " + "Person " + (mxCredit));
		
			// Recur for the amount array. totalMembersote that it is guaranteed that the recursion would terminate as either amount[mxCredit] or amount[mxDebit] becomes 0
			minCashFlowRec(amount,obligationReport,sec);
		}
		
		// Given a set of persons as graph[] where graph[i][j] indicates the amount that person i needs to pay person j, this function
		// finds and prints the minimum  cash flow to settle all debts.
		void minCashFlow(int graph[][],List<ObligationReport> obligationReport, int sec)
		{
			// Create an array amount[], initialize all value in it as 0.
			int amount[]=new int[totalMembers];
		
			// Calculate the net amount to be paid to person 'p', and stores it in amount[p]. The value of amount[p] can be calculated by subtracting debts of 'p' from credits of 'p'
			for (int p = 0; p < totalMembers; p++)
			for (int i = 0; i < totalMembers; i++)
				amount[p] += (graph[i][p] - graph[p][i]);
		
			minCashFlowRec(amount, obligationReport, sec);
		}
	
		public List<ObligationReport> settleSecurities(List <Trade> tradeList) {
			// TODO Auto-generated method stub

			List<ObligationReport> obligationReport =new ArrayList<>();
			SettleSecuritiesAlgo settleSecAlgo = new SettleSecuritiesAlgo();
			
			
			CommonFunctionalities commFunc=new CommonFunctionalitiesImpl();
			int totalMembers=commFunc.getNextMemberId();
			int row=0, coln=0;
			 
			// graph[i][j] indicates the amount that person i needs to pay person j
			int[][] graph=new int[totalMembers][totalMembers];
			
			
			int totalSecurities=commFunc.viewAllSecurities().size();
			for(int sec=0;sec<totalSecurities;sec++) { 
				row=0;
				coln=0;
				for(int x=0;x<tradeList.size();x++) {
					if(tradeList.get(x).getISIN()==sec) { 
						row=tradeList.get(x).getSellerMemberId();
						coln=tradeList.get(x).getBuyerMemberId();
						graph[row][coln]+=tradeList.get(x).getQuantity();
						
					}
				}
				
				settleSecAlgo.minCashFlow(graph,obligationReport,sec);
				//make every element of graph 0
				for(int i=0;i<totalMembers;i++) {
					for(int j=0;j<totalMembers;j++)
						graph[i][j]=0;
				}
			}
			List<ObligationReport> finalObligationReport =new ArrayList<>();
			 
			
			// add up quantity for each member
			 int i=0,j=0,index=0;
			 int sum=0;
			 
			for(int secIterator=0;secIterator<totalSecurities;secIterator++) {
				Set<Integer> checkList = new HashSet<Integer>(); 
				while(i<obligationReport.size() && obligationReport.get(i).getISIN()==secIterator) {
						if(!checkList.contains(obligationReport.get(i).getMemberId())) {
							finalObligationReport.add(obligationReport.get(i));
							sum=0;
							sum=obligationReport.get(i).getQuantity();
							
							j=i+1;
							while(j<obligationReport.size()) {
								ObligationReport o1=obligationReport.get(i);
								ObligationReport o2=obligationReport.get(j);
								if(o1.getMemberId()==(o2.getMemberId()) && o2.getISIN()==(o1.getISIN())) {
									double valuToAdd=obligationReport.get(j).getQuantity();
									sum+=valuToAdd;
								}
								j++;
							}
							checkList.add(obligationReport.get(i).getMemberId());
							if(i>=finalObligationReport.size()) {
								for(int k=0;k<finalObligationReport.size();k++) {
									if(obligationReport.get(i).getMemberId()==(finalObligationReport.get(k).getMemberId())) {
										index=k;
									}
								}
							}
							else {
								index=i;
							}
							finalObligationReport.get(index).setQuantity(sum);
						}
					i++;
				}
				 
				checkList.clear();
			}
			finalObligationReport.sort(Comparator.comparing(ObligationReport::getMemberId));
			System.out.println(finalObligationReport);
			return finalObligationReport;
		}

	
}
