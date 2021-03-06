package com.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.businesslogic.SettleSecuritiesAlgo;
import com.pojo.ObligationReport;
import com.pojo.Trade;

class SettleSecuritiesAlgoTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSettleSecurities() {
		List<Trade> tradeList = new ArrayList<>();
		tradeList.add(new Trade(1, 1, 25000, 100f, 1, 0, 1));
		tradeList.add(new Trade(2, 2, 3000, 45f, 1, 3, 1));
		tradeList.add(new Trade(3, 1, 12000, 101f, 2, 1, 1));
		tradeList.add(new Trade(4, 2, 1000, 44f, 3, 0, 1));
		tradeList.add(new Trade(5, 1, 5000, 102f, 3, 2, 1));
		tradeList.add(new Trade(6, 4, 2000, 155f, 3, 0, 1));
		tradeList.add(new Trade(7, 0, 1500, 77f, 0, 2, 1));
		tradeList.add(new Trade(8, 4, 800, 155f, 0, 1, 1));
		tradeList.add(new Trade(9, 3, 2250, 47f, 2, 0, 1));
		tradeList.add(new Trade(10, 3, 250, 46f, 2, 1, 1));
		
		SettleSecuritiesAlgo algo = new SettleSecuritiesAlgo();
		List<ObligationReport> obgList_actual=algo.settleSecurities(tradeList);
		
		List<ObligationReport> obgList_expected = new ArrayList<>();
		obgList_expected.add(new ObligationReport(0, -1, 0, 1500, 0.0)); 
		obgList_expected.add(new ObligationReport(0, -1, 1, -25000, 0.0));
		obgList_expected.add(new ObligationReport(0, -1, 2, -1000, 0.0));
		obgList_expected.add(new ObligationReport(0, -1, 3, -2250, 0.0)); 
		obgList_expected.add(new ObligationReport(0, -1, 4, -1200, 0.0));
		obgList_expected.add(new ObligationReport(1, -1, 1, 13000, 0.0)); 
		obgList_expected.add(new ObligationReport(1, -1, 2, 3000, 0.0)); 
		obgList_expected.add(new ObligationReport(1, -1, 3, -250, 0.0));
		obgList_expected.add(new ObligationReport(1, -1, 4, -800, 0.0));
		obgList_expected.add(new ObligationReport(2, -1, 0, -1500, 0.0)); 
		obgList_expected.add(new ObligationReport(2, -1, 1, 7000, 0.0)); 
		obgList_expected.add(new ObligationReport(2, -1, 3, 2500, 0.0)); 
		obgList_expected.add(new ObligationReport(3, -1, 1, 5000, 0.0)); 
		obgList_expected.add(new ObligationReport(3, -1, 2, -2000, 0.0));
		obgList_expected.add(new ObligationReport(3, -1, 4, 2000, 0.0));
		
		assertNotNull(obgList_actual);
		assertEquals(obgList_expected.size(), obgList_actual.size(), "size equal");
		for(int i=0;i<obgList_actual.size();i++)
		{
			assertEquals(obgList_expected.get(i).getMemberId(), obgList_actual.get(i).getMemberId());
			assertEquals(obgList_expected.get(i).getQuantity(), obgList_actual.get(i).getQuantity());
		}
	}

}
