package by.htp.DAO.implemented.Collection;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import by.htp.Base.BookBase;
import by.htp.Base.ReaderBase;
import by.htp.DAO.DAO;
import by.htp.actions.Run;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;


public class DaoCollection implements DAO {
	DaoCollectionSerial daoSer = new DaoCollectionSerial();
	BookBase bookBase = daoSer.inputBookBase();
	ReaderBase readerBase = daoSer.inputReaderBase();
	// BookBase bookBase=new BookBase();
	// ReaderBase readerBase =new ReaderBase();

	{
		setIdContBook();
		setIdContReader();
	}

	private void save() {
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

	public void returnBook(Book book, GregorianCalendar date) {
		if (bookBase.getIssuedBooks().containsKey(book)) {
			BookTransaction bookTransaction = bookBase.getIssuedBooks().get(book);
		
			bookTransaction.getReader().getReturnBooke().add( date);
			bookTransaction.getReader().getTakenBooks().remove(bookTransaction);
			
			bookBase.getIssuedBooks().remove(book);

		}

	}

	public List<Reader> outReaderList() {

		return readerBase.getReaderBase();
	}


	@Override
	public List<Book> outBookList() {

		return bookBase.getBookCatalog();
	}

	@Override
	public void takeBook(Reader reader, Book book, GregorianCalendar date) {

		BookTransaction bookTransaction = new BookTransaction(reader, book, date);
		bookBase.getIssuedBooks().put(book, bookTransaction);
		reader.getTakenBooks().add(bookTransaction);
		save();

	}

	@Override
	public boolean checkDebtReader(Reader reader) {
		if (reader.getTakenBooks().isEmpty()) {
			return false;
		}

		for (BookTransaction bt : reader.getTakenBooks()) {
			GregorianCalendar gc = (GregorianCalendar) bt.getDate().clone();
			gc.add(GregorianCalendar.DATE, 30);
			if (gc.before(Run.getSessionDate())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkBookHand(Reader reader) {
		if (reader.getTakenBooks().isEmpty()) {
			return false;
		}
		if (reader.getTakenBooks().size() >= 3) {

			return true;
		}
		return false;
	}

	@Override
	public boolean checkBookAvailability(Book book) {
		if (bookBase.getIssuedBooks().containsKey(book)) {
			return true;
		}
		return false;
	}

	@Override
	public Map<Book, BookTransaction> bookTransactionList() {

		return bookBase.getIssuedBooks();
	}

	@Override
	public void deleteBook(Book book) {
		bookBase.getBookCatalog().remove(book);
		bookBase.getIssuedBooks().remove(book);

	}

	@Override
	public void deleteReader(Reader reader) {
		readerBase.getReaderBase().remove(reader);
		if (!reader.getTakenBooks().isEmpty()) {
			for (BookTransaction bt : reader.getTakenBooks()) {
				bookBase.getIssuedBooks().remove(bt.getBook());

			}

		}

	}
	private void setIdContBook() {

		if (!bookBase.getBookCatalog().isEmpty()) {
			int i = 0;
			for (Book b : bookBase.getBookCatalog()) {
				if (b.getId() > i) {
					i = b.getId();
				}

			}
			Book.setId_count(i);
		} else
			System.out.println("Book catalog empty");

	}
	private void setIdContReader() {

		if (!readerBase.getReaderBase().isEmpty()) {
			int i = 0;
			for (Reader b : readerBase.getReaderBase()) {
				if (b.getId() > i) {
					i = b.getId();
				}

			}
			Reader.setId_count(i);
		} else
			System.out.println("Book catalog empty");

	}



}
