package com.cts.mkm.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.mkm.exception.MkmOrderException;

public class ApplicationUtil {

	public static List<String> readFile(String fileName) throws MkmOrderException {
		List<String> MkmOrderList = new ArrayList<String>();
		// Fill the code
		
		return MkmOrderList;
	}

	public static java.sql.Date convertUtilToSqlDate(java.util.Date uDate) {
		
		// Fill the code
		return null;
	}

	public static Date convertStringToDate(String inDate) {
		
		// Fill the code
		
		return new Date();
	}

	public static boolean checkIfValidOrder(Date dtOfOrder, Date dtOfDelivery, String manager) {
		boolean orderValidity = false;
		// Fill the code
		
		return orderValidity;
	}
}
