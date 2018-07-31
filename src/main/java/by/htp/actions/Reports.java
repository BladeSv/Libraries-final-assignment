package by.htp.actions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import by.htp.DAO.DAO;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;

public class Reports {

	private static DAO dao=Run.getDao();
	public static void debtReport() {
		System.out.println("Report on readers who are in arrears");
		SimpleDateFormat sf=new SimpleDateFormat("dd.MM.yyyy");
		
		boolean check=true;
	
		List<BookTransaction> btList =new ArrayList<>();
		dao.bookTransactionList().forEach((k,l)->btList.add(l) );
		for(BookTransaction bt: btList ) {
			
			
			long difference =Run.getSessionDate().getTimeInMillis()-bt.getDate().getTimeInMillis();		
			int days = (int) difference / (24 * 60 * 60 * 1000);
			if(days>30) {
				System.out.println("Reader: "+bt.getReader().getSurname()+" "+bt.getReader().getName() +" "+bt.getReader().getSecondName() + ", phone number: "+ 
	bt.getReader().getPhoneNumber() + ", book title: "+bt.getBook().getTitle()+", date of issue: " +sf.format(bt.getDate().getTime())+ ", number of days overdue: "+
						(days-30));
			
				check=false;
			}
			
		}
		if(check) {
			
			System.out.println("There are no debtors");
		}
	}
	
public static void  booksReadReport() {
	System.out.println("Report on the books read:");
	TreeMap<Integer, Book> SortBook= new TreeMap<>();
	
	for(Book book: dao.outBookList()) {
		if(book.getNumberOutput()!=0) {
			
			SortBook.put(book.getNumberOutput(), book);
		}
	}
	
	SortBook.forEach((k,l)->System.out.println("Book title: "+l.getTitle()+", number of times it was read: "+k));
}
	
public static void employeesReport() {
		System.out.println("Report on employees who read at least 2 and not more than 8 books per month:");
		boolean check=true;
	for(Reader reader: dao.outReaderList()) {
		int count=0;
		if(!reader.getReturnBooke().isEmpty()) {
			
			Set<BookTransaction> keyBook= reader.getReturnBooke().keySet();
			for(BookTransaction bookT:keyBook) {
				GregorianCalendar returnDate=reader.getReturnBooke().get(bookT);
				
				
				long difference =Run.getSessionDate().getTimeInMillis()-returnDate.getTimeInMillis();						
				int days = (int) difference / (24 * 60 * 60 * 1000);
				if(days>=30) {
					count++;
					
				}
				
			}
			if((count>=2) && (count<=8)) {
				System.out.println("Reader: "+reader.getSurname()+" "+reader.getName()+" "+reader.getSecondName());
				check=false;
			}
		}
		
		
	}
	if(check){
		System.out.println("No one has read at least 2 or more than 8 books in 30 days.:");	
		
	}
	
}  
	
}
