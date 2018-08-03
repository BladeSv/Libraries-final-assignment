package by.htp.DAO.implemented.SQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import by.htp.DAO.DAO;
import by.htp.actions.Run;
import by.htp.entities.Autor;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;
import static by.htp.utils.BDConection.getPS;
import static by.htp.utils.SqlQueriesManager.*;

public class DaoSQL implements DAO{


	@Override
	public void addBook(Book book) {
		
		
		
		try(PreparedStatement ps=getPS(addBookDB())) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAutor().getName());
			ps.setString(3, book.getAutor().getSurname());
			ps.setString(4, book.getAnnotation());
			ps.setInt(5, book.getNumberOutput());
			
			ps.executeUpdate();
		
		} catch (SQLException e) {
			System.err.println("Cant add book");		
		}
		
	}

	@Override
	public void addReader(Reader reader) {
		
		
		
		try(PreparedStatement ps=getPS(addReaderDB())) {
			ps.setString(1, reader.getName());
			ps.setString(2, reader.getSecondName());
			ps.setString(3, reader.getSurname());
			ps.setString(4, reader.getLogin());
			ps.setString(5, reader.getPass());
			ps.setString(6, reader.getStatus());
			ps.setString(7, reader.getPhoneNumber());
		
			ps.executeUpdate();
	
		} catch (SQLException e) {
			System.err.println("Cant add reader");		
		
		}
		
	}

	@Override
	public void takeBook(Reader reader, Book book, GregorianCalendar date) {
		try(PreparedStatement ps=getPS(takeBookDB()) ){
		ps.setInt(1, book.getId());
		ps.setInt(2, reader.getId());
		ps.setDate(3, new Date(date.getTimeInMillis()));
			ps.executeUpdate();
	
		} catch (SQLException e) {
			System.err.println("Cant take book");		
		
		}
		
	}

	@Override
	public void returnBook(Book book,GregorianCalendar date) {
	
		int idReader = 0;
		try(PreparedStatement ps=getPS(outReaderFromBookTransByBookDB()) ){
		
			
			ps.setInt(1, book.getId());
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			idReader=rs.getInt(1);
		
			} catch (SQLException e) {
				System.err.println("Cant outReaderFromBookTransDB");
			
			
			}
		
		
	
		try(PreparedStatement ps=getPS(addReturnBookDB()) ){
			ps.setInt(1, idReader);		
			ps.setDate(2, new Date(date.getTimeInMillis()));
			ps.executeUpdate();			
			} catch (SQLException e) {
				System.err.println("Cant add returnBase book");		
				e.printStackTrace();
			
			}
		
		try(PreparedStatement ps=getPS(deleteFromBookTransByBookDB()) ){
			ps.setInt(1, book.getId());
	
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del book from book transaction base");		
				e.printStackTrace();
			
			}
		
		
	}

	@Override
	public void deleteBook(Book book) {
		try(PreparedStatement ps=getPS(deleteFromBookBaseByBookDB()) ){
			ps.setInt(1, book.getId());
	
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del book from book base");		
				e.printStackTrace();
			
			}
		try(PreparedStatement ps=getPS(deleteFromBookReturnByBookDB()) ){
			ps.setInt(1, book.getId());
	
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del book from returnBook base");		
				e.printStackTrace();
			
			}
		try(PreparedStatement ps=getPS(deleteFromBookTransByBookDB()) ){
			ps.setInt(1, book.getId());
	
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del book from transaction base");		
				e.printStackTrace();
			
			}

		
	}

	@Override
	public void deleteReader(Reader reader) {

	
		try(PreparedStatement ps=getPS(deleteFromReaderBaseByReaderDB()) ){
			ps.setInt(1, reader.getId());
			
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del reader from readerBase");		
			
			}
		try(PreparedStatement ps=getPS(deleteFromBookTransByReaderDB()) ){
			ps.setInt(1, reader.getId());
		
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del reader from transaction base");		
			
			}
		try(PreparedStatement ps=getPS(deleteFromBookReturnByReaderDB()) ){
			ps.setInt(1, reader.getId());
		
			ps.executeUpdate();
			
			} catch (SQLException e) {
				System.err.println("Cant del reader from return base");		
			
			}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public boolean checkDebtReader(Reader reader) {
	boolean check=false;
	try(PreparedStatement ps=getPS(outDateFromBookTransByReaderDB()) ){
		ps.setInt(1, reader.getId());
	
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Date date=rs.getDate(1);
			
			
			
			long difference =Run.getSessionDate().getTimeInMillis()-date.getTime();				
			
			int days = (int) (difference / (24 * 60 * 60 * 1000));
			if(days>30) {
				check=true;
			}
			
					}
		

		
		} catch (SQLException e) {
			System.err.println("Cant del reader");		
		
		}
		
		
	return check;
	}

	@Override
	public boolean checkBookHand(Reader reader) {
		boolean check=false;
		try(PreparedStatement ps=getPS(outCounBookTransByReaderDB()) ){
			ps.setInt(1, reader.getId());
		
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int count=rs.getInt(1);
				if(count>=3) {
					check=true;	
					
				}
			}
			

			
			} catch (SQLException e) {
				System.err.println("Cant del reader");		
			
			}
			
			
		return check;
		}
	

	@Override
	public boolean checkBookAvailability(Book book) {


		
		boolean check=false;
		try(PreparedStatement ps=getPS(outReaderFromBookTransByBookDB()) ){
			ps.setInt(1, book.getId());
		
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
			
					check=true;	
					
				}
			
			

			
			} catch (SQLException e) {
				System.err.println("Cant del reader");		
			
			}
			
			
		return check;
		}
	
	
	
	
	
	
	@Override
	public Map<Book, BookTransaction> bookTransactionList() {
		
		Map<Book, BookTransaction> bookTransactionList =new HashMap<>();
		List<BookTransaction> listBookTransaction=new ArrayList<>();
		List<Reader> list=new ArrayList<>();
		try(PreparedStatement ps=getPS(outReaderListDB()) ){
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				list.add(buildReader(rs));
				
			}
		
			} catch (SQLException e) {
				System.err.println("Cant reader list");		
			
			}
		try(PreparedStatement ps=getPS(outTransListDB()) ){
			ResultSet rs=ps.executeQuery();
			
			listBookTransaction=buildBookTransactionList(rs, list);
		
			} catch (SQLException e) {
				System.err.println("Cant reade Book Transaction list");		
			
			}
		
		try(PreparedStatement ps=getPS(outReturnBooListkDB()) ){
			ResultSet rs=ps.executeQuery();
			addReturnBook(rs, list);
		
		
			} catch (SQLException e) {
				System.err.println("Cant reade Book Transaction list");		
			
			}
		
		for(BookTransaction bt :listBookTransaction) {
			bookTransactionList.put(bt.getBook(), bt);
			
		}
		
		return bookTransactionList;
	}

	
	
	
	
	
	@Override
	public List<Reader> outReaderList() {
		List<Reader> list=new ArrayList<>();
		
		try(PreparedStatement ps=getPS(outReaderListDB()) ){
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				list.add(buildReader(rs));
				
			}
		
			} catch (SQLException e) {
				System.err.println("Cant reader list");		
			
			}
		
	
		
		try(PreparedStatement ps=getPS(outTransListDB()) ){
			ResultSet rs=ps.executeQuery();
			
			buildBookTransactionList(rs, list);
		
			} catch (SQLException e) {
				System.err.println("Cant reade Book Transaction list");		
			
			}
		
		try(PreparedStatement ps=getPS(outReturnBooListkDB()) ){
			ResultSet rs=ps.executeQuery();
			addReturnBook(rs, list);
		
		
			} catch (SQLException e) {
				System.err.println("Cant reade Book Transaction list");		
			
			}
		return list;
		
	}

	@Override
	public List<Book> outBookList() {
		List<Book> list=new ArrayList<>();
		try(PreparedStatement ps=getPS(outBookListDB()) ){
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				list.add(buildBook(rs));
				
			}
		
			} catch (SQLException e) {
				System.err.println("Cant take book");		
			
			}
		return list;
	}


	
	private Book buildBook(ResultSet rs) throws SQLException {
		int id=rs.getInt(1);
		String title=rs.getString(2);
		String autorName=rs.getString(3);
		String autorSurname=rs.getString(4);
		String annotation =rs.getString(5);
		int numberOutput=rs.getInt(6);
		Autor autor=new Autor(autorName, autorSurname);
		
		Book book =new Book(id, title, autor, annotation, numberOutput);
		return book;
	
		
	}
	private Reader buildReader(ResultSet rs) throws SQLException {
		int id=rs.getInt(1);
		String name=rs.getString(2);
		String secondName=rs.getString(3);
		String surname=rs.getString(4);
		String login=rs.getString(5);
		String pass=rs.getString(6);
		String status=rs.getString(7);
		String phoneNumber=rs.getString(8);
		
		
		Reader reader =new Reader(id, name, secondName, surname, login, pass, status, phoneNumber, new ArrayList<BookTransaction>(), new ArrayList< GregorianCalendar>());
		return reader;
	}
private List<BookTransaction> buildBookTransactionList(ResultSet rs,List<Reader> readerList) throws SQLException{
	List<BookTransaction> BookTransList=new ArrayList<>();
	while(rs.next()) {
		Book book=buildBook(rs);
		
		int idReader=rs.getInt(9);
		
		GregorianCalendar takenDate=new GregorianCalendar();
		takenDate.setTimeInMillis(rs.getDate(10).getTime());
		
	for(Reader r :readerList) {
		if(r.getId()==idReader) {
		BookTransaction bookTransaction =new BookTransaction(r, book, takenDate);
		r.getTakenBooks().add(bookTransaction);
		BookTransList.add(bookTransaction);
		}
	}
	}
	return BookTransList;
	
}



private void addReturnBook(ResultSet rs,List<Reader> readerList) throws SQLException{
	while(rs.next()) {
		
		
		int idReader=rs.getInt(2);
		GregorianCalendar returnDate=new GregorianCalendar();
		returnDate.setTimeInMillis(rs.getDate(3).getTime());
		for(Reader r :readerList) {
			if(r.getId()==idReader) {
				r.getReturnBooke().add(returnDate);
			}
			}
		
	}
}
}
