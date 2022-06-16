/**
 * 
 */
package com.cts.creditcard.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.cts.creditcard.exception.CreditCardAdminSystemException;

/**
 * @author 222805
 *
 */
public class DBConnectionManager {

	private static DBConnectionManager instance;
	public static final String PROPERTY_FILE = "database.properties";
	public static final String DRIVER = "db.classname";
	public static final String URL = "db.url";
	public static final String USER_NAME = "db.username";
	public static final String PASSWORD = "db.password";

	private static Connection connection = null;
	private static Properties props = null;

	/**
	 * @throws CreditCardAdminSystemException
	 */
	private DBConnectionManager() throws CreditCardAdminSystemException {
		loadProperties();
		try {	 	  	 	      	      	 	      	   	 	
			Class.forName(props.getProperty(DRIVER));
			this.connection = DriverManager.getConnection(props.getProperty(URL), props.getProperty(USER_NAME), 
					props.getProperty(PASSWORD));
		} catch (ClassNotFoundException ex) {
			throw new CreditCardAdminSystemException("Could not find Driver class ", ex.getCause());
		} catch (SQLException e) {
			throw new CreditCardAdminSystemException("Database Connection Creation Failed", e.getCause());
		}
	}

	/**
	 * @return Connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @return DBConnectionManager
	 * @throws CreditCardAdminSystemException
	 */
	public static DBConnectionManager getInstance() throws CreditCardAdminSystemException {
		try {
			if ((instance == null) || (instance.getConnection().isClosed())) {
				instance = new DBConnectionManager();
			}
		} catch (SQLException e) {
			throw new CreditCardAdminSystemException("Database Connection Creation Failed", e.getCause());
		}

		return instance;
	}

	/**
	 * @throws CreditCardAdminSystemException
	 */
	private void loadProperties() throws CreditCardAdminSystemException {	 	  	 	      	      	 	      	   	 	
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(PROPERTY_FILE);
			props = new Properties();
			props.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new CreditCardAdminSystemException("Database Property File Not Found", e.getCause());
		} catch (IOException e) {
			throw new CreditCardAdminSystemException("Exception during property file I/O", e.getCause());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new CreditCardAdminSystemException("Exception during property file I/O", e.getCause());
				}
			}
		}
	}
}
