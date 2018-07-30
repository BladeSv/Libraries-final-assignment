package by.htp.menu;

import java.text.SimpleDateFormat;

import by.htp.actions.Run;
import by.htp.utils.Scan;

public class MainMenu {

	public void mainMenu() {
		Run.enterSessionDate();
		do {
		System.out.println("library named after Ostap Bender");
		System.out.println("Select menu item");
		System.out.println("1-Login");
		System.out.println("2-Exit");
		
		int i =Scan.enterInt();
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
	
		
	}while(true); 
	}
}
