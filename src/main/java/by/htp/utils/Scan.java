package by.htp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;

import by.htp.actions.Run;

public class Scan {
private static Scanner sc=null;
private Scan() {}
public static Scanner getSc() {
	if(sc==null) 
	{
		sc =new Scanner(System.in);
				
	}
	return sc;
}


public static int enterInt() {
	boolean check=false;
	int i=0;
	do {
	try {
		 i =Integer.parseInt(getSc().nextLine());
		
		check=false;
}catch (java.lang.NumberFormatException e) {
	System.out.println("Incorrect enter format-Integer, try again");
	check=true;
}
	
}while(check);

	return i;
}
public static GregorianCalendar enterDate() {
	GregorianCalendar gc=null;
	
		System.out.println("Enter the date, date entry format - dd.mm.yyyy ");
		SimpleDateFormat sf =new SimpleDateFormat("dd.MM.yyyy");

		boolean check=false;
		do {
			try {
			 gc=new GregorianCalendar();
				gc.setTime(sf.parse(Scan.getSc().nextLine())); 
				check=false;
			}
			
			catch(ParseException e) {
				System.out.println("Incorrect enter date format, need - dd.mm.yyyy, try again");
				check=true;
			}
			
		}while(check);
		
		
	
	return gc;
}


}