package by.htp.DAO;

import java.util.List;

import by.htp.entities.Book;
import by.htp.entities.Reader;

public interface DAO {
public void addBook(Book book);
public void addReader(Reader reader);
public void takeBook(Reader reader,Book book);
public void returnBook(Reader reader,Book book);
public Reader login(String login, String pass);
public List<Reader> outReaderList();

}
