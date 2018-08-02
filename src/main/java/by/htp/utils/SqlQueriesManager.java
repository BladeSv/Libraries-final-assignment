package by.htp.utils;

import java.util.ResourceBundle;

public class SqlQueriesManager {
	
	public static final ResourceBundle rs;
	static{
		rs=ResourceBundle.getBundle("SqlQueries");
		
	}
	public static String addBookDB() {
		return rs.getString("db.addBook");
		
	}
	public static String addReaderDB() {
		return rs.getString("db.addReader");
		
	}
	public static String takeBookDB() {
		return rs.getString("db.takeBook");
		
	}
	public static String outBookListDB() {
		return rs.getString("db.outBookList");
		
	}
	
	public static String outReaderListDB() {
		return rs.getString("db.outReaderList");
		
	}
	public static String outTransListDB() {
		return rs.getString("db.outTransList");
		
	}
	public static String addReturnBookDB() {
		return rs.getString("db.addReturnBook");
		
	}
	
	
	public static String addTransactionDB() {
		return rs.getString("db.addTransaction");
		
	}
	
}
