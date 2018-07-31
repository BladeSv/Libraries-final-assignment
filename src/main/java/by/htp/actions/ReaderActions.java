package by.htp.actions;



import java.util.List;

import by.htp.DAO.DAO;

import by.htp.entities.Reader;
import by.htp.utils.Scan;

public class ReaderActions {

	private static DAO dao = Run.getDao();

	public static Reader createReader() {
		Reader reader = new Reader();
		boolean check = false;
		String login;
		do {
			System.out.println("Enter login");
			login = Scan.getSc().nextLine();

			check = Login.checkLogin(login);
			if (check) {
				System.out.println("This login alredy exist");
			}

		} while (check);
		reader.setLogin(login);

		check = false;
		String pass;
		do {
			System.out.println("Enter password (at least 6 characters and 1 number)");
			pass = Scan.getSc().nextLine();
			check = !Login.checkPass(pass);
			if (check) {
				System.out.println("Incorrect password entry");
			}

		} while (check);
	
		reader.setPass(pass);

		check = true;
		do {
			System.out.println("Enter status: 1-Reader, 2-Librarian");

			int i = Scan.enterInt();
			switch (i) {
			case 1:
				reader.setStatus("reader");
				check = false;
				break;
			case 2:
				reader.setStatus("librarian");
				check = false;
				break;
			default:
				System.out.println("Enter the number of the menu item");
				break;
			}

		} while (check);

		System.out.println("Enter your surname");
		String surname = Scan.getSc().nextLine();
		reader.setSurname(surname);
		System.out.println("Enter your name");
		String name = Scan.getSc().nextLine();
		reader.setName(name);
		System.out.println("Enter your lastname");
		String secondname = Scan.getSc().nextLine();
		reader.setSecondName(secondname);
		System.out.println("Enter your phone nunber");
		String phoneNumber = Scan.getSc().nextLine();
		reader.setPhoneNumber(phoneNumber);

		return reader;
	}

	public static void viewReaderList() {

		if (!dao.outReaderList().isEmpty()) {

			for (Reader r : dao.outReaderList()) {
				System.out.println("Reader Index- " + (dao.outReaderList().indexOf(r) + 1));
				System.out.println(r);

			}
		} else {
			System.out.println("Reader list is empty");
		}
	}
	public static Reader getReaderAtIndex() {

		int i=0;
		List<Reader> list=dao.outReaderList();
		
			System.out.println("Enter Reader Index");
			
			 i =Scan.enterInt();
			if(((i-1)<0) && ((i-1)> list.size())) {
				System.out.println("Reader with this Index dont exist");
				return null;
			}
					
		

		return list.get((i-1));
		
	} 	
	
public static void deleteReader() {
	Reader reader= getReaderAtIndex();
	if(reader!=null) {
		dao.deleteReader(reader);
		
	}
}

}
