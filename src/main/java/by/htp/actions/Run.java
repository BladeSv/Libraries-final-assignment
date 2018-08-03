package by.htp.actions;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;



import by.htp.DAO.DAO;

import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;

import by.htp.utils.Scan;

public class Run {


	private static	GregorianCalendar sessionDate=getRealTime();
private static GregorianCalendar getRealTime(){
		GregorianCalendar readDate= new GregorianCalendar();
		readDate.set(GregorianCalendar.HOUR, 0);
		readDate.set(GregorianCalendar.SECOND, 0);
		readDate.set(GregorianCalendar.MILLISECOND, 0);
		return readDate;
	}
	
	public static GregorianCalendar getSessionDate() {
		return sessionDate;
	}

	public static void setSessionDate(GregorianCalendar sessionDate) {
		Run.sessionDate = sessionDate;
	}
private	static DAO dao =CreateDao.creatDao();
	
	public static DAO getDao() {
	return dao;
}

public static void setDao(DAO dao) {
	Run.dao = dao;
}




public static void addBook(Book book) {
	dao.addBook(book);
}
public static void addReader(Reader reader) {
	dao.addReader(reader);
}

 





public static boolean takeBook() {
	Reader reader=ReaderActions.getReaderAtIndex();
	if(reader==null) {
		return false;
	}
	Book book =BookActions.getBookAtID();
	if(book==null) {
		return false;
		
	}
	
	if(dao.checkBookAvailability(book)) {
		System.out.println("This book has already been taken by another reader");
		return false;
	}
		if(dao.checkBookHand(reader)) {
			System.out.println("This reader has 3 books on his hands");
			return false;	
			
		}
		
	
if(dao.checkDebtReader(reader)) {
	System.out.println("The reader can not take this book from him by the delay in returning the book to 30 days");
	return false;
}
book.setNumberOutput((book.getNumberOutput()+1));
	dao.takeBook(reader, book, Run.getSessionDate());
	return true;
	
}

public static boolean returnBook() {
	Reader reader =ReaderActions.getReaderAtIndex();
	if(reader.getTakenBooks().isEmpty()) {
		System.out.println("This reader dont take book");
		return false;		
	}
	SimpleDateFormat sf =new SimpleDateFormat("dd.MM.yyyy"); 
	System.out.println("List taken book by this reader:");
	for(BookTransaction bt: reader.getTakenBooks()) {
		System.out.println(bt.getBook().toStringSneaky()+"book taken "+sf.format(bt.getDate().getTime()));
	}
	System.out.println("What book do you want to return?");
	Book book=BookActions.getBookAtID();
	if(book==null) {
		return false;	
	}
	for(BookTransaction bt: reader.getTakenBooks()) {
		if(bt.getBook().equals(book)) {
			GregorianCalendar gc =Scan.enterDate();
			dao.returnBook(book, gc);
			return true;
		}
		
	}
	System.out.println("This reader dont take book with this Id");
	return false;
	
}

public static boolean insertBookTransaction() {
	Reader reader=ReaderActions.getReaderAtIndex();
	if(reader==null) {
		return false;
	}
	Book book =BookActions.getBookAtID();
	if(book==null) {
		return false;
		
	}
	if(dao.checkBookAvailability(book)) {
		System.out.println("This book has already been taken by another reader");
		return false;
	}
		
GregorianCalendar tempDate=Scan.enterDate();
book.setNumberOutput((book.getNumberOutput()+1));
	dao.takeBook(reader, book, tempDate);
	return true;
	
}





}
