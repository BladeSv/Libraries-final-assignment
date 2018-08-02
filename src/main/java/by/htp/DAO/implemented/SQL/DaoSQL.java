package by.htp.DAO.implemented.SQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import by.htp.DAO.DAO;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;
import static by.htp.utils.BDConection.getPS;
import by.htp.utils.SqlQueriesManager;

public class DaoSQL implements DAO{


	@Override
	public void addBook(Book book) {
		try(PreparedStatement pre=getPS(SqlQueriesManager.addBook())) {
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addReader(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeBook(Reader reader, Book book, GregorianCalendar date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReader(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Book, BookTransaction> bookTransactionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reader> outReaderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> outBookList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkDebtReader(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBookHand(Reader reader) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBookAvailability(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

}
