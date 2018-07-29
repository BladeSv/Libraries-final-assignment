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
}
