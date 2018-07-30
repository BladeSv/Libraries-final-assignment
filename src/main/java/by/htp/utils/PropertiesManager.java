package by.htp.utils;

import java.util.ResourceBundle;

public class PropertiesManager {

	public static final ResourceBundle rs;
	static{
		rs=ResourceBundle.getBundle("config");
		
	}
	public static String getStatus() {
		return rs.getString("status");
		
	}
public static String getUrl() {
		
		return rs.getString("db.url");
		
	}
	public static String getLogin() {
		
		return rs.getString("db.login");
		
		
	}
	public static String getPass() {
		
		return rs.getString("db.pass");
}
}