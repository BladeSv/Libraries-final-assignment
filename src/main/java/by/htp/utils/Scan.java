package by.htp.utils;

import java.util.Scanner;

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
}