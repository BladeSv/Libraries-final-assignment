package by.htp.actions;

import by.htp.DAO.DAO;
import by.htp.DAO.implemented.Collection.DaoCollection;
import by.htp.DAO.implemented.SQL.DaoSQL;

import by.htp.utils.Scan;

public class CreateDao {
	public static DAO creatDao() {
		DAO dao = null;
		int y = 0;
		boolean cheak = true;
		do {
			System.out.println();
			System.out.println("Choose with what base you will work");
			System.out.println("Select menu item");
			System.out.println("1-Database serialized collections");
			System.out.println("2-SQL database");

			int i = Scan.enterInt();
			switch (i) {
			case 1:
				y = 1;
				cheak = false;
				break;
			case 2:
				y = 2;
				cheak = false;
				break;
			default:
				System.out.println("Enter the number of the menu item");
				break;

			}

		} while (cheak);

		if (y == 1) {
			dao = new DaoCollection();
		}

		if (y == 2) {
			dao = new DaoSQL();
		}

		return dao;
	}
}
