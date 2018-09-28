package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.dao_impl.AdminDashboardImpl;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.ObligationReport;
import com.pojo.Trade;

class AdminDashboardImplTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testApplyNetting() {
		List<Trade> tradeList = new ArrayList<>();
		tradeList.add(new Trade(1, 1, 25000, 100f, 1, 0, -1));
		tradeList.add(new Trade(2, 2, 3000, 45f, 1, 3, -1));
		tradeList.add(new Trade(3, 1, 12000, 101f, 2, 1, -1));
		tradeList.add(new Trade(4, 2, 1000, 44f, 3, 0, -1));
		tradeList.add(new Trade(5, 1, 5000, 102f, 3, 2, -1));
		tradeList.add(new Trade(6, 4, 2000, 155f, 3, 0, -1));
		tradeList.add(new Trade(7, 0, 1500, 77f, 0, 2, -1));
		tradeList.add(new Trade(8, 4, 800, 155f, 0, 1, -1));
		tradeList.add(new Trade(9, 3, 2250, 47f, 2, 0, -1));
		tradeList.add(new Trade(10, 3, 250, 46f, 2, 1, -1));
		
		AdminDashboard dao = new AdminDashboardImpl();
		int ret = dao.applyNetting(tradeList);
		
		assertEquals(0, ret);
		
		CommonFunctionalities dao2 = new CommonFunctionalitiesImpl();
		List<ObligationReport> obgList_actual = dao2.viewAllObgReports();
		
		List<ObligationReport> obgList_expected = new ArrayList<>();
		obgList_expected.add(new ObligationReport(0, -1, 0, 1500, 2720250.0)); 
		obgList_expected.add(new ObligationReport(0, -1, 1, -25000, 2720250.0));
		obgList_expected.add(new ObligationReport(0, -1, 2, -1000, 2720250.0));
		obgList_expected.add(new ObligationReport(0, -1, 3, -2250, 2720250.0)); 
		obgList_expected.add(new ObligationReport(0, -1, 4, -1200, 2720250.0));
		obgList_expected.add(new ObligationReport(1, -1, 1, 13000, -1287500.0)); 
		obgList_expected.add(new ObligationReport(1, -1, 2, 3000, -1287500.0)); 
		obgList_expected.add(new ObligationReport(1, -1, 3, -250, -1287500.0));
		obgList_expected.add(new ObligationReport(1, -1, 4, -800, -1287500.0));
		obgList_expected.add(new ObligationReport(2, -1, 0, -1500, -703750.0)); 
		obgList_expected.add(new ObligationReport(2, -1, 1, 7000, -703750.0)); 
		obgList_expected.add(new ObligationReport(2, -1, 3, 2500, -703750.0)); 
		obgList_expected.add(new ObligationReport(3, -1, 1, 5000, -729000.0)); 
		obgList_expected.add(new ObligationReport(3, -1, 2, -2000, -729000.0));
		obgList_expected.add(new ObligationReport(3, -1, 4, 2000, -729000.0));
		
		assertNotNull(obgList_actual);
		assertEquals(obgList_expected.size(), obgList_actual.size());
		for(int i=0;i<obgList_actual.size();i++)
		{
			assertEquals(obgList_expected.get(i).getMemberId(), obgList_actual.get(i).getMemberId());
			assertEquals(obgList_expected.get(i).getBatchNum(), obgList_actual.get(i).getBatchNum());
			assertEquals(obgList_expected.get(i).getISIN(), obgList_actual.get(i).getISIN());
			assertEquals(obgList_expected.get(i).getQuantity(), obgList_actual.get(i).getQuantity());
			assertEquals(obgList_expected.get(i).getFundAmt(), obgList_actual.get(i).getFundAmt());
		}
		
		
	}

}
