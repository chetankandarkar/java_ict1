package com.cts.mkm.dao;

import java.util.ArrayList;
import java.util.List;

import com.cts.mkm.exception.MkmOrderException;
import com.cts.mkm.vo.MkmOrder;

public class MkmOrderDAO {

	public boolean addMkmOrderDetails(List<MkmOrder> prdOrders) throws MkmOrderException {
		boolean recordsAdded = false;
		// Fill the code

		return recordsAdded; 
	}

	public List<MkmOrder> getAllMkmOrderDetails() throws MkmOrderException {
		
		List<MkmOrder> prdOrders = new ArrayList<MkmOrder>();
         // Fill the code
		
		return prdOrders;

	}
}