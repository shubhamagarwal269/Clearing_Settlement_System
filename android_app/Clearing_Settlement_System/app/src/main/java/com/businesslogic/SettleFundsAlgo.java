package com.businesslogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.ObligationReport;
import com.pojo.Trade;

public class SettleFundsAlgo {

	// Number of persons (or vertices in the graph)
	static double roundToDecimalPlaces(double p,int decimal_places){
		double shift=Math.pow(10, decimal_places);
		
		return (double) (Math.round(p*shift)/shift);
	}
		
		CommonFunctionalities commFunc=new CommonFunctionalitiesImpl();
		int totalMembers=commFunc.getNextMemberId();
		
		// A utility function that returns index of minimum value in arr[]
		int getMin(double arr[])
		{
			int minInd = 0;
			for (int i = 1; i < totalMembers; i++)
				if (arr[i] < arr[minInd])
					minInd = i;
			return minInd;
		}
		
		// A utility function that returns index of maximum value in arr[]
		int getMax(double arr[])
		{
			int maxInd = 0;
			for (int i = 1; i < totalMembers; i++)
				if (arr[i] > arr[maxInd])
					maxInd = i;
			return maxInd;
		}
		
		// A utility function to return minimum of 2 values
		double minOf2(double x, double y)
		{
			return (x < y) ? x: y;
		}
		
		// amount[p] indicates the net amount to be credited/debited to/from person 'p'
		// If amount[p] is positive, then i'th person will amount[i]
		// If amount[p] is negative, then i'th person will give -amount[i]
		private double[][] after_net_graph=new double[totalMembers][totalMembers];//to get values after first funds netting
		
		void minCashFlowRecSecurityWise(double amount[])
		{
			// Find the indexes of minimum and maximum values in amount[] amount[mxCredit] indicates the maximum amount to be given (or credited) to any person .
			// And amount[mxDebit] indicates the maximum amount to be taken(or debited) from any person. So if there is a positive value in amount[], then there must be a negative value
			int mxCredit = getMax(amount), mxDebit = getMin(amount);
		
			// If both amounts are 0, then all amounts are settled
			if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
				return;
		
			// Find the minimum of two amounts
			double min = minOf2(-amount[mxDebit], amount[mxCredit]);
			amount[mxCredit] -= min;
			amount[mxDebit] += min;
		
			// If minimum is the maximum amount to be
			System.out.println("Person " + mxDebit + " pays " + min
									+ " to " + "Person " + mxCredit);
			after_net_graph[mxDebit][mxCredit]+=min;
			// Recur for the amount array. Note that it is guaranteed that the recursion would terminate as either amount[mxCredit] or amount[mxDebit] becomes 0
			minCashFlowRecSecurityWise(amount);
		}
		
		void minCashFlowRecFundsWise(double amount[], List<ObligationReport> obligationReport,int batchNum)
		{
			// Find the indexes of minimum and maximum values in amount[] amount[mxCredit] indicates the maximum amount to be given (or credited) to any person .
			// And amount[mxDebit] indicates the maximum amount to be taken(or debited) from any person. So if there is a positive value in amount[], then there must be a negative value
			int mxCredit = getMax(amount), mxDebit = getMin(amount);
			System.out.println("mxCredit "+ mxCredit);
			System.out.println("mxDebit "+ mxDebit);
			// If both amounts are 0, then all amounts are settled
			if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
				return;
		
			// Find the minimum of two amounts
			double min = minOf2(-amount[mxDebit], amount[mxCredit]);
			amount[mxCredit] -= min;
			amount[mxDebit] += min;
		
			//Adding debiter to list
			ObligationReport obReport=new ObligationReport();
			obReport.setMemberId(mxDebit);
			obReport.setFundAmt((min*-1));
			obReport.setBatchNum(batchNum);
			obligationReport.add(obReport);
			
			//Adding crediter to list
			ObligationReport obReport1=new ObligationReport();
			obReport1.setMemberId(mxCredit);
			obReport1.setFundAmt(min);
			obReport1.setBatchNum(batchNum);
			obligationReport.add(obReport1);
			
			// If minimum is the maximum amount to be
			System.out.println("Person " + (mxDebit) + " pays " + min
									+ " to " + "Person " + (mxCredit));
			after_net_graph[mxDebit][mxCredit]+=min;
			// Recur for the amount array. Note that it is guaranteed that the recursion would terminate as either amount[mxCredit] or amount[mxDebit] becomes 0
			minCashFlowRecFundsWise(amount, obligationReport,batchNum);
		}
		
		
		// Given a set of persons as graph[] where graph[i][j] indicates the amount that person i needs to pay person j, this function
		// finds and prints the minimum  cash flow to settle all debts.
		void minCashFlowSecuritywise(double graph[][])
		{
			// Create an array amount[], initialize all value in it as 0.
			double amount[]=new double[totalMembers];
		
			// Calculate the net amount to be paid to person 'p', and stores it in amount[p]. The value of amount[p] can be calculated by subtracting debts of 'p' from credits of 'p'
			for (int p = 0; p < totalMembers; p++)
			for (int i = 0; i < totalMembers; i++)
				amount[p] += (graph[i][p] - graph[p][i]);
		
			minCashFlowRecSecurityWise(amount);
		}
		
		
		void minCashFlowFundsWise(double graph[][], List<ObligationReport> obligationReport,int batchNum)
		{
			// Create an array amount[], initialize all value in it as 0.
			double amount[]=new double[totalMembers];
		
			// Calculate the net amount to be paid to person 'p', and stores it in amount[p]. The value of amount[p] can be calculated by subtracting debts of 'p' from credits of 'p'
			for (int p = 0; p < totalMembers; p++)
			for (int i = 0; i < totalMembers; i++)
				amount[p] += (graph[i][p] - graph[p][i]);
		
			minCashFlowRecFundsWise(amount, obligationReport,batchNum);
		}
		
