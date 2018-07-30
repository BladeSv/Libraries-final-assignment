package by.htp.main;

import java.util.ArrayList;

import by.htp.DAO.DAO;
import by.htp.DAO.DaoCollection;
import by.htp.actions.Run;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;
import by.htp.menu.MainMenu;

public class MainApp {
public static void main(String[] args) {
//	Reader reader =new Reader("Mihail", "Vlad", "Mitr", "root", "root", 0, "librarian", new ArrayList<BookTransaction>());
//	Run.addReader(reader);
 new MainMenu().mainMenu();
}
}
