package by.htp.main;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import by.htp.DAO.DAO;
import by.htp.DAO.implemented.Collection.DaoCollection;
import by.htp.actions.Run;
import by.htp.entities.Autor;
import by.htp.entities.Book;
import by.htp.entities.BookTransaction;
import by.htp.entities.Reader;
import by.htp.menu.MainMenu;

public class MainApp {
public static void main(String[] args) {

//	Reader reader =new Reader("Mihail", "Vlad", "Mitr", "root", "root", "librarian", "222-33-44", new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>());
//Run.addReader(reader);
//	
//	Run.getDao().addBook(new Book("Swann's Way", new Autor("Marcel", "Proust"), "Swann's Way, the first part of A la recherche de temps perdu, Marcel Proust's seven-part cycle, was published in 1913. In it, Proust introduces the themes that run through the entire work. The narrator recalls his childhood, aided by the famous madeleine; and describes M. Swann's passion for Odette. The work is incomparable. Edmund Wilson said \"[Proust] has supplied for the first time in literature an equivalent in the full scale for the new theory of modern physics.", 10));
//	Run.getDao().addBook(new Book("Don Quixote", new Autor("Miguel", " de Cervantes"), "Alonso Quixano, a retired country gentleman in his fifties, lives in an unnamed section of La Mancha with his niece and a housekeeper. He has become obsessed with books of chivalry, and believes their every word to be true, despite the fact that many of the events in them are clearly impossible. Quixano eventually appears to other people to have lost his mind from little sleep and food and because of so much reading.", 8));
//	Run.getDao().addBook(new Book("Ulysses", new Autor("James", "Joyce"), "Ulysses chronicles the passage of Leopold Bloom through Dublin during an ordinary day, June 16, 1904. The title parallels and alludes to Odysseus (Latinised into Ulysses), the hero of Homer's Odyssey (e.g., the correspondences between Leopold Bloom and Odysseus, Molly Bloom and Penelope, and Stephen Dedalus and Telemachus). Joyce fans worldwide now celebrate June 16 as Bloomsday.", 7));
//	Run.getDao().addBook(new Book("Moby Dick", new Autor("Herman", "Melville"), "First published in 1851, Melville's masterpiece is, in Elizabeth Hardwick's words, \"the greatest novel in American literature.\" The saga of Captain Ahab and his monomaniacal pursuit of the white whale remains a peerless adventure story but one full of mythic grandeur, poetic majesty, and symbolic power. Filtered through the consciousness of the novel's narrator, Ishmael, Moby-Dick draws us into a universe full of fascinating characters and stories, from the noble cannibal Queequeg to the natural history of whales, while reaching existential depths that excite debate and contemplation to this day.", 5));
//	Run.getDao().addBook(new Book("Hamlet", new Autor("William", "Shakespeare"), "The Tragedy of Hamlet, Prince of Denmark, or more simply Hamlet, is a tragedy by William Shakespeare, believed to have been written between 1599 and 1601. The play, set in Denmark, recounts how Prince Hamlet exacts revenge on his uncle Claudius, who has murdered Hamlet's father, the King, and then taken the throne and married Gertrude, Hamlet's mother. The play vividly charts the course of real and feigned madness—from overwhelming grief to seething rage—and explores themes of treachery, revenge, incest, and moral corruption.", 2));
//	Run.getDao().addBook(new Book("The Divine Comedy", new Autor("Dante", "Alighieri"), "Belonging in the immortal company of the great works of literature, Dante Alighieri's poetic masterpiece, The Divine Comedy, is a moving human drama, an unforgettable visionary journey through the infinite torment of Hell, up the arduous slopes of Purgatory, and on to the glorious realm of Paradise — the sphere of universal harmony and eternal salvation.", 1));
//	Run.addReader(new Reader("Sergei", "Petrovich", "Kulik", "reader1", "123456a", "reader", "222-66-77",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
//	Run.addReader(new Reader("Kol9n", "Pahanovich", "Saratov", "reader2", "123456a", "reader", "777-77-77",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
//	Run.addReader(new Reader("Sergei", "Abramovich", "Aladov", "reader3", "123456a", "reader", "233-65-88",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
//	Run.addReader(new Reader("Grigori", "Grigorevich", "Grishin", "reader4", "123456a", "reader", "559-66-55",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
//	Run.addReader(new Reader("Nikolaevna", "Maria", "Petros9n", "reader5", "123456a", "reader", "363-52-89",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
//	Run.addReader(new Reader("Skladovska9", "Maria", "Kuri", "reader2", "123456a", "reader", "777-77-77",new ArrayList<BookTransaction>(), new HashMap<BookTransaction, GregorianCalendar>()));
 new MainMenu().mainMenu();
}
}
