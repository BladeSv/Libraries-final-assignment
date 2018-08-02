package by.htp.actions;

import by.htp.DAO.DAO;
import by.htp.DAO.implemented.Collection.DaoCollection;
import by.htp.DAO.implemented.SQL.DaoSQL;
import by.htp.utils.PropertiesManager;

public class CreateDao {
	public static DAO creatDao() {
		DAO dao = null;
		if (PropertiesManager.getStatus().equals("1")) {
			dao = new DaoCollection();
		}

		if (PropertiesManager.getStatus().equals("2")) {
			dao = new DaoSQL();
		}
		
		
		return dao;
	}
}