		void display() {
			System.out.println("displaying after fund netting graph");
			for(int i=0;i<totalMembers;i++) {
				for(int j=0;j<totalMembers;j++)
					System.out.print(after_net_graph[i][j]+"\t");
				System.out.println();
			}
		}
		
		
		
		
		public List<ObligationReport> settleFunds (List <Trade> tradeList) {
			// TODO Auto-generated method stub

//			List<ObligationReport> obligationReport =new ArrayList<>();
//			SettleSecuritiesAlgo settleSecAlgo = new SettleSecuritiesAlgo();
			
			
			CommonFunctionalities commFunc=new CommonFunctionalitiesImpl();
			int totalMembers=commFunc.getNextMemberId();
			int row=0, coln=0;
			 
			// graph[i][j] indicates the amount that person i needs to pay person j
			double[][] graph=new double[totalMembers][totalMembers];
			
			
			int totalSecurities=commFunc.viewAllSecurities().size();
			System.out.println("TL "+ tradeList);
			int batchNum=tradeList.get(0).getBatchNum();
			for(int sec=0;sec<totalSecurities;sec++) { 
				row=0;
				coln=0;
				
				for(int x=0;x<tradeList.size();x++) {
					if(tradeList.get(x).getISIN()==sec) { // check string conversion into int
						coln=tradeList.get(x).getSellerMemberId();
						row=tradeList.get(x).getBuyerMemberId();
						double temp=(tradeList.get(x).getQuantity()) * tradeList.get(x).getPrice();
					//	temp=roundToDecimalPlaces(temp, 2);
						graph[row][coln]+=temp;
					}
				}
				System.out.println("array before netting of sec "+sec);
				for(int i=0;i<totalMembers;i++) {
					for(int j=0;j<totalMembers;j++)
						System.out.print(graph[i][j]+"\t");
					System.out.println();
				}
				System.out.println("\n After netting for sec"+sec);
				
				minCashFlowSecuritywise(graph);
				//make every element of graph 0
				for(int i=0;i<totalMembers;i++) {
					for(int j=0;j<totalMembers;j++)
						graph[i][j]=0;
				}
			}
			
			display();
			List<ObligationReport> obligationReport= new ArrayList<>();
			minCashFlowFundsWise(after_net_graph,obligationReport,batchNum);
//			System.out.println(obligationReport);
			
			List<ObligationReport> finalObligationReport =new ArrayList<>();
			int i=0,j=0,index=0;
			 double sum=0.0d;
					Set<Integer> checkList = new HashSet<Integer>(); 
					while(i<obligationReport.size()) {
							if(!checkList.contains(obligationReport.get(i).getMemberId())) {
								finalObligationReport.add(obligationReport.get(i));
								sum=0;
								sum=obligationReport.get(i).getFundAmt();
								
								j=i+1;
								while(j<obligationReport.size()) {
									ObligationReport o1=obligationReport.get(i);
									ObligationReport o2=obligationReport.get(j);
									if(o1.getMemberId()==(o2.getMemberId())) {
										double valuToAdd=obligationReport.get(j).getFundAmt();
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
								finalObligationReport.get(index).setFundAmt(sum);
							}
						i++;
					}
					 
				
				//finalObligationReport.sort(Comparator.comparing(ObligationReport::getMemberId));
				System.out.println(finalObligationReport);
				return finalObligationReport;
		}

		
		
}
