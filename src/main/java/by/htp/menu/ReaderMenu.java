package by.htp.menu;

import by.htp.actions.Run;
import by.htp.utils.Scan;

public class ReaderMenu {

	public static boolean readerMenu(){
		
		
		do {
			System.out.println("Select menu item");
			System.out.println("1-view book catalog");
			System.out.println("2-view detailed information about a particular book");
		
			System.out.println("3-return last menu");
		
			int i =Scan.enterInt();
			switch(i) {
			case 1:
				Run.viewCatalogBook();
				break;
			case 2:
				Run.addReader(Run.createReader());
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
