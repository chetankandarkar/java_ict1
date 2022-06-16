package com.cts.creditcard.main;

import com.cts.creditcard.exception.CreditCardAdminSystemException;
import com.cts.creditcard.service.CreditCardAdminService;

public class MainApp {
public static void main(String ag[]) {
	CreditCardAdminService service = new CreditCardAdminService();
	try {
		service.addCreditCardDetails("inputFeed.txt");
	} catch (CreditCardAdminSystemException e) {
		e.printStackTrace();
	}
}
}
