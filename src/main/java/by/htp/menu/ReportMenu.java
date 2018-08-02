package by.htp.menu;

import by.htp.actions.Reports;

import by.htp.utils.Scan;

public class ReportMenu {

	
	public static boolean reportMenu() {
		
		
		
		do {
			System.out.println();
			System.out.println("Select menu item");
			System.out.println("1- report on readers who are in arrears on the return of books");
			System.out.println("2- Aaccount of books read");
			System.out.println("3- a report on employees who read at least 2 and not more than 8 books per 30 days.");
			System.out.println("4- return last menu");
		
			int i =Scan.enterInt();
			switch(i) {
			case 1:
				Reports.debtReport();
				break;
			case 2:
				Reports.booksReadReport();
				break;
			case 3:
				Reports.employeesReport();
				break;	
				
				
			case 4:
				return true;
				
			default:
				System.out.println("Enter the number of the menu item");
				break;
			
			
			}
			
			
		}while(true);
		
	}
}
