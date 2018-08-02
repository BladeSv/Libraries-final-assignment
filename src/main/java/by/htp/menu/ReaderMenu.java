package by.htp.menu;

import by.htp.actions.BookActions;
import by.htp.actions.Run;
import by.htp.entities.Reader;
import by.htp.utils.Scan;

public class ReaderMenu {

	public static boolean readerMenu(Reader reader){
		
		
		do {
			System.out.println();
			System.out.println("Hello reader. Your ID: "+(reader.getId()));
			if(Run.getDao().checkDebtReader(reader)) {
				System.out.println("You have books that you did not return within 30 days");
			}
			System.out.println("Select menu item");
			System.out.println("1-view book catalog");
			System.out.println("2-view detailed information about a particular book");
		
			System.out.println("3-return last menu");
		
			int i =Scan.enterInt();
			switch(i) {
			case 1:
				BookActions.viewCatalogBook();
				break;
			case 2:
				BookActions.detailedInformationBook();
				break;
				
				
				
			case 3:
				return true;
				
			default:
				System.out.println("Enter the number of the menu item");
				break;
			
			
			}
			
			
		}while(true);
	}
	
	
	
}
