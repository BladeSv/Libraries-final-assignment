import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;

public class BookBase implements Serializable{
	
	private List<Book> bookCatalog =new ArrayList<Book>();
	private Map <Book , BookTransaction> issuedBooks =new HashMap<Book, BookTransaction>();
	public BookBase(List<Book> bookCatalog, Map<Book, BookTransaction> issuedBooks) {
		super();
		this.bookCatalog = bookCatalog;
		this.issuedBooks = issuedBooks;
	}
	public BookBase() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Book> getBookCatalog() {
		return bookCatalog;
	}
	public void setBookCatalog(List<Book> bookCatalog) {
		this.bookCatalog = bookCatalog;
	}
	public Map<Book, BookTransaction> getIssuedBooks() {
		return issuedBooks;
	}
	public void setIssuedBooks(Map<Book, BookTransaction> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookCatalog == null) ? 0 : bookCatalog.hashCode());
		result = prime * result + ((issuedBooks == null) ? 0 : issuedBooks.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookBase other = (BookBase) obj;
		if (bookCatalog == null) {
			if (other.bookCatalog != null)
				return false;
		} else if (!bookCatalog.equals(other.bookCatalog))
			return false;
		if (issuedBooks == null) {
			if (other.issuedBooks != null)
				return false;
		} else if (!issuedBooks.equals(other.issuedBooks))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookBase [bookCatalog=" + bookCatalog + ", issuedBooks=" + issuedBooks + "]";
	}
	
	
	
	
}
