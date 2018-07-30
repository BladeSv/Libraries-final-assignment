package by.htp.DAO;

import java.util.GregorianCalendar;
import java.util.List;

import by.htp.entities.Book;
import by.htp.entities.Reader;

public interface DAO {
public void addBook(Book book);
public void addReader(Reader reader);
public void takeBook(Reader reader,Book book, GregorianCalendar date);
public void returnBook(Book book);

public List<Reader> outReaderList();
public List<Book> outBookList();
public boolean checkDebtReader(Reader reader);
public boolean checkBookHand(Reader reader);
public boolean checkBookAvailability(Book book); 

}
