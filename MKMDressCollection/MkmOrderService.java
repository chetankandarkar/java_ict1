package com.cts.mkm.service;

import java.util.ArrayList;
import java.util.List;

import com.cts.mkm.exception.MkmOrderException;
import com.cts.mkm.vo.MkmOrder;

public class MkmOrderService {
	
	public static List<MkmOrder> buildMkmOrdersList(List<String> MkmOrderRecords) {
		List<MkmOrder> MkmOrderList = new ArrayList<MkmOrder>();
		// Fill the code
		
		return MkmOrderList;
	}


	public boolean addMkmOrderDetails(String inputFeed) throws MkmOrderException {
		// Fill the code
		
		return false;
	}

	public static double[] calculateTotalDressCost(int noOfDresses, String location, String dressQuality) {
		double[] MkmOrderCosts = new double[4];
		
		// Fill the code
	
		return MkmOrderCosts;
	}

	public boolean searchMkmOrder(String orderId) throws MkmOrderException {
		boolean status = false;
		
		// Fill the code
		return status;
	}
}
