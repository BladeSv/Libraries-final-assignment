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
	public static String outReturnBooListkDB() {
		return rs.getString("db.outReturnBookList");
		
	}
	public static String addReturnBookDB() {
		return rs.getString("db.addReturnBook");
		
	}
	public static String outReaderFromBookTransByBookDB() {
		return rs.getString("db.outReaderFromBookTransByBook");
		
	}
	
	public static String deleteFromBookTransByBookDB() {
		return rs.getString("db.deleteFromBookTransByBook");
		
	}
	public static String deleteFromBookBaseByBookDB() {
		return rs.getString("db.deleteFromBookBaseByBook");
		
	}
	public static String deleteFromBookReturnByBookDB() {
		return rs.getString("db.deleteFromBookReturnByBook");
		
	}

public static String deleteFromBookTransByReaderDB() {
	return rs.getString("db.deleteFromBookTransByReader");
	
}
	
public static String deleteFromReaderBaseByReaderDB() {
	return rs.getString("db.deleteFromReaderBaseByReader");
	
}	
	
public static String deleteFromBookReturnByReaderDB() {
	return rs.getString("db.deleteFromBookReturnByReader");
	
}	
	
public static String outDateFromBookTransByReaderDB() {
	return rs.getString("db.outDateFromBookTransByReader");
	
}	
	
public static String outCounBookTransByReaderDB() {
	return rs.getString("db.outCounBookTransByReader");
	
}	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
