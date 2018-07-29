package by.htp.actions;

import by.htp.DAO.DAO;
import by.htp.DAO.DaoCollection;
import by.htp.utils.PropertiesManager;
import by.htp.DAO.DAO;
public class CreateDao {
public static DAO creatDao() {
	DAO dao=null;
	if (PropertiesManager.getStatus().equals("1")) {
		dao=new DaoCollection();
	}
	
	return dao;
}
}
