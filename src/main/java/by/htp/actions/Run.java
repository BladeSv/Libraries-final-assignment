package by.htp.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.DAO.DAO;
import by.htp.entities.Autor;
import by.htp.entities.Book;
import by.htp.entities.Reader;
import by.htp.menu.LibrarianMenu;
import by.htp.menu.ReaderMenu;
import by.htp.utils.Scan;

public class Run {

	private static GregorianCalendar sessionDate;
	
	public static GregorianCalendar getSessionDate() {
		return sessionDate;
	}

	public static void setSessionDate(GregorianCalendar sessionDate) {
		Run.sessionDate = sessionDate;
	}
	static DAO dao =CreateDao.creatDao();
	
	public static boolean login() {
		String login;
		String pass;
		
		System.out.println("Enter login");
		login=Scan.getSc().nextLine();
		System.out.println("Enter password");
		pass =Scan.getSc().nextLine();
		Reader reader = findReaderlogin(login, pass);
		if(reader==null) {
			System.out.println("Reader with this login and password dont exist");
			return false;
		}
		if(reader.getStatus().equals("reader")) {
			
			return ReaderMenu.readerMenu();
		}else if (reader.getStatus().equals("librarian")) {
			
			return LibrarianMenu.librarianMenu();
		}
		
		System.out.println("You do not have a library card");
		return false;
	}
	
	public static Reader createReader() {
		Reader reader =new Reader();
		boolean check=false;
		String login;
		do {
		System.out.println("Enter login");
		 login = Scan.getSc().nextLine();
		 
		check=checkLogin(login);
		if(check) {
			System.out.println("This login alredy exist");
		}
			
		}while(check);
		reader.setLogin(login);
		
		
		
		check=false;
		String pass;
		do {
			System.out.println("Enter password (at least 6 characters and 1 number)");
			 pass = Scan.getSc().nextLine();
			check=!checkPass(pass);
			if(check) {
				System.out.println("Wrone password (at least 6 characters and 1 number)");
			}
				
		}while(check);
		System.out.println(pass);
			reader.setPass(pass);
			
			check=true;
			do {
				System.out.println("Enter status: 1-Reader, 2-Librarian");
				
				int i =Scan.enterInt();
				switch(i) {
				case 1:
					reader.setStatus("reader");
					check=false;
					break;
				case 2:
					reader.setStatus("librarian");
					check=false;
					break;
				default:
					System.out.println("Enter the number of the menu item");
					break;							
				}
				
				
			}while(check);
		
		System.out.println("Enter your surname");
		String surname = Scan.getSc().nextLine();
		reader.setSurname(surname);
		System.out.println("Enter your name");
		String name = Scan.getSc().nextLine();
		reader.setName(name);
		System.out.println("Enter your lastname");
		String secondname = Scan.getSc().nextLine();
		reader.setSecondName(secondname);
		System.out.println("Enter your phone nunber");
		String phoneNumber = Scan.getSc().nextLine();
		reader.setPhoneNumber(phoneNumber);
		
		return reader;
	}
	
	
public static Book createBook() {
	Book book =new Book();
	System.out.println("Enter title book");
	String title = Scan.getSc().nextLine();
	book.setTitle(title);
	System.out.println("Enter autor name");
	String name = Scan.getSc().nextLine();
	System.out.println("Enter autor surname");
	String surname = Scan.getSc().nextLine();
	Autor autor =new Autor(name, surname);
	book.setAutor(autor);
	System.out.println("Enter anatation book");
	String annotation = Scan.getSc().nextLine();
	book.setAnnotation(annotation);
	
	return book;
}	
	
	
	
	
	
private static boolean checkPass(String pass) {
	
	Pattern p =Pattern.compile("^(?=.*\\d)(?=.*[A-Za-z])[^\\s]{7,}$");
	//Pattern p =Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])[^\\s]{7,}$");
	Matcher m = p.matcher(pass);
	return m.matches();			
	
}	
private static boolean checkLogin(String login) {
	for(Reader r: dao.outReaderList()) {
		if(r.getLogin().equals(login)) {
			return true;
		}
		
	}
	return false;
}	

private static Reader findReaderlogin(String login, String pass) {
	Reader checkReader=null;
	for(Reader reader: dao.outReaderList()) {
		
		if((reader.getLogin().equals(login)) && (reader.getPass().equals(pass))) {
			
			checkReader=reader;
		
		}
					
		
	}
	return checkReader;
}

 
public static void addBook(Book book) {
	dao.addBook(book);
}
public static void addReader(Reader reader) {
	dao.addReader(reader);
}

public static void viewCatalogBook() {
	System.out.println("2");
	if(!dao.outBookList().isEmpty()) {
	for(Book b: dao.outBookList()) {
		System.out.println("3");
		System.out.println(b.toStringSneaky());
		
	}
	}else {System.out.println("Book catalog is empty");}
	
	}
public static void viewReaderList() {
	
	if(!dao.outReaderList().isEmpty()) {
		
	for (Reader r: dao.outReaderList()) {
		System.out.println("Reader Index- "+(dao.outReaderList().indexOf(r)+1));
		System.out.println(r);
	
}
	} else {System.out.println("Reader list is empty");}
}


public static void enterSessionDate() {
	
	if(Run.getSessionDate()==null) {
		System.out.println("Enter the date of the library visit, date entry format - dd.mm.yyyy ");
		SimpleDateFormat sf =new SimpleDateFormat("dd.MM.yyyy");
		boolean check=false;
		do {
			try {
				GregorianCalendar gc=new GregorianCalendar();
				gc.setTime(sf.parse(Scan.getSc().nextLine())); 
				check=false;
			}
			
			catch(ParseException e) {
				System.out.println("Incorrect enter date format, need - dd.mm.yyyy, try again");
				check=true;
			}
			
		}while(check);
		
		
	}
	
}
public static boolean takeBook() {
	Reader reader=getReaderAtIndex();
	if(reader==null) {
		return false;
	}
	Book book =getBookAtID();
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
public static Reader getReaderAtIndex() {

	int i=0;
	List<Reader> list=dao.outReaderList();
	
		System.out.println("Enter Reader Index");
		
		 i =Scan.enterInt();
		if(((i-1)<0) && ((i-1)> list.size())) {
			System.out.println("Reader with this Index dont exist");
			return null;
		}
				
	

	return list.get((i-1));
	
}
public static Book getBookAtID() {

	int i=0;
	List<Book> list=dao.outBookList();

		System.out.println("Enter Book Id");
		i =Scan.enterInt();
		 for(Book b: list) {
			 if(b.getId()==i) {
				
				 return b;
			 }
			 
		 }
		
			System.out.println("Book with this Id dont exist");
	
	return null;
	
		
}
}
