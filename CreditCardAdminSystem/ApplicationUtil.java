package com.cts.creditcard.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cts.creditcard.exception.CreditCardAdminSystemException;

public class ApplicationUtil {

	/**
	 * @param fileName
	 * @return List<String>
	 * @throws CreditCardAdminSystemException 
	 */
	public static List<String> readFile(String fileName) throws CreditCardAdminSystemException {
		List<String> lines = new ArrayList<String>();
		if (fileName != null) {
			try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

				lines = stream.filter(line -> line.startsWith("5")).map(String::toUpperCase)
						.collect(Collectors.toList());

			} catch (IOException pe) {
				throw new CreditCardAdminSystemException(pe.getMessage(), pe.getCause());
			}
		}

		return lines;
	}
	
	public static Date geDateWithoutTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		date = calendar.getTime();
		return date;
	}

	/**
	 * @param util
	 *            Date
	 * @return sql Date
	 */
	public static java.sql.Date convertUtilToSqlDate(java.util.Date uDate) {
		java.sql.Date sDate = null;
		if (uDate != null) {
			sDate = new java.sql.Date(uDate.getTime());
		}
		return sDate;
	}

	/**
	 * @param inDate
	 * @return Date
	 */
	public static Date convertStringToDate(String inDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		try {
			return dateFormat.parse(inDate);
		} catch (ParseException pe) {
			return null;
		}
	}
	
	
}
