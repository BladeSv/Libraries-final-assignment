package by.htp.main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import by.htp.DAO.DAO;
import by.htp.DAO.implemented.Collection.DaoCollection;
import by.htp.actions.Run;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;
import by.htp.menu.MainMenu;

public class MainApp {
public static void main(String[] args) {

//	Reader reader =new Reader("Mihail", "Vlad", "Mitr", "root", "root", 0, "librarian", "222-33-44", new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>());
//Run.addReader(reader);
 new MainMenu().mainMenu();
}
}
