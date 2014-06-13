package com.floreantpos.config;

import java.io.File;
import java.util.prefs.Preferences;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.floreantpos.main.Application;

public class AppConfig {
	private static final String TERMINAL_ID = "terminal_id"; //$NON-NLS-1$
	public static final String DATABASE_URL = "database_url"; //$NON-NLS-1$
	public static final String DATABASE_PORT = "database_port"; //$NON-NLS-1$
	public static final String DATABASE_NAME = "database_name"; //$NON-NLS-1$
	public static final String DATABASE_USER = "database_user"; //$NON-NLS-1$
	public static final String DATABASE_PASSWORD = "database_pass"; //$NON-NLS-1$
	public static final String CONNECTION_STRING = "connection_string"; //$NON-NLS-1$
	public static final String HIBERNATE_DIALECT = "hibernate.dialect"; //$NON-NLS-1$
	public static final String HIBERNATE_CONNECTION_DRIVER_CLASS = "hibernate.connection.driver_class"; //$NON-NLS-1$
	public static final String DATABASE_PROVIDER_NAME = "database_provider_name"; //$NON-NLS-1$
	
	private static final String KITCHEN_PRINT_ON_ORDER_SETTLE = "kitchen_print_on_order_settle"; //$NON-NLS-1$
	private static final String KITCHEN_PRINT_ON_ORDER_FINISH = "kitchen_print_on_order_finish"; //$NON-NLS-1$
	private static final String PRINT_RECEIPT_ON_ORDER_SETTLE = "print_receipt_on_order_settle"; //$NON-NLS-1$
	private static final String PRINT_RECEIPT_ON_ORDER_FINISH = "print_receipt_on_order_finish"; //$NON-NLS-1$
	
	private final static Preferences pref = Preferences.userNodeForPackage(Application.class);
	
	private static PropertiesConfiguration config;
	
	private static PropertiesConfiguration configuration;
	
	static {
		try {
			configuration = new PropertiesConfiguration(AppConfig.class.getResource("/floreantpos.properties")); //$NON-NLS-1$
			
			File workingDir = Application.getWorkingDir();
			File configFile = new File(workingDir, "floreantpos.config.properties"); //$NON-NLS-1$
			if(!configFile.exists()) {
				configFile.createNewFile();
			}
			
			config = new PropertiesConfiguration(configFile);
			config.setAutoSave(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getTerminalId() {
		return config.getInt(TERMINAL_ID, -1);
	}
	
	public static void setTerminalId(int id) {
		config.setProperty(TERMINAL_ID, id);
	}

	public static Preferences getPreferences() {
		return pref;
	}
	
	public static boolean getBoolean(String key, boolean defaultValue) {
		return config.getBoolean(key, defaultValue);
	}
	
	public static String getString(String key) {
		return config.getString(key, null);
	}
	
	public static String getString(String key, String defaultValue) {
		return config.getString(key, defaultValue);
	}
	
	public static void put(String key, boolean value) {
		config.setProperty(key, value);
	}
	
	public static void put(String key, String value) {
		config.setProperty(key, value);
	}
	
	public static String getDatabaseURL() {
		return config.getString(DATABASE_URL, "localhost"); //$NON-NLS-1$
	}

	public static String getConnectString() {
		return config.getString(CONNECTION_STRING, "");  //$NON-NLS-1$
	}
	
	public static void setConnectString(String connectionString) {
		config.setProperty(CONNECTION_STRING, connectionString);
	}
	
	public static void setDatabaseURL(String url) {
		config.setProperty(DATABASE_URL, url);
	}
	
	public static String getDatabasePort() {
		return config.getString(DATABASE_PORT, null);
	}
	
	public static void setDatabasePort(String port) {
		config.setProperty(DATABASE_PORT, port);
	}
	
	public static String getDatabaseName() {
		return config.getString(DATABASE_NAME, "posdb"); //$NON-NLS-1$
	}
	
	public static void setDatabaseName(String name) {
		config.setProperty(DATABASE_NAME, name);
	}
	
	public static String getDatabaseUser() {
		return config.getString(DATABASE_USER, "app"); //$NON-NLS-1$
	}
	
	public static void setDatabaseUser(String user) {
		config.setProperty(DATABASE_USER, user);
	}
	
	public static String getDatabasePassword() {
		return config.getString(DATABASE_PASSWORD, "sa"); //$NON-NLS-1$
	}
	
	public static void setDatabasePassword(String password) {
		config.setProperty(DATABASE_PASSWORD, password);
	}
	
	public static void setHibernateDialect(String dialect) {
		config.setProperty(HIBERNATE_DIALECT, dialect);
	}
	
	public static String getHibernateDialect() {
		return config.getString(HIBERNATE_DIALECT, ""); //$NON-NLS-1$
	}
	
	public static void setHibernateConnectionDriverClass(String driverClass) {
		config.setProperty(HIBERNATE_CONNECTION_DRIVER_CLASS, driverClass);
	}
	
	public static String getHibernateConnectionDriverClass() {
		return config.getString(HIBERNATE_CONNECTION_DRIVER_CLASS, ""); //$NON-NLS-1$
	}
	
	public static void setDatabaseProviderName(String databaseProviderName) {
		config.setProperty(DATABASE_PROVIDER_NAME, databaseProviderName);
	}
	
	public static String getDatabaseProviderName() {
		return config.getString(DATABASE_PROVIDER_NAME, ""); //$NON-NLS-1$
	}
	
	public static boolean isPrintReceiptOnOrderFinish() {
		return getBoolean(PRINT_RECEIPT_ON_ORDER_FINISH, false);
	}
	
	public static void setPrintReceiptOnOrderFinish(boolean print) {
		config.setProperty(PRINT_RECEIPT_ON_ORDER_FINISH, print);
	}
	
	public static boolean isPrintReceiptOnOrderSettle() {
		return getBoolean(PRINT_RECEIPT_ON_ORDER_SETTLE, false);
	}
	
	public static void setPrintReceiptOnOrderSettle(boolean print) {
		config.setProperty(PRINT_RECEIPT_ON_ORDER_SETTLE, print);
	}
	
	public static boolean isPrintToKitchenOnOrderFinish() {
		return getBoolean(KITCHEN_PRINT_ON_ORDER_FINISH, false);
	}
	
	public static void setPrintToKitchenOnOrderFinish(boolean print) {
		config.setProperty(KITCHEN_PRINT_ON_ORDER_FINISH, print);
	}
	
	public static boolean isPrintToKitchenOnOrderSettle() {
		return getBoolean(KITCHEN_PRINT_ON_ORDER_SETTLE, false);
	}
	
	public static void setPrintToKitchenOnOrderSettle(boolean print) {
		config.setProperty(KITCHEN_PRINT_ON_ORDER_SETTLE, print);
	}
	
	public static PropertiesConfiguration getConfiguration() {
		return configuration;
	}
}
