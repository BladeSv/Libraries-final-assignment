package by.htp.entities;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class BookTransaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4677423919610293197L;
private Reader reader;
private Book book;
private GregorianCalendar date;
public BookTransaction() {
	super();
	// TODO Auto-generated constructor stub
}
public BookTransaction(Reader reader, Book book, GregorianCalendar date) {
	super();
	this.reader = reader;
	this.book = book;
	this.date = date;
}
public Reader getReader() {
	return reader;
}
public void setReader(Reader reader) {
	this.reader = reader;
}
public Book getBook() {
	return book;
}
public void setBook(Book book) {
	this.book = book;
}
public GregorianCalendar getDate() {
	return date;
}
public void setDate(GregorianCalendar date) {
	this.date = date;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((book == null) ? 0 : book.hashCode());
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((reader == null) ? 0 : reader.hashCode());
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
	BookTransaction other = (BookTransaction) obj;
	if (book == null) {
		if (other.book != null)
			return false;
	} else if (!book.equals(other.book))
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (reader == null) {
		if (other.reader != null)
			return false;
	} else if (!reader.equals(other.reader))
		return false;
	return true;
}
@Override
public String toString() {
	return "BookTransaction [reader=" + reader + ", book=" + book + ", date=" + date + "]";
}

	
	
	
	
}
