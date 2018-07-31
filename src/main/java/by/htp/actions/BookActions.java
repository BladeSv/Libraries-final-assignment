package by.htp.actions;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import by.htp.DAO.DAO;
import by.htp.entities.Autor;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;

import by.htp.utils.Scan;

public class BookActions {
	private static DAO dao = Run.getDao();

	public static Book createBook() {
		Book book = new Book();
		System.out.println("Enter title book");
		String title = Scan.getSc().nextLine();
		book.setTitle(title);
		System.out.println("Enter autor name");
		String name = Scan.getSc().nextLine();
		System.out.println("Enter autor surname");
		String surname = Scan.getSc().nextLine();
		Autor autor = new Autor(name, surname);
		book.setAutor(autor);
		System.out.println("Enter anatation book");
		String annotation = Scan.getSc().nextLine();
		book.setAnnotation(annotation);

		return book;
	}

	public static void viewCatalogBook() {

		if (!dao.outBookList().isEmpty()) {
			for (Book b : dao.outBookList()) {

				System.out.println(b.toStringSneaky());

			}
		} else {
			System.out.println("Book catalog is empty");
		}

	}

	public static Book getBookAtID() {

		int i = 0;
		List<Book> list = dao.outBookList();

		System.out.println("Enter Book Id");
		i = Scan.enterInt();
		for (Book b : list) {
			if (b.getId() == i) {

				return b;
			}

		}

		System.out.println("Book with this Id dont exist");

		return null;

	}

	public static void detailedInformationBook() {

		Book book = getBookAtID();
		if (book != null) {
			Map<Book, BookTransaction> bookTrans = dao.bookTransactionList();
			if (bookTrans.containsKey(book)) {
				System.out.println(book);
				System.out.println("this book taken "
						+ new SimpleDateFormat("dd.MM.yyyy").format(bookTrans.get(book).getDate().getTime())
						+ " reader:" + bookTrans.get(book).getReader().toString());
			} else {
				System.out.println(book);
			}

		}

	}
	
public static void deleteBook() {
	
	Book book =getBookAtID();
	if(book!=null) {
		dao.deleteBook(book);
		
		
	}
	
}
}
