package by.htp.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import by.htp.Base.BookBase;
import by.htp.Base.ReaderBase;
import by.htp.entities.Book;
import by.htp.entities.Reader;

public class DaoCollection implements DAO{
	
	BookBase bookBase=inputBookBase();
	ReaderBase readerBase=inputReaderBase();
	
	

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	public void addReader(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	public void takeBook(Reader reader, Book book) {
		// TODO Auto-generated method stub
		
	}

	public void returnBook(Reader reader, Book book) {
		// TODO Auto-generated method stub
		
	}

	public Reader login(String login, String pass) {
		Reader checkReader=null;
		for(Reader reader: readerBase.getReaderBase()) {
			if(reader.getLogin().equals(login) && reader.getPass().equals(pass)) {
				
				checkReader=reader;
				
			}
						
		}if(checkReader==null) {
		System.out.println("Reader with this login and password dont exist");	
		}
				
		return checkReader;
	}

	
	
	private ReaderBase inputReaderBase() {
		
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
	private BookBase inputBookBase() {
		
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
		
	
	private void outputReaderBase(ReaderBase readerBase)  {
		
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
		private void outputBookBase(BookBase bookBase)  {
			
			
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
	

