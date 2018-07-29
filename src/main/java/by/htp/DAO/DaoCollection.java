package by.htp.DAO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import by.htp.Base.BookBase;
import by.htp.Base.ReaderBase;
import by.htp.entities.Book;
import by.htp.entities.Reader;

public class DaoCollection implements DAO{
	DaoCollectionSerial daoSer =new DaoCollectionSerial();
	BookBase bookBase=daoSer.inputBookBase();
	ReaderBase readerBase=daoSer.inputReaderBase();
	
	private  void save() {
		daoSer.outputReaderBase(readerBase);
		daoSer.outputBookBase(bookBase);
	}
	public void addBook(Book book) {
		bookBase.getBookCatalog().add(book);
		save();
		
	}

	public void addReader(Reader reader) {
		readerBase.getReaderBase().add(reader);
		save();
	}

	public void takeBook(Reader reader, Book book) {
		// TODO Auto-generated method stub
		
	}

	public void returnBook(Reader reader, Book book) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Reader> outReaderList() {
	
		return readerBase.getReaderBase();
	}

	public Reader login(String login, String pass) {
		Reader checkReader=null;
		for(Reader reader: readerBase.getReaderBase()) {
			if(reader.getLogin().equals(login) && reader.getPass().equals(pass)) {
				
				checkReader=reader;
				
			}
						
			
		}
				
		return checkReader;
	}

	
	
	

	
	
	
	
	
	}
	

