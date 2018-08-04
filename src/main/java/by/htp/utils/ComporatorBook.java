package by.htp.utils;

import java.util.Comparator;

import by.htp.entities.Book;

public class ComporatorBook implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {

		return o2.getNumberOutput() - o1.getNumberOutput();
	}

}
