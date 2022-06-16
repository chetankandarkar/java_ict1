package com.cts.creditcard.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cts.creditcard.dao.CreditCardDAO;
import com.cts.creditcard.exception.CreditCardAdminSystemException;
import com.cts.creditcard.util.ApplicationUtil;
import com.cts.creditcard.vo.CreditCard;

/**
 * @author 222805
 *
 */
public class CreditCardAdminService {

	private static final String INPUT_DELIMITER = ",";

	/**
	 * @param records
	 * @return List<Customer>
	 */
	public static List<CreditCard> buildMasterCreditCardList(List<String> records) {
		List<CreditCard> masterCreditCards = new ArrayList<CreditCard>();
		for (String record : records) {
			String[] cardElements = record.split(INPUT_DELIMITER);
			Date dueDate = ApplicationUtil.convertStringToDate(cardElements[5]);
			CreditCard card = new CreditCard();
			card.setCreditCardNum(Long.parseLong(cardElements[0]));
			card.setCustomerName(cardElements[1]);
			card.setCustomerEmail(cardElements[2]);
			card.setCustomerPhone(Long.parseLong(cardElements[3]));
			if (dueDate.before(ApplicationUtil.geDateWithoutTime(new Date()))) {
				card.setBillAmount(getBillAmountWithLatePaymentCharges(Double.parseDouble(cardElements[4])));
			} else {
				card.setBillAmount(Double.parseDouble(cardElements[4]));
			}
			card.setDueDate(dueDate);
			if (cardElements[5] != null) {
				card.setPaymentDate(ApplicationUtil.convertStringToDate(cardElements[5]));
			}  
			
			masterCreditCards.add(card);
		}
		return masterCreditCards;
	}

	public static Double getBillAmountWithLatePaymentCharges(Double billAmount) {
		return billAmount += 500.00;
	}

	public Boolean addCreditCardDetails(String inputFeed) throws CreditCardAdminSystemException {
		CreditCardDAO cardDao = new CreditCardDAO();
		return cardDao.addCreditCardDetails(buildMasterCreditCardList(ApplicationUtil.readFile(inputFeed)));
	}

}
