package by.htp.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.htp.Base.BookBase;
import by.htp.Base.ReaderBase;

public class DaoCollectionSerial {
	
	
	

	
public  ReaderBase inputReaderBase() {
		
		ObjectInputStream ois;
		ReaderBase readerBase = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("/libraries/src/main/resources/SerializableBase/ReaderBase.ser"));
			readerBase = (ReaderBase)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File ReaderBase.ser not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't read file ReaderBase.ser");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("In file ReaderBase.ser save not ReaderBase");
			e.printStackTrace();
		}
		
		return readerBase;
		}
public  BookBase inputBookBase() {
		
		ObjectInputStream ois;
		BookBase bookBase = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("/libraries/src/main/resources/SerializableBase/BookBase.ser"));
			bookBase = (BookBase)ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("File BookBase.ser not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't read file BookBase.ser");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("In file BookBase.ser save not BookBase");
			e.printStackTrace();
		}
		
		return bookBase;
		}	
		
	
public  void outputReaderBase(ReaderBase readerBase)  {
		
		;
		try {
			ObjectOutputStream ous=ous = new ObjectOutputStream(new FileOutputStream("/libraries/src/main/resources/SerializableBase/ReaderBase.ser"));
			ous.writeObject(readerBase);
			ous.flush();
			ous.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File ReaderBase.ser not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Can't write file ReaderBase.ser");
			e.printStackTrace();
		}
	}
public  void outputBookBase(BookBase bookBase)  {
			
			
			try {
				ObjectOutputStream ous=ous = new ObjectOutputStream(new FileOutputStream("/libraries/src/main/resources/SerializableBase/BookBase.ser"));
				ous.writeObject(bookBase);
				ous.flush();
				ous.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File ReaderBase.ser not found");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Can't write file ReaderBase.ser");
				e.printStackTrace();
			}
	
	}
}
