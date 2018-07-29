package by.htp.actions;

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

	static DAO dao =CreateDao.creatDao();
	
	public static boolean login() {
		String login;
		String pass;
		
		System.out.println("Enter login");
		login=Scan.getSc().nextLine();
		System.out.println("Enter password");
		pass =	login=Scan.getSc().nextLine();
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
			reader.setPass(pass);
			
			check=true;
			do {
				System.out.println("Enter status: 1-Reader, 2-Librarian");
				try {
				int i =Integer.parseInt(Scan.getSc().nextLine());
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
				}catch (java.lang.NumberFormatException e) {
					System.out.println("Incorrect enter format-Integer, try again");
				}
				
			}while(check);
		
		System.out.println("Enter your surname");
		String surname = Scan.getSc().nextLine();
		reader.setSurname(surname);
		System.out.println("Enter your name");
		String name = Scan.getSc().nextLine();
		reader.setSurname(name);
		System.out.println("Enter your lastname");
		String secondname = Scan.getSc().nextLine();
		reader.setSecondName(secondname);
	
		
		
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
	return book;
}	
	
	
	
	
	
private static boolean checkPass(String pass) {
	
	Pattern p =Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])[^\\s]{7,}$");
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
		if(reader.getLogin().equals(login) && reader.getPass().equals(pass)) {
			
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
}
