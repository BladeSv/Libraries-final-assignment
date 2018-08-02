package by.htp.utils;

import java.util.ResourceBundle;

public class SqlQueriesManager {
	
	public static final ResourceBundle rs;
	static{
		rs=ResourceBundle.getBundle("SqlQueries");
		
	}
	public static String addBook() {
		return rs.getString("db.addBook");
		
	}

}

