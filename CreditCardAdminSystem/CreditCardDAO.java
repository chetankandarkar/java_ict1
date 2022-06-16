package com.cts.creditcard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.cts.creditcard.exception.CreditCardAdminSystemException;
import com.cts.creditcard.util.ApplicationUtil;
import com.cts.creditcard.util.DBConnectionManager;
import com.cts.creditcard.vo.CreditCard;

public class CreditCardDAO {

	private static Connection conn = null;

	public static final String ADD_CUSTOMER = "INSERT INTO T_CREDIT_CARD_ACCOUNT "
			+ " (CREDIT_CARD_NUMBER, CUSTOMER_NAME, CUSTOMER_EMAIL, CUSTOMER_PHONE, BILL_AMOUNT, BILL_DUE_DATE, BILL_PAID_DATE)  "
			+ "VALUES (?,?,?,?,?,?,?)";

	public Boolean addCreditCardDetails(List<CreditCard> cards) throws CreditCardAdminSystemException {
		Boolean status = false;
		try {
 			conn = DBConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			PreparedStatement psAdd = conn.prepareStatement(ADD_CUSTOMER);
			for (CreditCard card : cards) {
				psAdd.setLong(1, card.getCreditCardNum());
				psAdd.setString(2, card.getCustomerName());
				psAdd.setString(3, card.getCustomerEmail());
				psAdd.setLong(4, card.getCustomerPhone());
				psAdd.setDouble(5, card.getBillAmount());
				psAdd.setDate(6, ApplicationUtil.convertUtilToSqlDate(card.getDueDate()));
				psAdd.setDate(7, ApplicationUtil.convertUtilToSqlDate(card.getPaymentDate()));
				psAdd.addBatch();
			}

			int[] rows = psAdd.executeBatch();
			if (rows != null && rows.length > 0) {
				status = true;
			}
			conn.commit();
		} catch (SQLException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					throw new CreditCardAdminSystemException(ex.getMessage(), ex.getCause());
				}
			}
			throw new CreditCardAdminSystemException(ex.getMessage(), ex.getCause());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new CreditCardAdminSystemException(e.getMessage(), e.getCause());
				}
			}
		}

		return status;

	}
}
