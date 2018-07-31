package by.htp.menu;

import by.htp.actions.BookActions;
import by.htp.actions.ReaderActions;
import by.htp.actions.Run;
import by.htp.utils.Scan;

public class LibrarianMenu {
	

public static boolean librarianMenu() {

		do {
		System.out.println();
		System.out.println("Select menu item");
		System.out.println("1-view catalog book");
		System.out.println("2-view reader list");
		System.out.println("3-add book");
		System.out.println("4-add reader");		
		System.out.println("5-take the book by the reader");
		System.out.println("6-return a book");
		System.out.println("7-delete book");
		System.out.println("8-delete reader");
		System.out.println("9-preview reports");
		System.out.println("10-return last menu");
		System.out.println();
		System.out.println("11-Init BookTransaction (technical function)");
		
		int i =Scan.enterInt();
		switch(i) {
		
		
		
		case 1:
			BookActions.viewCatalogBook();			
			break;
		case 2:
			ReaderActions.viewReaderList();
			
			break;
		case 3:
			System.out.println("1");
			Run.addBook(BookActions.createBook());
			break;	
		case 4:
			Run.addReader(ReaderActions.createReader());
			break;
		case 5:
			Run.takeBook();
			break;
		case 6:
			Run.returnBook();
			break;
		case 7:
			BookActions.deleteBook();
			break;		
		case 8:
		ReaderActions.deleteReader();
			break;			
			case 9:
			ReportMenu.reportMenu();
			break;	
		case 10:
			return true;
		case 11:
			Run.insertBookTransaction();
				break;		
			
		default:
			System.out.println("Enter the number of the menu item");
			break;
		
		
		}
		
		
	}while(true);
	

	
	
	
	
	}
}
