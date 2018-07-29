package by.htp.menu;

import by.htp.actions.Run;
import by.htp.utils.Scan;

public class MainMenu {

	public void mainMenu() {
		do {
		System.out.println("library named after Ostap Bender");
		System.out.println("Select menu item");
		System.out.println("1-Login");
		System.out.println("2-Exit");
		try {
		int i =Integer.parseInt(Scan.getSc().nextLine());
		switch(i) {
		case 1:
			Run.login();
			break;
		case 2:
			System.exit(0);
			break;
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
