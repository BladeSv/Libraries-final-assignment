package by.htp.menu;

import by.htp.actions.Run;
import by.htp.utils.Scan;

public class LibrarianMenu {
	

public static boolean librarianMenu() {

		do {
		System.out.println("Select menu item");
		System.out.println("1-add book");
		System.out.println("2-add reader");
		System.out.println("3-take the book by the reader");
		System.out.println("4-return a book");
		System.out.println("5-return last menu");
		try {
		int i =Integer.parseInt(Scan.getSc().nextLine());
		switch(i) {
		case 1:
			Run.addBook(Run.createBook());
			break;
		case 2:
			Run.addReader(Run.createReader());
			break;
			
			
			
		case 5:
			return true;
			
		default:
			System.out.println("Enter the number of the menu item");
			break;
		
		
		}
		}catch (java.lang.NumberFormatException e) {
			System.out.println("Incorrect enter format-Integer, try again");
		}
		
	}while(true);
	

	
	
	
	
	}
}
