package by.htp.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp.DAO.DAO;
import by.htp.entities.Reader;
import by.htp.menu.LibrarianMenu;
import by.htp.menu.ReaderMenu;
import by.htp.utils.Scan;

public class Login {

	private static DAO dao = Run.getDao();

	public static boolean login() {
		String login;
		String pass;

		System.out.println("Enter login");
		login = Scan.getSc().nextLine();

		System.out.println("Enter password");
		pass = Scan.getSc().nextLine();
		if (!checkPass(pass)) {
			System.out.println("Enter password (at least 6 characters and 1 number)");
			return false;
		}
		Reader reader = findReaderlogin(login, pass);
		if (reader == null) {
			System.out.println("Reader with this login and password dont exist");
			return false;
		}
		if (reader.getStatus().equals("reader")) {

			return ReaderMenu.readerMenu(reader);
		} else if (reader.getStatus().equals("librarian")) {

			return LibrarianMenu.librarianMenu();
		}

		System.out.println("You do not have a library card");
		return false;
	}

	public static boolean checkPass(String pass) {

		Pattern p = Pattern.compile("^(?=.*\\d)(?=.*[A-Za-z])[^\\s]{7,}$");

		// =Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])[^\\s]{7,}$");
		Matcher m = p.matcher(pass);
		return m.matches();

	}

	public static boolean checkLogin(String login) {
		for (Reader r : dao.outReaderList()) {
			if (r.getLogin().equals(login)) {
				return true;
			}

		}
		return false;
	}

	private static Reader findReaderlogin(String login, String pass) {
		Reader checkReader = null;
		for (Reader reader : dao.outReaderList()) {

			if ((reader.getLogin().equals(login)) && (reader.getPass().equals(pass))) {

				checkReader = reader;

			}

		}
		return checkReader;
	}
}
